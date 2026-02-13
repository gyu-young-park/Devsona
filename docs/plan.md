# Devsona 기획서 - Phase 1: 핵심 정의

## 1. 프로젝트 개요

| 항목 | 내용 |
|------|------|
| **프로젝트명** | DevLink |
| **한 줄 소개** | GitHub 연동만 하면 자동으로 완성되는 개발자 프로필 페이지 |
| **목표** | 개발자가 자신의 역량을 한 페이지로 보여줄 수 있는 브랜딩 허브 |

---

## 2. 타겟 사용자

### Primary User (핵심 사용자)

| 구분 | 페르소나 | 특징 | 우선순위 |
|------|----------|------|----------|
| A | 구직 중인 개발자 | 이력서 추가정보 란에 링크 하나로 모든 걸 보여주고 싶음 | 1 |
| B | 프리랜서 개발자 | 클라이언트에게 역량을 빠르게 증명해야 함 | 2 |
| C | 사이드 프로젝트 홍보 개발자 | 프로젝트 노출 채널이 부족 | 3 |
| D | 자기 브랜딩 주니어~미드 | 포트폴리오 사이트 만들 여력이 없음 | 3 |

> **MVP 타겟:** 구직 중인 개발자 (A)
> - 이력서 추가정보 란이 하나뿐인 경우, 링크 하나로 GitHub/블로그/유튜브/사이드 프로젝트를 전부 전달
> - 자동 동기화로 항상 최신 상태 유지
> - PDF 출력 기능으로 포트폴리오 제출도 가능

### Secondary User (보조 사용자)

| 구분 | 페르소나 | 특징 | MVP 포함 여부 |
|------|----------|------|---------------|
| E | 리크루터 | 개발자 역량을 빠르게 파악하고 싶음 | O (DM/문의 기능) |
| F | 외주 클라이언트 | 믿을 수 있는 개발자를 찾고 싶음 | O (DM/문의 기능) |

> - 프로필 페이지에서 바로 DM/메일 문의 가능
> - 연락이 오면 개발자에게 이메일 알림 발송

---

## 3. 핵심 문제 (Pain Point)

| # | 문제 | 대상 | 심각도 |
|---|------|------|--------|
| P1 | GitHub, 블로그, 포트폴리오가 흩어져 있어 한번에 보여주기 어려움 | 구직자, 프리랜서 | **상** |
| P2 | 포트폴리오 사이트를 만들어도 업데이트를 안 하게 됨 | 전체 | **상** |
| P3 | 비개발자(리크루터, 클라이언트)가 GitHub을 봐도 실력을 판단하기 어려움 | 리크루터, 클라이언트 | **중** |
| P4 | 자기 브랜딩을 하고 싶지만 시간/노력 대비 효과적인 수단이 없음 | 주니어~미드 | **상** |
| P5 | 유튜브, 깃허브, 블로그 등 여러 활동을 한 번에 보여주기 어려움 | 개발자 | **상** |
| P6 | 관심 분야, 추천 책/영상 목록을 보여줄 공간이 없음 | 개발자 | **하** (v2) |

> **MVP 해결 대상:** P1, P2, P4, P5 → 자동 동기화 + 원페이지 프로필로 해결
> **v2 확장:** P3 (시각화 강화), P6 (큐레이션 기능)

---

## 4. 솔루션 방향

### 핵심 가치 제안

| # | 가치 | 설명 | 우선순위 |
|---|------|------|----------|
| V1 | 자동 동기화 | GitHub/블로그/유튜브 연동, 항상 최신 상태 유지 | **1** |
| V2 | 원클릭 셋업 | 5분 안에 프로필 완성, 간단한 설정 | **2** |
| V5 | AI 요약 | 활동 기반으로 개발자 관심 분야/역량 자동 요약 | **3** |
| V3 | 비개발자 친화적 시각화 | 기술 스택/활동을 누구나 이해할 수 있게 표현 | **4** |
| V4 | 맞춤형 뷰 | 보는 사람에 따라 다른 화면 | **5** (v2) |

### 디자인 원칙

- 명함처럼 깔끔하고 신뢰감 있는 디자인
- 웹/모바일 모두 보기 편한 반응형
- 공유 링크가 짧고 깔끔해야 함 (devlink.io/username)

---

## 5. 플랫폼 & 기술 방향

| 항목 | 결정 |
|------|------|
| **플랫폼** | 반응형 웹 (웹 우선, 모바일 최적화) |
| **배포 형태** | SaaS (devlink.io/username) |
| **인프라** | AWS |
| **수익 모델** | 아래 참고 |

### 수익 모델 추천: Freemium 구독 (광고 X)

> **광고를 추천하지 않는 이유:**
> - DevLink는 "나를 보여주는 프로필 페이지" → 광고가 붙으면 **신뢰감이 떨어짐**
> - 리크루터/클라이언트가 보는 페이지에 광고가 있으면 프로페셔널하지 않음
> - 개발자 타겟 서비스는 사용자 수 대비 광고 단가가 낮아 수익성이 떨어짐
>
> **추천 모델:**
>
> | 플랜 | 가격 | 포함 기능 |
> |------|------|-----------|
> | Free | 0원 | 기본 프로필, GitHub 연동 1개, 기본 테마 |
> | Pro | 월 500원 (~$0.40) | 무제한 연동, 커스텀 도메인, PDF 출력, AI 요약, 프리미엄 테마, 분석 대시보드 |
>
> - 30일 무료 체험 후 전환
> - 500원은 진입장벽이 낮아 전환율 높일 수 있음
> - 추후 팀/기업 플랜 추가 가능

---

## 6. MVP 범위 요약

| 항목 | 내용 |
|------|------|
| **MVP 타겟** | 구직 중인 개발자 |
| **핵심 문제** | 흩어진 활동을 링크 하나로 전달 + 자동 업데이트 |
| **플랫폼** | 반응형 웹 (AWS) |
| **목표 일정** | 1주일 |

### MVP 핵심 기능

| # | 기능 | 설명 |
|---|------|------|
| F1 | 회원가입/로그인 | GitHub OAuth 로그인 |
| F2 | 프로필 페이지 | devlink.io/username 형태의 공개 프로필 |
| F3 | GitHub 연동 | 핀 프로젝트, 기여도 잔디, 기술 스택 자동 표시 |
| F4 | 블로그 연동 | RSS 기반 최신 글 자동 동기화 |
| F5 | 유튜브 연동 | 채널/영상 자동 동기화 |
| F6 | 자동 동기화 | 연동된 콘텐츠 주기적 업데이트 |
| F7 | PDF 출력 | 프로필을 PDF 포트폴리오로 다운로드 |
| F8 | DM/문의 기능 | 방문자가 메시지 전송 → 이메일 알림 |
| F9 | 프로필 편집 | 자기소개, 링크 추가/순서 변경, 테마 선택 |

### v2 확장 기능 (MVP 이후)

- AI 기반 개발자 역량 요약
- 비개발자 친화적 시각화 (기술 스택 차트 등)
- 맞춤형 뷰 (리크루터/개발자/클라이언트)
- 관심 분야, 추천 책/영상 큐레이션
- 커스텀 도메인 연결
- 분석 대시보드 (방문자 통계)

---

## 7. 기술 스택 & 아키텍처

### 기술 스택

| 항목 | 선택 |
|------|------|
| **언어** | Kotlin 2.2 |
| **프레임워크** | Spring Boot 4.0.2 |
| **DB** | PostgreSQL |
| **ORM** | Spring Data JPA |
| **빌드** | Gradle (멀티모듈) |
| **인증** | OAuth 다중 (GitHub, Google 등) + JWT |
| **프론트엔드** | 별도 프로젝트 (REST API 통신) |

### 멀티모듈 구조

```
devsona/
├── devsona-domain   # 순수 Kotlin - 비즈니스 모델, Repository 인터페이스
├── devsona-infra    # JPA Entity, Repository 구현체, 외부 API 클라이언트
└── devsona-api      # REST Controller, DTO, 인증
```

- **domain**: 프레임워크 의존 없는 순수 Kotlin 모듈. 비즈니스 모델과 Repository 인터페이스(포트)만 정의
- **infra**: JPA Entity로 DB 매핑. domain 모델 ↔ Entity 변환 담당. 외부 API 연동
- **api**: REST API 엔드포인트, 요청/응답 DTO, 인증 처리

### 엔티티 설계 방침

- domain 모듈의 모델은 **일반 class** 사용 (data class X)
  - JPA 프록시/지연로딩 호환 문제 회피
  - equals/hashCode를 ID 기반으로 직접 제어
- infra 모듈에서 JPA Entity 클래스를 별도로 정의하고, `toDomain()` / `from()` 메서드로 변환

---

## 8. 도메인 모델 설계

### Member (회원)

| 필드 | 타입 | 설명 | 비고 |
|------|------|------|------|
| id | Long? | PK | auto increment |
| email | String | 이메일 | unique |
| username | String | 프로필 URL용 식별자 | unique |
| name | String | 표시 이름 | |
| avatarUrl | String? | 프로필 이미지 URL | nullable |
| bio | String? | 자기소개 | nullable |
| createdAt | LocalDateTime | 생성일 | |
| updatedAt | LocalDateTime | 수정일 | |

> githubId는 Member에 넣지 않음. GitHub 계정이 없는 사용자도 있으므로 OAuth 연동 정보로 분리.

### OAuthConnection (소셜 로그인 연동)

| 필드 | 타입 | 설명 | 비고 |
|------|------|------|------|
| id | Long? | PK | auto increment |
| memberId | Long | FK → Member | |
| provider | OAuthProvider | GITHUB, GOOGLE | enum |
| providerUserId | String | OAuth 제공자의 유저 ID | |
| accessToken | String | 연동 토큰 | |
| createdAt | LocalDateTime | 생성일 | |

> 로그인은 OAuth 다중 방식. password 필드 없음.

### Link (링크)

| 필드 | 타입 | 설명 | 비고 |
|------|------|------|------|
| id | Long? | PK | auto increment |
| memberId | Long | FK → Member | |
| linkType | LinkType | GITHUB, BLOG, YOUTUBE, CUSTOM | enum |
| title | String | 표시 제목 | |
| url | String | 링크 URL | |
| displayOrder | Int | 정렬 순서 | |

> 처음부터 linkType을 구분. 나중에 GitHub URL이면 자동 연동하는 등 확장 가능.

---

## 9. API 설계

### 공개 API (인증 불필요)

| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/profiles/{username}` | 프로필 조회 (Member 정보 + Link 목록) |

### 회원 API (인증 필요)

| Method | Endpoint | 설명 |
|--------|----------|------|
| PUT | `/api/members/me` | 내 프로필 수정 (name, bio, avatarUrl) |

### 링크 API (인증 필요)

| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/members/me/links` | 내 링크 목록 조회 |
| POST | `/api/members/me/links` | 링크 추가 |
| PUT | `/api/members/me/links/{linkId}` | 링크 수정 |
| DELETE | `/api/members/me/links/{linkId}` | 링크 삭제 |
| PUT | `/api/members/me/links/order` | 링크 순서 변경 |

---

## 10. 개발 로드맵

### Step 1: 사용자 + 링크 기본 (현재)
> 모든 기능의 기반

- domain: Member, OAuthConnection, Link 모델 + Repository 인터페이스
- infra: JPA Entity + Repository 구현체
- api: 프로필 조회, 프로필 수정, 링크 CRUD API

### Step 2: OAuth 로그인
- GitHub / Google OAuth 연동
- JWT 토큰 발급 및 인증 처리

### Step 3: 특수 링크 연동
- GitHub URL → 핀 프로젝트, 잔디, 기술 스택 자동 연동
- Blog URL → RSS 파싱으로 최신 글 표시
- YouTube URL → 채널 영상 동기화

### Step 4: 자동 동기화
- 스케줄러 기반 주기적 데이터 갱신

### Step 5: 부가 기능
- DM/문의 기능 + 이메일 알림
- PDF 출력
