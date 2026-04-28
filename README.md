# 🚀 Spring Boot API - Study

## 📌 Sobre o Projeto

Este projeto é uma API REST desenvolvida com **Spring Boot** como parte de estudos práticos em Java.

A aplicação implementa operações CRUD completas para gerenciamento de pessoas, além de endpoints adicionais para operações matemáticas e testes de logging.

---

## 🧠 Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* Spring Web (REST)
* Spring Data JPA
* MySQL
* Flyway (migração de banco)
* Dozer Mapper (conversão DTO ↔ Entity)
* Maven

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
controller → service → repository → model
                ↓
              DTO
```

### 📂 Estrutura

* `controllers` → Endpoints REST
* `services` → Regras de negócio
* `repository` → Acesso ao banco
* `model` → Entidades JPA
* `data.dto` → Objetos de transferência (v1 e v2)
* `exceptions` → Tratamento global de erros
* `mapper` → Conversão entre DTO e entidade
* `resources/db/migration` → Scripts do Flyway

---

## 🔗 Endpoints Principais

### 👤 Pessoa (v1)

| Método | Endpoint              | Descrição              |
| ------ | --------------------- | ---------------------- |
| GET    | `/api/person/v1`      | Lista todas as pessoas |
| GET    | `/api/person/v1/{id}` | Busca por ID           |
| POST   | `/api/person/v1`      | Cria pessoa            |
| PUT    | `/api/person/v1`      | Atualiza pessoa        |
| DELETE | `/api/person/v1/{id}` | Deleta pessoa          |

### 👤 Pessoa (v2)

| Método | Endpoint         | Descrição                                            |
| ------ | ---------------- | ---------------------------------------------------- |
| POST   | `/api/person/v2` | Cria pessoa com versão 2 (inclui data de nascimento) |

### 🧮 Matemática

| Endpoint                    | Descrição     |
| --------------------------- | ------------- |
| `/math/sum/{num1}/{num2}`   | Soma          |
| `/math/sub/{num1}/{num2}`   | Subtração     |
| `/math/multi/{num1}/{num2}` | Multiplicação |
| `/math/div/{num1}/{num2}`   | Divisão       |
| `/math/med/{n1}/{n2}/{n3}`  | Média         |
| `/math/raiz/{num}`          | Raiz quadrada |

### 🧪 Teste de Logs

* `GET /api/test/v1`

---

## ⚠️ Tratamento de Exceções

A aplicação possui tratamento global usando `@ControllerAdvice`, retornando:

* `400 Bad Request`
* `404 Not Found`
* `500 Internal Server Error`

Formato padrão:

```json
{
  "timestamp": "2026-01-01",
  "message": "Erro",
  "details": "Descrição"
}
```

---

## 🗄️ Banco de Dados

O projeto utiliza **MySQL** com versionamento via Flyway.

### Scripts:

* `V1__Create_Table_Person.sql`
* `V2__Populate_Table_Person.sql`


---

## ▶️ Como Executar

### 1. Clonar o projeto

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2. Configurar variáveis de ambiente

### 3. Rodar aplicação

```bash
mvn spring-boot:run
```

---

## 📈 Melhorias Futuras

* Validação com Bean Validation
* Autenticação (Spring Security + JWT)
* Documentação com Swagger/OpenAPI
* Testes unitários e integração
* Dockerização

---

## 👨‍💻 Autor

[Arthur Gonçalves](https://www.linkedin.com/in/arthur-gon%C3%A7alves-3957a4233/)

---

## ⭐ Objetivo

Projeto criado com foco em aprendizado prático de:

* APIs REST
* Arquitetura em camadas
* Integração com banco de dados
* Boas práticas no Spring Boot

---

Se esse projeto te ajudou, considere dar uma ⭐ no repositório!
