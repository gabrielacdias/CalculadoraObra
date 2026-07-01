# Calculadora de Materiais para Obra Residencial 🔨

Este projeto é uma API REST desenvolvida em **Java 17** com **Spring Boot**, criada para atender à atividade avaliativa da disciplina de **Desenvolvimento de Sistemas**. O objetivo é auxiliar empresas de engenharia no dimensionamento de materiais para obras residenciais.

## Funcionalidades
- Cálculo do volume de concreto para vigas baldrame
- Cálculo da quantidade de tijolos
- API REST organizada em camadas

- Teste automatizado básico

## Tecnologias
- **Java 17**: Linguagem Base
- **Spring Boot 3.2.5**: Framework para criação da API.
- **Spring Web**
- **Spring Validation**
- **Maven**
- **H2 Database**: Banco de dados em memória para testes rápidos.

## Como Executar o Projeto
1.  Certifique-se de ter o **JDK 17** e o **Maven** instalados.
2.  Clone o repositório para sua máquina local.
3.  Execute a aplicação através da sua IDE ou via terminal:
    ```bash
    mvn spring-boot:run
    ```
4.  A aplicação estará disponível em: `http://localhost:8080`

## Endpoints Principais (API)
A documentação completa (Swagger) pode ser acessada em:  
`http://localhost:8080/swagger-ui/index.html`

### 1. Calcular o volume do Concreto
* **POST** `/api/materiais/concreto`
* **Payload de exemplo:** Ver arquivo `requisicao-concreto.json`.

### 2. Calcular a quantidade de Tijolos
* **POST** `/api/materiais/tijolos`
* **Payload de exemplo:** Ver arquivo `requisicao-tijolos.json`.


## Plano de Testes — Módulo de Orçamentos

### Caso de Teste 01: Criação de Orçamento com Sucesso
- **Objetivo:** Verificar se a tela de orçamento envia e salva os dados corretamente no banco de dados.
- **Passos:**
    1. Executar a aplicação pelo IntelliJ (clicando no 'Play' verde na classe `ObraApplication`).
    2. Abrir o navegador e acessar: `http://localhost:8080/index.html`.
    3. Preencher os campos: Nome: "Gabriel Teste", Área: "120", Cômodos: "5".
    4. Clicar no botão "Salvar Orçamento".
- **Resultado Esperado:** Um alerta na tela informando "Orçamento salvo com sucesso!".

### Caso de Teste 02: Busca de Orçamento Cadastrado por Nome de Usuário
- **Objetivo:** Validar se o identificador por nome de usuário está funcionando na API.
- **Passos:**
    1. Com o teste 1 já realizado, abrir uma nova aba no navegador.
    2. Acessar a URL: `http://localhost:8080/api/orcamentos/usuario?nome=Gabriel`.
- **Resultado Esperado:** O navegador deve exibir os dados do orçamento salvos em formato JSON.