package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import java.util.List;
import BIBLIOTECA.Emprestimo.Emprestimo;

public class EmprestimoCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {
        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();
        try {
            if (parametros.getParametros().length < 2) {
                System.out.println("----------------------------------------");
                System.out.println("Comando 'dev' requer o código do usuário e do livro.");
                System.out.println("Uso: dev <código_usuário> <código_livro>");
                System.out.println("----------------------------------------");
                return;
            }

            int usuarioId = Integer.parseInt(parametros.getParametro(0));
            int livroId = Integer.parseInt(parametros.getParametro(1));

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

            //regra de empréstimo
            if (!usuario.getRegraDeEmprestimo().podeEmprestar(usuario, livro)) {
                return; 
            }

            //busca exemplar disponível
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

            Emprestimo novoEmprestimo = exemplarDisponivel.getEstado().emprestar(usuario);
            usuario.getGerenciadorDeEmprestimos().adicionarEmprestimo(novoEmprestimo);

            //cancela a reserva se o usuário possuía uma para este livro
            if (usuario.getGerenciadorDeReserva().possuiReserva(livro)) {
                usuario.getGerenciadorDeReserva().removerReserva(livroId);
                livro.removerReserva(usuarioId); 
                System.out.println("Reserva do livro " + livro.getTitulo() + " para " + usuario.getNome() + " cancelada devido ao empréstimo.");
            }

            System.out.println("----------------------------------------");
            System.out.println("Empréstimo realizado com sucesso para " + usuario.getNome() + " - " + livro.getTitulo());
            System.out.println("----------------------------------------");

        } catch (Exception e) {
            System.out.println("----------------------------------------");
            System.out.println("Parâmetros inválidos | Use: emp <código_usuário> <código_livro>");
            System.out.println("----------------------------------------");
        }
    }
}

