# Backend do Processo Seletivo

## Funcionalidade

Os 3 principais objetivos do backend do projeto são:

- Registrar um novo perfil para a vaga;
- Inserir esse perfil na instância do Camunda;
- Retornar as informações do perfil, e o estado do perfil na vaga;

## Tecnologias

- Java
- Spring Web
- Spring Security
- Spring Validation
- Spring Data JPA
- Gson
- Lombok

## Bancos de dados

- H2
- PostgreSQL

## Arquitetura

O projeto é um MVC, com uma entidade principal, sendo `Profile`, e algumas auxiliares para repostas de requisições, tanto ao cliente, quanto ao Camunda.

## Rotas

### Profile

-`POST /profile`

Cria um novo perfil, e registra este no Camunda

Corpo:

```json
	"name": "Ana",
	"email": "analeblanc@gmail.com",
	"phoneNumber": "5511992386045",
	"frontendExperience": "MEDIA",
	"backendExperience": "EXPERIENTE",
	"databaseExperience": "MEDIA",
	"camundaExperience": "NENHUMA",
	"healthExperience": "INICIANTE"
}
```

Exemplo de resposta:

```json
46cb4941-94c6-4037-961f-46af27fc0651
```

- `GET /profile/{id}`

Retorna os dados do perfil e do processo pelo ID

Exemplo de resposta:

```json
{
	"process": {
		"id": "f74fb532-ee25-11ed-ba2a-0242ac170002",
		"links": [],
		"definitionId": "ProcessoSeletivo:3:26f9a9af-eb8f-11ed-ba2a-0242ac170002",
		"businessKey": "ana742",
		"caseInstanceId": null,
		"ended": false,
		"suspended": false,
		"tenantId": null
	},
	"profile": {
		"id": "46cb4941-94c6-4037-961f-46af27fc0651",
		"businessKey": "ana742",
		"camundaId": "f74fb532-ee25-11ed-ba2a-0242ac170002",
		"name": "Ana",
		"email": "analeblanc@gmail.com",
		"phoneNumber": "5511992386045",
		"frontendExperience": "MEDIA",
		"backendExperience": "EXPERIENTE",
		"databaseExperience": "MEDIA",
		"camundaExperience": "NENHUMA",
		"healthExperience": "INICIANTE"
	}
}
```
