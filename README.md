# ✅ ToDo API - Spring Boot 3

Uma API RESTful completa de gerenciamento de tarefas desenvolvida com **Spring Boot 3**, utilizando autenticação JWT, Spring Security, JPA/Hibernate e documentação Swagger.

---

# 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* H2 Database
* Swagger / OpenAPI
* Maven
* Lombok

---

# 📁 Estrutura do Projeto

```bash
src/main/java/com/seuprojeto/todo
│
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── security
└── service
```

---

# 🔐 Funcionalidades

## Autenticação

* Cadastro de usuário
* Login com JWT
* Senha criptografada com BCrypt
* Rotas protegidas com Spring Security

## Tasks

* Criar tarefa
* Listar tarefas
* Filtrar tarefas por status
* Atualizar tarefa
* Deletar tarefa
* Buscar tarefa por ID

---

# 🧠 Regras de Negócio

* Cada usuário possui suas próprias tarefas
* Um usuário não pode acessar tarefas de outro usuário
* Todas as rotas de tasks exigem autenticação JWT

---

# 🛠️ Configuração do Projeto

## Pré-requisitos

* Java 17+
* IntelliJ IDEA
* Maven

---

# ▶️ Como Executar

## 1. Clone o projeto

```bash
git clone https://github.com/seu-usuario/todo-api.git
```

---

## 2. Abra no IntelliJ

Abra a pasta do projeto normalmente.

---

## 3. Configure o Java 17

No IntelliJ:

```bash
File → Project Structure → Project SDK → Java 17
```

---

## 4. Rode a aplicação

Execute:

```bash
TodoApiApplication.java
```

---

# ⚙️ application.properties

```properties
spring.datasource.url=jdbc:h2:mem:tododb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true

springdoc.swagger-ui.path=/swagger-ui.html
```

---

# 📚 Documentação Swagger

Após iniciar a aplicação:

```bash
http://localhost:8080/swagger-ui.html
```

---

# 🔑 Fluxo de Autenticação

## Registrar usuário

### POST `/auth/register`

```json
{
  "username": "eduarda",
  "password": "123456"
}
```

---

## Login

### POST `/auth/login`

```json
{
  "username": "eduarda",
  "password": "123456"
}
```

### Resposta

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# 🔒 Autorização JWT

No Swagger clique em:

```bash
Authorize
```

E envie:

```bash
Bearer SEU_TOKEN
```

---

# 📌 Endpoints

## Auth

| Método | Endpoint         | Descrição                |
| ------ | ---------------- | ------------------------ |
| POST   | `/auth/register` | Registrar usuário        |
| POST   | `/auth/login`    | Login e geração do token |

---

## Tasks

| Método | Endpoint      | Descrição            |
| ------ | ------------- | -------------------- |
| GET    | `/tasks`      | Listar tarefas       |
| GET    | `/tasks/{id}` | Buscar tarefa por ID |
| POST   | `/tasks`      | Criar tarefa         |
| PATCH  | `/tasks/{id}` | Atualizar tarefa     |
| DELETE | `/tasks/{id}` | Deletar tarefa       |

---

# 🧪 Exemplo de Criação de Task

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Aprender JWT e Security",
  "status": "PENDENTE"
}
```

---

# 📌 Status das Tasks

```java
PENDENTE
EM_ANDAMENTO
CONCLUIDA
```

---

# 🏗️ Arquitetura

O projeto segue o padrão:

```bash
MVC (Model View Controller)
```

Separando responsabilidades em:

* Controller → Requisições HTTP
* Service → Regras de negócio
* Repository → Persistência
* Entity → Modelos do banco
* DTO → Transferência de dados
* Security → JWT e autenticação

---

# 💾 Banco de Dados

Banco utilizado:

```bash
H2 Database
```

Console H2:

```bash
http://localhost:8080/h2-console
```

JDBC URL:

```bash
jdbc:h2:mem:tododb
```
