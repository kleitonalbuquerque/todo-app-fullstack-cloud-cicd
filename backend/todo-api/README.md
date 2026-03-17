# Todo API

API REST simples para gerenciamento de tarefas, construída com Spring Boot.

## Visão geral

O projeto expõe endpoints para:

- listar tarefas
- buscar uma tarefa por ID
- criar uma nova tarefa
- atualizar uma tarefa existente
- remover uma tarefa

## Stack

- Java 21
- Spring Boot 3.5.11
- Spring Web
- Spring Data JPA
- Spring Validation
- H2 Database
- PostgreSQL driver
- Springdoc OpenAPI / Swagger UI
- Maven

## Pré-requisitos

- Java 21 instalado
- Maven Wrapper disponível no projeto (`./mvnw`)

## Como executar

Inicie a aplicação com:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada por padrão em:

```text
http://localhost:8080
```

## Configuração atual

Atualmente o projeto usa banco em memória H2 por padrão.

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:todo-db
    driver-class-name: org.h2.Driver
    username: sa
    password:
```

## Endpoints principais

Base URL:

```text
http://localhost:8080/todos
```

- `GET /todos`
- `GET /todos/{id}`
- `POST /todos`
- `PUT /todos/{id}`
- `DELETE /todos/{id}`

### Exemplo de criação

```http
POST /todos
Content-Type: application/json
```

```json
{
  "title": "Estudar Spring Boot",
  "completed": false
}
```

### Exemplo de atualização

```http
PUT /todos/1
Content-Type: application/json
```

```json
{
  "title": "Estudar Spring Boot com JPA",
  "completed": true
}
```

## Recursos úteis

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI docs: `http://localhost:8080/v3/api-docs`
- Console H2: `http://localhost:8080/h2-console`

## Executando testes

```bash
./mvnw test
```

## Observações

- O pacote Java usa `com.kleiton.todo_api` porque `com.kleiton.todo-api` não é um nome de pacote válido.
- O driver do PostgreSQL já está no projeto, mas a configuração ativa no momento usa H2 em memória.
- O arquivo `HELP.md` permanece como artefato do template inicial do Spring Boot.
