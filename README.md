# Sistema de Controle de Processos

Projeto desenvolvido em Java com o objetivo de simular o controle de processos, clientes, funcionários, documentos e prazos em um pequeno escritório.

A aplicação funciona pelo terminal e permite cadastrar e consultar informações, além de gerenciar documentos vinculados aos processos.

## Funcionalidades

- Cadastro e listagem de clientes.
- Cadastro e listagem de funcionários.
- Abertura e consulta de processos.
- Associação de clientes e funcionários responsáveis aos processos.
- Cadastro, consulta e remoção de documentos.
- Controle de status dos processos e documentos.
- Definição de datas de abertura e previsão de conclusão.
- Validação de informações por meio de exceções.

## Tecnologias utilizadas

- **Java**
- **Programação Orientada a Objetos (POO)**
- **ArrayList** para armazenamento dos dados durante a execução.
- **LocalDate** para manipulação de datas.
- **Enums** para representação dos status e cargos.
- **Tratamento de exceções** para validação de dados.

## Estrutura do projeto

O projeto está organizado em classes que representam as principais entidades do sistema:

- `Pessoa`: classe base para pessoas cadastradas.
- `Cliente`: representa os clientes do escritório.
- `Funcionario`: representa os funcionários e suas informações profissionais.
- `Processo`: armazena os dados dos processos e seus documentos.
- `Documento`: representa os documentos vinculados aos processos.
- `Main`: responsável pela interação com o usuário por meio de menus no terminal.

## Objetivo

O projeto tem como objetivo praticar conceitos de Java e Programação Orientada a Objetos por meio de uma aplicação com regras de negócio e relacionamentos entre classes.

## Status do desenvolvimento

**Em desenvolvimento.**

Novas funcionalidades e melhorias serão implementadas conforme a evolução do projeto e dos conhecimentos adquiridos durante os estudos.