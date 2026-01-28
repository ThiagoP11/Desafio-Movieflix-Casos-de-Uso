# 🎬 MovieFlix API

## 📌 Sobre o Projeto

A **MovieFlix API** é uma aplicação backend desenvolvida em **Java com Spring Boot**, criada como solução para o **Desafio MovieFlix da DevSuperior**. O projeto simula uma plataforma de catálogo de filmes com sistema de avaliações, aplicando boas práticas de desenvolvimento backend, arquitetura em camadas, segurança e testes automatizados.

Este projeto foi desenvolvido com foco em **qualidade de código**, **organização**, **aderência a requisitos funcionais** e **preparação para ambientes profissionais**.

---

## 🎯 Objetivo

Implementar as funcionalidades necessárias para atender integralmente aos **casos de uso propostos no desafio**, garantindo que todos os **testes automatizados** fornecidos pela DevSuperior sejam aprovados.

---

## 🧩 Domínio da Aplicação

O sistema é composto pelas seguintes entidades principais:

* **Movie** – representa um filme do catálogo
* **Genre** – categoria associada aos filmes
* **Review** – avaliação textual de um filme
* **User** – usuário do sistema
* **Role** – perfil de acesso do usuário

As entidades seguem o modelo conceitual definido no desafio, com relacionamentos bem definidos e persistência via JPA/Hibernate.

---

## 📖 Funcionalidades

### 🔹 Listagem de Filmes

* Retorno da lista de todos os gêneros cadastrados
* Listagem **paginada** de filmes contendo:

  * Título
  * Subtítulo
  * Ano de lançamento
  * Imagem
* Ordenação automática **alfabética por título**
* Filtro opcional por gênero
* Acesso permitido para usuários **visitantes** e **membros**

---

### 🔹 Detalhes do Filme

* Visualização completa dos dados do filme:

  * Título
  * Subtítulo
  * Ano
  * Imagem
  * Sinopse
* Listagem das avaliações associadas ao filme

  * Texto da avaliação
  * Nome do usuário avaliador
* Acesso permitido para usuários **visitantes** e **membros**

---

### 🔹 Avaliação de Filme

* Permite que usuários com perfil **MEMBER** realizem avaliações
* A avaliação é associada automaticamente ao usuário autenticado
* Validação para impedir envio de texto vazio
* Retorno dos dados atualizados do filme após a avaliação

---

## 🔐 Segurança e Controle de Acesso

A aplicação utiliza **Spring Security** para controle de autenticação e autorização:

* **ROLE_VISITOR**: pode listar filmes e visualizar detalhes
* **ROLE_MEMBER**: possui todas as permissões de visitante e pode realizar avaliações

As regras de acesso seguem rigorosamente os requisitos definidos no desafio.

---

## 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* H2 / PostgreSQL
* Maven
* JUnit
* Mockito

---

## 🎨 Protótipos de Interface

Os protótipos de tela utilizados como referência estão disponíveis no Figma:

🔗 [https://www.figma.com/file/6JQVnxKgKtVHLleSBBgRin/MovieFlix-front-listagem](https://www.figma.com/file/6JQVnxKgKtVHLleSBBgRin/MovieFlix-front-listagem)

---

## ✅ Critérios de Qualidade

* Código organizado em camadas (Controller, Service, Repository)
* Uso de DTOs para transferência de dados
* Paginação e ordenação com Pageable
* Tratamento adequado de exceções
* Conformidade total com os testes automatizados

---

## 🚀 Execução do Projeto

```bash
# Clonar o repositório
git clone <url-do-repositorio>

# Acessar o diretório do projeto
cd movieflix

# Executar a aplicação
./mvnw spring-boot:run
```



