# 📚 Spring Boot Studies - Erudio (Udemy)

Este repositório contém meus estudos práticos de **Spring Boot com Java**, desenvolvidos a partir do curso do professor Erudio na Udemy.

O objetivo deste projeto é consolidar meus conhecimentos em desenvolvimento backend, criando APIs RESTful seguindo boas práticas de mercado, arquitetura em camadas e código limpo.

---

## 🎯 Objetivo

Este projeto foi criado com o foco em:

- Aprender Spring Boot na prática
- Evoluir minhas habilidades em Java
- Entender como construir APIs REST profissionais
- Aplicar conceitos de arquitetura e boas práticas
- Me preparar para o mercado como desenvolvedor backend

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4
- Maven
- Spring Web
- Spring Data JPA
- Bean Validation
- REST API

---

## 🏗️ Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

controller → recebe requisições HTTP  
service → regras de negócio  
repository → acesso a dados  
model → entidades do sistema  
exceptions → tratamento global de erros

---

## 📌 Funcionalidades Implementadas

- Operações matemáticas via API REST:
    - Soma
    - Subtração
    - Multiplicação
    - Divisão
    - Média
    - Raiz quadrada

- Validação de entradas
- Tratamento global de exceções
- Retorno padronizado de erros

---

## ⚠️ Tratamento de Exceções

A API utiliza um handler global para garantir respostas padronizadas:

```json
{
  "timestamp": "...",
  "message": "Descrição do erro",
  "details": "uri=/endpoint"
}
```

---

## 📈 O que estou aprendendo

- Criação de APIs RESTful
- Manipulação de HTTP (GET, POST, PUT, DELETE)
- Validação de dados
- Tratamento de exceções
- Clean Code
- Arquitetura em camadas

---

## ▶️ Como executar

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd spring-boot-and-java-erudio
./mvnw spring-boot:run
```

Acesse: http://localhost:8080

---

## 🔗 Exemplos de uso

GET /math/sum/10/5  
GET /math/div/10/2

---

## 📌 Próximos Passos (edite conforme evolui)

- [ ] Integração com banco de dados
- [ ] CRUD completo
- [ ] DTOs
- [ ] Spring Security + JWT
- [ ] Swagger (OpenAPI)
- [ ] Testes automatizados

---

## 🧩 Como adaptar este README

Você pode atualizar facilmente:

- Tecnologias utilizadas
- Funcionalidades
- Endpoints
- Próximos passos
- Descrição do projeto

---

## 👨‍💻 Autor

Arthur Gonçalves
