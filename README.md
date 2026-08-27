# List Com Spring — Todo List API

API REST de lista de tarefas (todo list) desenvolvida com **Spring Boot** e **Java**, utilizando JPA com banco H2 em memória. Projeto de estudo focado em boas práticas de organização em camadas (Controller, Service, Repository, DTO, Entity).

## Funcionalidades

- Criar tarefas
- Listar tarefas
- Validação de título (mínimo 3 caracteres)
- Tratamento global de exceções

## Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 (banco em memória)
- Lombok
- Maven

## Como executar

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints

| Método | Rota      | Descrição            |
|--------|-----------|----------------------|
| GET    | `/tasks`  | Lista todas as tarefas |
| POST   | `/tasks`  | Cria uma nova tarefa  |

### Exemplo de criação

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Estudar Spring Boot"}'
```

## Estrutura do projeto

```
src/main/java/br/com/wuzuy/todolistspring/
├── controller/   # Camada de controle (REST)
├── service/      # Regras de negócio
├── repository/   # Acesso a dados (JPA)
├── dto/          # Objetos de transferência
├── entity/       # Entidades JPA
└── exception/    # Tratamento de erros
```

## Licença

Distribuído sob a licença MIT.