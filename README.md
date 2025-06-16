# Sistema de Cadastro de Usuários

Aplicação full stack desenvolvida com **React**, **TailwindCSS**, **Spring Boot** e **PostgreSQL**. Permite o cadastro de usuários com criptografia de senha, autenticação via **JWT**, consumo de API com **Axios** e persistência em banco de dados. O projeto também conta com documentação interativa via **Swagger**.

---

## 🚀 Tecnologias Utilizadas

### 🔧 Backend
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- PostgreSQL
- Swagger / OpenAPI

### 🎨 Frontend
- React (v18)
- Axios
- TailwindCSS
- Vite

---

## 🧩 Funcionalidades

- Cadastro de usuários com nome, e-mail e senha
- Criptografia de senhas com BCrypt
- Autenticação com JWT
- Integração entre frontend e backend via Axios
- Interface moderna, responsiva e estilizada com TailwindCSS
- Documentação da API com Swagger

---

## ⚙️ Como Rodar o Projeto

### Backend (Spring Boot)

1. Clone o repositório
2. Configure o arquivo `application.properties` com os dados do seu banco PostgreSQL
3. Rode a aplicação com:

```bash
./mvnw spring-boot:run

