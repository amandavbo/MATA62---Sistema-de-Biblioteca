# Requisitos do Sistema de Biblioteca

Este documento descreve os requisitos para o sistema de biblioteca, conforme especificado no "Trabalho Prático" da disciplina MATA62 - Engenharia de Software I.

## 1. Objetivo

O objetivo deste trabalho é projetar e implementar um programa simples que permita aos alunos aplicar seus conhecimentos em projeto e programação orientados a objetos, incluindo princípios de projeto e padrões de projeto.

## 2. Visão Geral do Sistema

O sistema de biblioteca consiste no gerenciamento e manutenção de livros disponíveis em uma biblioteca acadêmica. Ele permite que três tipos de usuários (alunos de graduação, alunos de pós-graduação e professores) realizem o empréstimo, devolução e reserva de livros disponíveis.

*   Um livro específico pode ter mais de um exemplar disponível na biblioteca.
*   Cada livro deve possuir um código de identificação e um título, além de informações adicionais como editora, autores, edição e ano de publicação.
*   Cada usuário deve ter um código de identificação e um nome. Os três tipos de usuários possuem regras específicas para o empréstimo de livros e um período específico para manter o livro emprestado.
*   O empréstimo de um livro é registrado no sistema, incluindo a data de devolução baseada no prazo de empréstimo do tipo de usuário.
*   Os usuários também podem realizar reserva de livros, garantindo prioridade no empréstimo apenas entre os alunos. A reserva é registrada com a data em que foi feita.

### Tabela 1. Tempo de empréstimo por tipo de usuário.

| Tipo de Usuário      | Tempo de Empréstimo |
| :------------------- | :------------------ |
| Aluno Graduação      | 4 dias              |
| Aluno Pós-Graduação | 5 dias              |
| Professor            | 8 dias              |

## 3. Funcionalidades

### 3.1. Empréstimo

A funcionalidade principal é permitir o empréstimo de livros.
**Comando:** `emp <código do usuário> <código do livro>`

#### 3.1.1. Regras de Empréstimo

**Regra 1: Empréstimo para Alunos**
O empréstimo de um livro será realizado para um aluno de graduação ou de pós-graduação apenas se:
1.  Houver exemplares disponíveis na biblioteca.
2.  O usuário não estiver “devedor” com livros em atraso.
3.  O usuário seguir as regras específicas referentes à quantidade máxima de livros que podem ser emprestados (conforme Tabela 2).
4.  A quantidade de reservas existentes do livro deve ser menor do que a quantidade de exemplares disponíveis, desde que o usuário não tenha uma reserva para esse livro.
5.  Se a quantidade de reservas for igual ou superior à de exemplares disponíveis, o empréstimo será permitido apenas se uma das reservas for do usuário.
6.  O usuário não pode ter nenhum empréstimo em andamento de um exemplar desse mesmo livro.

### Tabela 2. Limites da quantidade de livros para empréstimo.

| Tipo de Usuário      | Limite de Empréstimos em Aberto |
| :------------------- | :------------------------------ |
| Aluno Graduação      | 2 livros                        |
| Aluno Pós-Graduação | 3 livros                        |

**Regra 2: Empréstimo para Professor**
O empréstimo do livro só será concretizado para um professor se:
1.  Houver a disponibilidade de algum exemplar daquele livro na biblioteca; e
2.  O usuário não estiver como "devedor" de um livro em atraso.
*Observação:* Professores não têm empréstimo negado por reservas e não há limite para a quantidade de livros que podem pegar emprestado.

#### 3.1.2. Mensagens de Insucesso do Empréstimos
Se o empréstimo não for possível, o programa deve mostrar uma mensagem informando o motivo.

### 3.2. Devolução

O sistema deve permitir a devolução de livros.
**Comando:** `dev <código do usuário> <código do livro emprestado>`

### 3.3. Reserva

O sistema deve permitir a reserva de um livro.
**Comando:** `res <código do usuário> <código do livro>`
A reserva deve ser registrada com a data em que foi realizada.

### 3.4. Registro de Observação de Livros

O sistema deve permitir que professores se registrem para receber notificações sempre que um livro atingir mais de duas reservas simultâneas.
**Comando:** `obs <código do usuário> <código do livro>`
O sistema deve registrar quantas notificações foram recebidas por um observador.

### 3.5. Consulta de Informações de Livro

Dado o código de um livro, o sistema deve apresentar suas informações.
**Comando:** `liv <código do livro>`

**Informações a serem apresentadas:**
*   (i) Título.
*   (ii) Quantidade de reservas para aquele livro, e, se diferente de zero, os nomes dos usuários que realizaram cada reserva.
*   (iii) Para cada exemplar do livro:
    *   Código do exemplar.
    *   Status (disponível ou emprestado).
    *   Caso emprestado: nome do usuário que realizou o empréstimo, data de empréstimo e data prevista para devolução.
*   *Atenção:* Essa consulta mostra apenas os dados dos empréstimos correntes do livro.

### 3.6. Consulta de Informações de Usuário

Dado um usuário, o sistema deverá apresentar a lista de todos os seus empréstimos correntes e passados, assim como de suas reservas.
**Comando:** `usu <código do usuário>`

**Listagem de cada empréstimo:**
*   Título do livro.
*   Data do empréstimo.
*   Status atual do empréstimo (em curso ou finalizado).
*   Data da devolução realizada ou prevista.

**Listagem das reservas:**
*   Título do livro reservado.
*   Data da solicitação da reserva.

### 3.7. Consulta de Notificações Recebidas

Dado um professor, o sistema deve retornar o número total de vezes que ele foi notificado sobre a ocorrência de mais de duas reservas simultâneas nos livros que ele está observando.
**Comando:** `ntf <código do usuário>`

## 4. Modelo Conceitual

O sistema é baseado em um modelo conceitual que define o relacionamento entre as entidades de negócio (Livro, Exemplar, Usuário, Empréstimo, Reserva). A classe `Repositorio` não é uma entidade de negócio, mas mantém as listas de usuários e livros.

## 5. Exigências do Projeto

*   **5.1. Persistência de Dados:** O sistema **NÃO** deve se preocupar com a persistência de dados (não deve usar banco de dados). Os objetos de dados de teste devem ser instanciados na memória na inicialização do sistema.
*   **5.2. Repositório:** Deve ter uma classe `Repositorio` (Singleton) responsável por manter as listas de usuários e livros e métodos de busca.
*   **5.3. Cadastro:** O sistema **NÃO** deve disponibilizar funcionalidades de cadastros de livros, usuários e exemplares.
*   **5.4. Interface Gráfica:** O sistema **NÃO** deve ter interface gráfica com o usuário. Todos os comandos e respostas devem ser via linha de comando (console).
*   **5.5. Leitura de Comandos:** Deve ter uma classe responsável por ler os comandos do console e mostrar as respostas.
*   **5.6. Comunicação:** A classe de leitura de comandos deve se comunicar com as classes de negócio (incluindo `Repositorio`) por meio de um esquema de comandos, projetados de acordo com o padrão de projeto "Command".
*   **5.7. Padrão de Projeto para Regras de Empréstimo:** Evitar o uso de `if` ou `switch` para saber o tipo de usuário. Implementar um padrão de projeto que permita selecionar, dependendo do tipo de usuário, qual regra de empréstimo deve ser usada para verificar se o empréstimo pode ser realizado ou não.

## 8. Dados de Teste

O sistema deve usar dados de teste instanciados na memória durante a inicialização do programa. Exemplos de dados de teste são fornecidos no documento original.
