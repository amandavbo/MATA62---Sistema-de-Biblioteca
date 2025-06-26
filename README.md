
# 📚 Sistema de Gerenciamento de Biblioteca Acadêmica

Bem-vindo ao repositório do projeto de um sistema de biblioteca acadêmica desenvolvido com base nos princípios da programação orientada a objetos e aplicação de padrões de projeto. 🛠️

---

## 🎯 Objetivo

Este projeto tem como objetivo simular o funcionamento de um sistema de biblioteca acadêmica, permitindo **empréstimo, devolução, reserva, consulta e observação de livros**, com **regras específicas por tipo de usuário**.

---

## ⚙️ Lógica e Funcionamento

O sistema segue os seguintes princípios:

- **Padrão Command**: usado para processar comandos de forma extensível e organizada;
- **Padrão Strategy**: aplicado para encapsular regras distintas de empréstimo por tipo de usuário;
- **Padrão Singleton**: utilizado na classe `Repositorio` para garantir uma única fonte de dados;
- **Sem uso de estruturas condicionais para tipo de usuário**;
- **Sem persistência em banco de dados** – todos os dados são carregados em memória no início da execução.

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

## 🧠 Lógica de Implementação

O sistema foi dividido em módulos coesos:

- `Repositorio.java`: Singleton com listas de livros e usuários;
- `Comando.java` + subclasses: executam ações (emp, dev, res...);
- `ConsoleInterface.java`: interage com o usuário e delega comandos;
- `Usuario.java` e subclasses: implementam comportamentos distintos via Strategy;
- `Livro`, `Exemplar`, `Reserva`, `Emprestimo`, `Notificacao`: representam entidades de domínio.

Essas decisões permitem **alta coesão, baixo acoplamento** e facilitam **extensões futuras**, como novos tipos de usuário ou novas regras.

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

