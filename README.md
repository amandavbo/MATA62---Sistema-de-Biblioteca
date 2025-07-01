
# 📚 Sistema de Gerenciamento de Biblioteca Acadêmica

Bem-vindo ao repositório do projeto de um sistema de biblioteca acadêmica desenvolvido com base nos princípios da programação orientada a objetos e aplicação de padrões de projeto. 🛠️

---

## 🎯 Objetivo

Este projeto tem como objetivo simular o funcionamento de um sistema de biblioteca acadêmica, permitindo **empréstimo, devolução, reserva, consulta e observação de livros**, com **regras específicas por tipo de usuário**.

---


## ⚙️ Lógica, Estrutura e Padrões de Projeto

O sistema foi desenvolvido com foco em **orientação a interfaces**, baixo acoplamento e uso explícito de padrões de projeto:

- **Command**: Cada ação do usuário (empréstimo, devolução, reserva, consulta, observação) é encapsulada em uma classe de comando, facilitando a extensão e manutenção do sistema.
- **Strategy**: As regras de empréstimo variam conforme o tipo de usuário (aluno de graduação, pós-graduação, professor) e são encapsuladas em estratégias distintas, selecionadas dinamicamente via um mapa de estratégias, sem uso de `if` ou `switch` para lógica de negócio.
- **Singleton**: O sistema de biblioteca (`SistemaBiblioteca`) é implementado como singleton, centralizando o gerenciamento de usuários, livros e exemplares em memória.
- **Observer** (em desenvolvimento): Professores podem se tornar observadores de livros, recebendo notificações de eventos relevantes.
- **Orientação a interfaces**: Todas as entidades principais (usuário, livro, exemplar) dependem de interfaces, permitindo fácil extensão e baixo acoplamento.
- **Sem persistência em banco de dados** – todos os dados são carregados em memória no início da execução.

### 🧩 Estrutura Modular

- `SistemaBiblioteca.java`: Singleton com listas de livros, usuários e métodos de consulta/manipulação.
- `Command/`: Comandos do usuário implementando o padrão Command.
- `Strategy/`: Estratégias de empréstimo para cada tipo de usuário.
- `Emprestimo/`: Gerenciador de empréstimos, histórico e regras de atraso.
- `Usuarios/`: Usuários implementando interface e selecionando estratégia de empréstimo via mapa.
- `Livros/`: Entidades de livro, exemplar e estados (disponível/emprestado) usando padrão State.
- `Reserva/`: (Opcional) Gerenciamento de reservas.
- `Utilidades/`: Funções auxiliares e formatação de dados.

### 🚦 Regras e Restrições Técnicas

- ❌ **Sem banco de dados** (dados criados em memória)
- ❌ **Sem interface gráfica** (linha de comando apenas)
- ❌ **Sem uso de `if` ou `switch` para tipos de usuário** na lógica de negócio (uso de mapa de estratégias)
- ✅ Uso explícito de padrões de projeto (`Command`, `Strategy`, `Singleton`, `State`, `Observer`)
- ✅ Entrada de dados simulada via terminal


---

## 💻 Interface de Uso

O sistema é executado via **linha de comando**, com os seguintes comandos disponíveis:

| Comando | Descrição |
|--------|-----------|
| `emp <codUsu> <codLivro>` | Realiza empréstimo |
| `dev <codUsu> <codLivro>` | Realiza devolução |
| `res <codUsu> <codLivro>` | Realiza reserva |
| `obs <codUsu> <codLivro>` | Professor se torna observador |
| `liv <codLivro>` | Consulta dados do livro |
| `usu <codUsu>` | Consulta dados do usuário |
| `ntf <codUsu>` | Consulta notificações recebidas |
| `sai` | Encerra o programa |

### 📥 Exemplo de entrada:
```bash
emp 123 100
res 456 101
obs 100 300
```

### 📤 Exemplo de saída:
```text
Empréstimo realizado com sucesso!
Reserva efetuada!
Professor registrado como observador.
```

---

## 📏 Critérios e Restrições Técnicas

- ❌ **Sem banco de dados** (dados criados em memória);
- ❌ **Sem interface gráfica** (linha de comando apenas);
- ❌ **Sem uso de `if` ou `switch` para tipos de usuário**;
- ✅ Uso de padrões de projeto (`Command`, `Strategy`, `Singleton`);
- ✅ Entrada de dados simulada via terminal.

---

## 🧪 Casos de Teste

| Comando de Entrada         | Saída Esperada |
|---------------------------|----------------|
| `emp 123 100`             | Empréstimo realizado com sucesso |
| `emp 123 100` (repetido)  | ❌ Empréstimo negado: já possui exemplar do livro |
| `res 456 101`             | Reserva realizada com sucesso |
| `ntf 100` (sem eventos)   | Notificações recebidas: 0 |
| `liv 100`                 | Detalhes do livro + reservas e empréstimos |

---

## 🚀 Como Rodar Localmente

1. 🔁 Clone este repositório:
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

2. 🧰 Compile o projeto:
```bash
javac Main.java
```

3. ▶️ Execute:
```bash
java Main
```

---


## 🧠 Resumo da Implementação

O sistema é altamente modular, orientado a interfaces e padrões:

- **Gerenciamento centralizado**: `SistemaBiblioteca` (Singleton) inicializa e gerencia todos os dados em memória.
- **Comandos**: Cada ação do usuário é um comando independente, facilitando a extensão.
- **Usuários flexíveis**: Cada usuário possui um gerenciador de empréstimos próprio e seleciona sua estratégia de empréstimo via mapa, sem condicionais.
- **Livros e exemplares**: Gerenciados por interfaces e estados, permitindo múltiplos exemplares e controle de disponibilidade.
- **Regras de negócio**: Estratégias de empréstimo encapsulam as regras específicas de cada perfil.
- **Notificações e observação**: Professores podem observar livros e receber notificações (em desenvolvimento).

Essas decisões garantem **alta coesão, baixo acoplamento** e facilitam a extensão para novos tipos de usuário, regras ou funcionalidades.

---

## 👨‍💻 Desenvolvedores

- **Amanda Vilas Boas** – [@amandavbo](https://github.com/amandavbo)  
- **Nalanda Santana Pita** – [@nalandap](https://github.com/nalandap)

---

## 📄 Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

---

## 🏫 Informações Adicionais

- 📘 **Linguagem**: Java ☕
- 📥 **Entrada**: comandos digitados no terminal
- 📤 **Saída**: mensagens no terminal
- 🎓 **Disciplina**: MATA62 – Engenharia de Software I
- 🏫 **Instituição**: Universidade Federal da Bahia (UFBA)

---

