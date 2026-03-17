# Todo App Fullstack Cloud CI/CD

Projeto de estudo para praticar arquitetura de software, integração entre frontend e backend, documentação de API, automação de build e preparação para deploy em cloud.

## Intenção do projeto

Este repositório foi estruturado para representar uma aplicação de gerenciamento de tarefas com separação clara entre:

- backend responsável pela API REST e regras de negócio
- frontend responsável pela interface do usuário
- infraestrutura voltada para execução local, documentação e futura automação de deploy

Principais objetivos de estudo:

- Spring Boot com arquitetura organizada por domínio
- integração entre frontend e backend via HTTP e JSON
- uso de DTOs para desacoplamento da API
- persistência de dados com JPA
- documentação com Swagger / OpenAPI
- preparação para CI/CD e cloud deployment

## Visão geral da arquitetura

Hoje o repositório já possui o backend implementado em `backend/todo-api`.

O diretório `frontend/` já existe, mas ainda está vazio. Neste README ele aparece como a parte planejada da aplicação fullstack.

```text
Usuario
  |
  v
Frontend Web (planejado)
  |
  v
HTTP/JSON
  |
  v
Backend API (Spring Boot)
  |
  v
Banco de dados
```

Resumo do fluxo:

- o usuário interage com a interface web
- o frontend envia requisições HTTP para a API
- o backend processa a operação e acessa o banco
- o resultado volta em JSON para atualização da interface

## Estrutura do repositório

```text
todo-app-fullstack-cloud-cicd/
├── backend/
│   └── todo-api/
│       ├── src/
│       ├── pom.xml
│       └── README.md
├── frontend/
└── README.md
```

## Backend atual

O backend já está funcional e expõe uma API REST para gerenciamento de tarefas.

### Responsabilidades do backend

- receber requisições HTTP
- validar os dados de entrada
- aplicar regras de negócio
- persistir e consultar tarefas
- devolver respostas em JSON

### Stack do backend

- Java 21
- Spring Boot 3.5.11
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database em desenvolvimento
- PostgreSQL driver
- Springdoc OpenAPI
- Maven

### Organização interna do backend

O backend segue uma organização inspirada em DDD simplificado:

```text
com.kleiton.todo_api
└── todo
    ├── api
    ├── application
    ├── domain
    ├── dto
    └── infrastructure
```

Papel de cada camada:

- `api`: controllers e contrato HTTP
- `application`: regras de negócio
- `domain`: entidades do domínio
- `dto`: objetos de entrada e saída da API
- `infrastructure`: acesso a dados

### API disponível hoje

Base local: `http://localhost:8080`

Endpoints principais:

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `GET` | `/todos` | Lista todas as tarefas |
| `GET` | `/todos/{id}` | Busca uma tarefa por ID |
| `POST` | `/todos` | Cria uma nova tarefa |
| `PUT` | `/todos/{id}` | Atualiza uma tarefa |
| `DELETE` | `/todos/{id}` | Remove uma tarefa |

### Documentação e recursos locais

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- H2 Console: `http://localhost:8080/h2-console`

## Frontend planejado

O frontend faz parte da arquitetura do projeto, mas ainda não está implementado neste repositório.

Quando essa parte for construída, a responsabilidade esperada será:

- listar tarefas consumindo a API
- criar novas tarefas
- editar tarefas existentes
- remover tarefas
- refletir no navegador o estado retornado pelo backend

Diretório atual: `frontend/`

## Como funciona a comunicação entre frontend e backend

O fluxo esperado da aplicação é simples:

1. O frontend envia uma requisição HTTP para o backend.
2. O backend recebe o payload JSON e valida os dados.
3. A camada de aplicação processa a operação solicitada.
4. O repositório persiste ou consulta os dados.
5. O backend devolve uma resposta JSON.
6. O frontend atualiza a interface com base nessa resposta.

Exemplo de fluxo para criação de tarefa:

```text
Frontend -> POST /todos -> Backend
Backend -> valida request -> salva no banco
Backend -> retorna JSON da tarefa criada
Frontend -> atualiza a lista exibida ao usuario
```

Exemplo de payload:

```json
{
  "title": "Estudar integracao frontend-backend",
  "completed": false
}
```

## Como executar o backend localmente

1. Entre no módulo da API:

```bash
cd backend/todo-api
```

2. Suba a aplicação:

```bash
./mvnw spring-boot:run
```

3. Acesse os recursos locais:

- API: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- H2 Console: `http://localhost:8080/h2-console`

## Estado atual do projeto

- backend implementado e documentado
- endpoints CRUD de tarefas disponíveis
- banco H2 configurado para uso local
- frontend ainda não iniciado
- README do backend disponível em `backend/todo-api/README.md`

## Próximos passos

- implementar o frontend
- conectar o frontend aos endpoints `/todos`
- adicionar tratamento de erros mais consistente no backend
- preparar containerização completa do ambiente
- evoluir pipeline de CI/CD e deploy
