.PHONY: pg-up pg-down pg-logs pg-psql

POSTGRES_USER ?= postgres
POSTGRES_PASSWORD ?= postgres
POSTGRES_DB ?= devsona
POSTGRES_PORT ?= 5432
CONTAINER_NAME = devsona-postgres

pg-up:
	@docker run -d \
		--name $(CONTAINER_NAME) \
		-e POSTGRES_USER=$(POSTGRES_USER) \
		-e POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
		-e POSTGRES_DB=$(POSTGRES_DB) \
		-p $(POSTGRES_PORT):5432 \
		-v devsona-pgdata:/var/lib/postgresql/data \
		postgres:latest
	@echo "PostgreSQL started on port $(POSTGRES_PORT)"

pg-down:
	@docker stop $(CONTAINER_NAME) && docker rm $(CONTAINER_NAME)
	@echo "PostgreSQL stopped and removed"

pg-logs:
	@docker logs -f $(CONTAINER_NAME)

pg-psql:
	@docker exec -it $(CONTAINER_NAME) psql -U $(POSTGRES_USER) -d $(POSTGRES_DB)
