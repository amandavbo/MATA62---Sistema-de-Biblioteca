package BIBLIOTECA.Strategy;

import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Reserva.GerenciadorDeReserva;
import BIBLIOTECA.Utilidades.GerenciadorMensagens;

public class RegraDeEmprestimoAlunoPosGraduacao implements RegrasDeEmprestimo {

    public boolean podeEmprestar(IUsuarios usuario, ILivroObservavel livro) {

        GerenciadorDeEmprestimos emprestimo = usuario.getGerenciadorDeEmprestimos();
        GerenciadorDeReserva reserva = usuario.getGerenciadorDeReserva();

        //não tem exemplar disponível
        if (livro.getExemplares().stream().noneMatch(ex -> ex.getEstado().estaDisponivel())) {
            GerenciadorMensagens.semExemplarDisponivel(livro.getTitulo());
            return false;
        }

        //usuario é devedor
        if (emprestimo.eDevedor()) {
            GerenciadorMensagens.usuarioDevedor(usuario.getNome());
            return false;
        }

        //limite de 3 emprestimos
        if (emprestimo.quantidadeDeLivrosEmprestados() >= 3) {
            GerenciadorMensagens.limiteEmprestimos(usuario.getNome(), 3);
            return false;
        }

        //reservas excedidas e usuário não reservou
        if (livro.getQtdDeReservas() >= livro.getExemplares().size() && !reserva.possuiReserva(livro)) {
            GerenciadorMensagens.reservasExcedidas(livro.getTitulo(), livro.getQtdDeReservas(), usuario.getNome());
            return false;
        }

        //já tem empréstimo desse livro
        if (emprestimo.possuiEmprestimoDoLivro(livro.getCodigo())) {
            GerenciadorMensagens.jaPossuiExemplar(usuario.getNome(), livro.getTitulo());
            return false;
        }

        return true;
    }

    public int tempoDeEmprestimo() {
        return 5;
    }
}
