# Trabalho-G2-POO
# SaborExpress – Sistema de Gerenciamento de Pedidos

## Sobre o projeto

O SaborExpress é um sistema desenvolvido em Java para gerenciar os pedidos de delivery de um restaurante.

O projeto foi desenvolvido como atividade prática da disciplina de Programação Orientada a Objetos, com o objetivo de aplicar os cinco princípios SOLID, além de conceitos como encapsulamento, herança, abstração, polimorfismo e tratamento de exceções.

## Funcionalidades

O sistema possui as seguintes funcionalidades:

- Cadastro de clientes, contendo nome, endereço e telefone.
- Criação de diferentes tipos de pratos:
  - **Prato Executivo:** utiliza o preço base.
  - **Combo:** aplica 15% de desconto sobre o preço base.
  - **Prato Especial:** soma o custo do ingrediente premium ao preço base.
- Criação de pedidos vinculados obrigatoriamente a um cliente.
- Armazenamento dos pedidos em uma lista única.
- Validação de preços negativos por meio de uma exceção personalizada.
- Fechamento do dia, apresentando todos os pedidos, o faturamento total e o pedido de maior valor.

## Organização do projeto

O projeto foi organizado em pacotes para separar as responsabilidades:

- **modelo:** contém as classes Cliente, Prato, PratoExecutivo, Combo, PratoEspecial e Pedido.
- **exception:** contém a exceção personalizada PrecoInvalidoException.
- **service:** contém as classes ControlePedidos e FechamentoDia.
- **relatorio:** contém a interface DestinoRelatorio e a implementação RelatorioConsole.
- **Principal.java:** responsável pela execução e demonstração do sistema.

## Princípios SOLID aplicados

- **S – Responsabilidade Única:** cada classe possui uma responsabilidade específica.
- **O – Aberto/Fechado:** permite adicionar novos tipos de pratos sem modificar as classes existentes.
- **L – Substituição de Liskov:** as classes de pratos podem ser utilizadas no lugar da classe abstrata Prato.
- **I – Segregação de Interfaces:** utilização de uma interface específica para o destino dos relatórios.
- **D – Inversão de Dependência:** a classe FechamentoDia depende da abstração DestinoRelatorio, permitindo diferentes formas de envio do relatório.

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Visual Studio Code

## Como compilar e executar

É necessário ter o Java JDK instalado e configurado no computador.

Abra o terminal na pasta principal do projeto e execute os comandos:

**1. Compilar o projeto:**

```bash
javac -d bin modelo/*.java exception/*.java service/*.java relatorio/*.java Principal.java
```

**2. Executar o programa:**

```bash
java -cp bin Principal
```

## Demonstração

A classe Principal apresenta:

- Dois clientes cadastrados.
- Pedidos com os três tipos de pratos.
- Teste de preço negativo com tratamento de exceção.
- Fechamento do dia com cálculo do faturamento total e identificação do pedido mais caro.

## Autoria

Projeto acadêmico individual desenvolvido para a disciplina de Programação Orientada a Objetos.
