# Processo Seletivo

O Projeto Seletivo é um projeto criado para o desafio da vaga de Fullstack Java/React da 2iM.

## Objetivo

O objetivo do projeto é criar um sistema de candidatura para uma vaga numa empresa chamada Processo Seletivo.

Para isso, é necessário pegar algumas informações específicas do perfil (todas descritas no documento do desafio), registrar em um banco de dados, inciar um processo no Camunda, e devolver esses dados quando o cliente precisar, como uma forma de acompanhar o processo.

## Projetos

- `/backend` - Responsável por criar a nova candidatura e iniciar o processo no Camunda
- `/frontend` - Responsável pelas telas e usabilidade da API do Backend, permitindo o acompanhemento do processo

## Tecnologias

- Spring
- React
- Camunda (via API REST)
- Docker

## Docker Compose

Todos os projetos tem Dockerfile's, e também um docker compose, que pode ser iniciado com:

```sh
docker-compose up
```

## Considerações finais

Foi um desafio muito satisfatório criar esses dois projetos. No começo me parecia complicado, mas depois que fiz um diagrama com todos os processos necessários, ficou mais fácil organizar as ideias, e começar o projeto.

Nunca havia usado Camunda, e com esse projeto descobri que é uma tecnologia muito interesse, e consigo pensar em vários usos que ela pode ter na área de saúde.

Muito obrigada, e espero que analisem o meu projeto com muito cuidado.
