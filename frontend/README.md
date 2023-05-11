# Frontend do Processo Seletivo

## Funcionalidade

Os 2 principais objetos do frontend do projeto são:

- Registrar uma noova candidatura
- Acompanhar a candidatura no processo seletivo

## Tecnologias

- React
- Typescript
- Axios
- React Hook Form
- Toastify

## Variáveis de ambiente

- `REACT_APP_BACKEND_URL` - URL do backend do projeto

## Páginas

- `/` - Página Home. Apenas contém um botão que encaminha para o formulário de inscrição na vaga;
- `/candidatura` - Página de inscrição na vaga. Contém um formulário com todos os dados necesários;
- `/processo` - Página de consulta do processo seletivo. Informa se o processo terminou, está suspenso, ou está em andamento;