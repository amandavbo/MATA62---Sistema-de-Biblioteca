package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Emprestimo.Emprestimo;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class EmprestimoCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {
        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();
        try {
            int usuarioId = Integer.parseInt(parametros.getParametro(0));
            int livroId = Integer.parseInt(parametros.getParametro(1));

            // Recupera usuários e livros do sistema
            List<IUsuarios> usuarios = sistema.getUsuarios();
            List<ILivroObservavel> livros = sistema.getLivros();

            IUsuarios usuario = null;
            for (IUsuarios u : usuarios) {
                if (u.getCodigo() == usuarioId) {
                    usuario = u;
                    break;
                }
            }

            ILivroObservavel livro = null;
            for (ILivroObservavel l : livros) {
                if (l.getCodigo() == livroId) {
                    livro = l;
                    break;
                }
            }

            if (usuario == null || livro == null) {
                System.out.println("Usuário ou livro não encontrado.");
                return;
            }

            // Verifica se o usuário já possui um exemplar deste livro emprestado
            if (usuario.getGerenciadorDeEmprestimos().possuiEmprestimoDoLivro(livroId)) {
                System.out.println("Empréstimo não permitido para " + usuario.getNome() + " - Usuário já possui empréstimo do livro " + livro.getTitulo());
                return;
            }

            // Busca exemplar disponível
            IExemplarEmprestavel exemplarDisponivel = null;
            List<IExemplarEmprestavel> exemplares = livro.getExemplares();
            for (IExemplarEmprestavel ex : exemplares) {
                if (ex.getEstado().estaDisponivel()) {
                    exemplarDisponivel = ex;
                    break;
                }
            }

            if (exemplarDisponivel == null) {
                System.out.println("Não há exemplares disponíveis para o livro " + livro.getTitulo());
                return;
            }

            // Calculate return date
            Date dataEmprestimo = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataEmprestimo);
            int diasEmprestimo = 0;

            switch (usuario.getTipoDeUsuario()) {
                case "Aluno Graduação":
                    diasEmprestimo = 4;
                    break;
                case "Aluno Pós-Graduação":
                    diasEmprestimo = 5;
                    break;
                case "Professor":
                    diasEmprestimo = 8;
                    break;
                default:
                    System.out.println("Tipo de usuário desconhecido. Não é possível determinar a data de devolução.");
                    return;
            }
            calendar.add(Calendar.DAY_OF_MONTH, diasEmprestimo);
            Date dataDevolucao = calendar.getTime();

            // Create Emprestimo object
            Emprestimo novoEmprestimo = new Emprestimo(usuario, exemplarDisponivel, dataEmprestimo, dataDevolucao);

            // Update exemplar state and add to user's loan manager
            exemplarDisponivel.getEstado().emprestar(usuario, novoEmprestimo);
            usuario.getGerenciadorDeEmprestimos().adicionarEmprestimo(novoEmprestimo);

            System.out.println("Empréstimo realizado com sucesso para " + usuario.getNome() + " - " + livro.getTitulo());

        } catch (Exception e) {
            System.out.println("Parâmetros inválidos para empréstimo.");
            e.printStackTrace(); // For debugging
        }
    }
}

