# Santander Dev Week
RESTful API da Santander Dev Week construída em Java 17 com Spring Boot 3.

## Diagrama de Classes (Domínio da API)


```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "1..*" Feature
  User "1" *-- "1" Card
  User "1" *-- "1..*" News
```

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Maven
- Spring Data JPA
- PostgreSQL
- OpenAPI (Swagger)
- Railway (para deploy, e armazenamento de usuarios.)

### Configuração do Ambiente
1. Clone o repositório:

```bash
git clone https://github.com/IsraelDev560/santander-dev-week-dio
cd santander-dev-week-dio
```

2. Instale as dependências:

- Certifique-se de ter o Java 17 e o Maven instalados.

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

## Funcionalidades
- Cadastro de Usuários: Gerencie usuários com suas respectivas contas, cartões e notícias.
- Consulta de Usuarios: Verifique as caracteristicas de cada usuário.
- Edição de Usuários: Edite as caracteristicas de cada usuário.
- Apagando usuarios: Apague um usuario.

## Endpoints da API
- POST /users: Cria um novo usuário.
- GET /users: Lista todos os usuários.
- GET /users/{id}: Retorna os detalhes de um usuário específico.
- PUT /users/{id}: Atualiza os dados de um usuário.
- DELETE /users/{id}: Remove um usuário.

## Links da API
- link API: https://santander-dev-week-dio-production.up.railway.app
- link API/SWAGGER: https://santander-dev-week-dio-production.up.railway.app/swagger-ui.html