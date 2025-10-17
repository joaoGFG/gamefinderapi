# 🎮 API de Busca de Jogos

Este projeto consiste em uma **API RESTful** desenvolvida como parte de uma **avaliação prática em sala de aula**, baseada no front-end disponibilizado pelo professor:  
🔗 [Repositório do front-end](https://github.com/joaocarloslima/gamefinder-web)

---

## 🧩 Descrição

A API tem como objetivo fornecer dados para o site **GameFinder**, permitindo a **listagem completa de jogos** e **buscas personalizadas** com base em diferentes filtros, como:

- 🎭 **Gênero**
- 💻 **Plataforma**
- 🔍 **Título**
- **Entre outras**

Além disso, cada **Card** de jogo inclui **links de navegação (HATEOAS)** para páginas relacionadas ao seu gênero e plataforma.

---

## 🎯 Objetivo da Avaliação

O principal objetivo deste projeto foi **aplicar o uso da biblioteca HATEOAS do Spring**, garantindo que as respostas da API sigam os princípios de **hipermídia** em sistemas REST.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**  
- **Spring Boot**
- **Spring HATEOAS**
- **Spring Web**
- **Spring Data JPA**
- **Banco de Dados Relacional H2**

---

## 🚀 Funcionalidades Principais

- Listagem de todos os jogos cadastrados  
- Busca de jogos por:
  - Nome  
  - Gênero  
  - Plataforma  
- Retorno de hipermídia com HATEOAS (links para recursos relacionados)  

---

## 🧠 Conceitos Aplicados

- Arquitetura **RESTful**
- Princípio **HATEOAS (Hypermedia as the Engine of Application State)**
- **Camadas MVC** (Controller, Service, Repository)
- Boas práticas de desenvolvimento com **Spring Boot**

---

Desenvolvido para a disciplina de **Java Advanced**, como parte da avaliação em tempo de aula.
