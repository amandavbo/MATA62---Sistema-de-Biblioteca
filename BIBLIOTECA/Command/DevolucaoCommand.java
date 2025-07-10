package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Emprestimo.Emprestimo;

public class DevolucaoCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {
        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();
        try {
            if (parametros.getParametros().length < 2) {
                System.out.println("Parâmetros inválidos. Use: dev <código_usuário> <código_livro>");
                return;
            }

            int usuarioId = Integer.parseInt(parametros.getParametro(0));
            int livroId = Integer.parseInt(parametros.getParametro(1));

            IUsuarios usuario = null;
            for (IUsuarios u : sistema.getUsuarios()) {
                if (u.getCodigo() == usuarioId) {
                    usuario = u;
                    break;
                }
            }

            if (usuario == null) {
                System.out.println("Usuário com código " + usuarioId + " não encontrado.");
                return;
            }

            ILivroObservavel livro = null;
            for (ILivroObservavel l : sistema.getLivros()) {
                if (l.getCodigo() == livroId) {
                    livro = l;
                    break;
                }
            }

            if (livro == null) {
                System.out.println("Livro com código " + livroId + " não encontrado.");
                return;
            }

            Emprestimo emprestimoEncontrado = null;
            for (Emprestimo emp : usuario.getGerenciadorDeEmprestimos().getEmprestimosAtuais()) {
                if (emp.getExemplar().getLivro().getCodigo() == livroId &&
                    emp.getUsuarioEmprestimo().getCodigo() == usuarioId) {
                    emprestimoEncontrado = emp;
                    break;
                }
            }

            if (emprestimoEncontrado == null) {
                System.out.println("Empréstimo não encontrado para o usuário " + usuario.getNome() + " e livro " + livro.getTitulo() + ".");
                return;
            }

            //faz a devolução
            usuario.getGerenciadorDeEmprestimos().devolverEmprestimo(emprestimoEncontrado);
            System.out.println("----------------------------------------");
            System.out.println("Devolução do livro " + livro.getTitulo() + " realizada com sucesso para " + usuario.getNome() + ".");
            System.out.println("----------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("----------------------------------------");
            System.out.println("Parâmetros inválidos. Use: dev <código_usuário> <código_livro>");
            System.out.println("----------------------------------------");
        } catch (Exception e) {
            System.out.println("----------------------------------------");
            System.out.println("Ocorreu um erro durante a devolução: " + e.getMessage());
            System.out.println("----------------------------------------");
        }
    }
}