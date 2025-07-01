package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import java.util.List;

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

            // Busca exemplar disponível
            IExemplarEmprestavel exemplarDisponivel = null;
            List<IExemplarEmprestavel> exemplares = sistema.getExemplaresDoLivro(livro);
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

            // implementar emprestimo com Strategy
            exemplarDisponivel.getEstado().emprestar(usuario);
            System.out.println("Empréstimo realizado com sucesso para " + usuario.getNome() + " - " + livro.getTitulo());

        } catch (Exception e) {
            System.out.println("Parâmetros inválidos para empréstimo.");
        }
    }
}

