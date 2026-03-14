# Todo App Fullstack Cloud CI/CD

Aplicação **fullstack** de gerenciamento de tarefas desenvolvida para demonstrar boas práticas de arquitetura moderna utilizando:

* **Java + Spring Boot**
* **React + Vite**
* **PostgreSQL**
* **Docker**
* **CI/CD com GitHub Actions**
* **Deploy em Cloud (Render + Vercel)**

O objetivo do projeto é servir como **estudo prático de arquitetura, DevOps e cloud deployment**, simulando o fluxo de desenvolvimento utilizado em aplicações reais.

---

# Arquitetura da aplicação

A aplicação segue uma arquitetura **cliente-servidor baseada em API REST**.

```
Usuário
   │
   ▼
Frontend (React + Vite)
   │
   ▼
Vercel
   │
   ▼
Backend API (Spring Boot)
   │
   ▼
Render
   │
   ▼
PostgreSQL
```

---

# Stack utilizada

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

## Frontend

* React
* Vite
* Axios

## Infraestrutura

* Docker
* Docker Compose
* GitHub Actions

## Cloud

* Render → Backend + Database
* Vercel → Frontend

---

# Estrutura do projeto

```
todo-app-fullstack-cloud-cicd
│
├── backend
│   └── todo-api
│
├── frontend
│
├── docker
│
├── docker-compose.yml
│
└── README.md
```

---

# Arquitetura do Backend

O backend segue um modelo inspirado em **DDD simplificado**, organizando o código por domínio.

```
com.kleiton.todo
│
├── todo
│   ├── domain
│   ├── application
│   ├── infrastructure
│   └── api
```

Responsabilidades:

* **domain** → entidades de negócio
* **application** → regras de negócio
* **infrastructure** → acesso a dados
* **api** → controllers REST

---

# Rodando o projeto localmente

## Requisitos

* Java 21
* Node.js
* Docker
* Git

---

## Backend

```
cd backend/todo-api
./mvnw spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

Documentação Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Frontend

```
cd frontend
npm install
npm run dev
```

Frontend disponível em:

```
http://localhost:5173
```

---

# Docker (em breve)

O projeto poderá ser executado com Docker utilizando:

```
docker-compose up
```

Containers previstos:

* backend
* frontend
* postgres

---

# CI/CD

O projeto utilizará **GitHub Actions** para:

* build do backend
* build do frontend
* build de imagens Docker
* deploy automático

---

# Deploy

Frontend:

Vercel

Backend:

Render

Database:

Render PostgreSQL

---

# Objetivos do projeto

Este projeto foi criado para praticar e demonstrar:

* Arquitetura de aplicações fullstack
* Organização baseada em domínio (DDD simplificado)
* Containerização com Docker
* Integração contínua
* Deploy em cloud

---

# Autor

Kleiton
Software Developer
