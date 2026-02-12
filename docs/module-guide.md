# Devsona 멀티 모듈 구조 가이드

## 모듈 구성

```
devsona/
├── devsona-domain/        순수 도메인 (모델, 포트 인터페이스, 서비스, 공통 예외/유틸)
├── devsona-infra/         인프라 구현체 (JPA, 외부 API 클라이언트)
├── devsona-api/           진입점 (컨트롤러, DTO, 설정, Spring Boot main)
└── docs/
```

---

## 모듈별 역할

### devsona-domain

순수 비즈니스 로직. **JPA, Spring 어노테이션 없음.** 어떤 모듈에도 의존하지 않는다.

| 패키지 | 역할 |
|---|---|
| `domain.{도메인}.model` | 도메인 모델 (순수 Kotlin 클래스) |
| `domain.{도메인}.repository` | 포트 인터페이스 (infra에서 구현) |
| `domain.{도메인}.service` | 비즈니스 로직 |
| `domain.common.exception` | 공통 예외 클래스 (BusinessException, ErrorCode 등) |
| `domain.common.util` | 공통 유틸리티 |

도메인 목록: `auth`, `profile`, `integration`, `export`, `messaging`

### devsona-infra

외부 기술 구현체. domain의 포트 인터페이스를 구현한다.

| 패키지 | 역할 |
|---|---|
| `infra.persistence.{도메인}.entity` | JPA @Entity |
| `infra.persistence.{도메인}.repository` | Spring Data JPA Repository |
| `infra.persistence.{도메인}.mapper` | Entity ↔ Domain Model 변환 |
| `infra.persistence.config` | JPA, DataSource 설정 |
| `infra.github` | GitHub API 클라이언트 |
| `infra.rss` | RSS 피드 파서 |
| `infra.youtube` | YouTube API 클라이언트 |
| `infra.mail` | 이메일 발송 |

### devsona-api

Spring Boot 애플리케이션 진입점. 모든 모듈을 조합한다.

| 패키지 | 역할 |
|---|---|
| `api.{도메인}` | REST Controller, Request/Response DTO |
| `api.config` | Security, CORS 등 앱 레벨 설정 |
| `resources/application.yml` | 설정 파일 (DB 접속 정보 등) |

---

## 모듈 의존 관계

```
api → domain
api → infra
infra → domain
```

- **domain**: 의존 없음 (순수 Kotlin)
- **infra**: domain 의존 (JPA, 외부 라이브러리 포함)
- **api**: domain, infra 의존 (Spring Boot 실행)

> domain은 infra를 모른다. domain에서 정의한 repository 인터페이스를 infra가 구현하고,
> api 모듈의 Spring DI가 이를 주입한다.

---

## 도메인 ↔ 기능 매핑 (plan.md 기준)

| 도메인 | MVP 기능 | 설명 |
|---|---|---|
| auth | F1 | GitHub OAuth 로그인, 회원 관리 |
| profile | F2, F9 | 공개 프로필 페이지, 프로필 편집 |
| integration | F3, F4, F5, F6 | GitHub/블로그/유튜브 연동, 자동 동기화 |
| export | F7 | PDF 포트폴리오 출력 |
| messaging | F8 | DM/문의, 이메일 알림 |

---

## 마이크로서비스 전환 가이드

현재 구조는 모놀리스로 배포하되, 모듈 경계가 MSA 서비스 경계와 일치한다.

### 분리 순서 (권장)

1. **integration** - 외부 API 호출이 많아 독립 스케일링 효과가 가장 큼
2. **messaging** - 비동기 처리, 메일 발송은 별도 워커로 분리 적합
3. **export** - PDF 생성은 리소스 소모가 커서 독립 워커로 분리 적합
4. **auth** - 인증은 여러 서비스가 공유하므로 별도 서비스로 분리
5. **profile** - 핵심 서비스, 가장 마지막에 분리

### 분리 방법

1. 해당 도메인의 `domain/`, `infra/`, `api/` 패키지를 새 프로젝트로 추출
2. 공통 코드(`domain.common`)는 라이브러리로 공유하거나 각 서비스에 복사
3. 모듈 간 직접 호출을 REST API 또는 메시지 큐로 교체

---

## 참고 사항

- **application.yml**은 `devsona-api/src/main/resources/`에 위치
- **Makefile**의 PostgreSQL 기본 설정과 application.yml 값을 일치시킬 것
  - DB: `devsona`, User: `postgres`, Password: `postgres`, Port: `5432`
- **테스트**는 각 모듈의 `src/test/` 디렉토리에 작성
- domain 모듈 테스트는 순수 단위 테스트, infra/api 테스트는 통합 테스트로 구분
