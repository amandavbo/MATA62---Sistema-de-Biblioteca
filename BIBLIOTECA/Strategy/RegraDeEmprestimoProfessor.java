package BIBLIOTECA.Strategy;

import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Utilidades.GerenciadorMensagens;

public class RegraDeEmprestimoProfessor implements RegrasDeEmprestimo {

    public boolean podeEmprestar(IUsuarios usuario, ILivroObservavel livro) {

        GerenciadorDeEmprestimos emprestimo = usuario.getGerenciadorDeEmprestimos();

        //não tem exemplar disponivel
        if (livro.getExemplares().stream().noneMatch(ex -> ex.getEstado().estaDisponivel())) {
            GerenciadorMensagens.semExemplarDisponivel(livro.getTitulo());
            return false;
        }

        //usuário é devedor
        if (emprestimo.eDevedor()) {
            GerenciadorMensagens.usuarioDevedor(usuario.getNome());
            return false;
        }

        //já tem emprestimo desse livro
        if (emprestimo.possuiEmprestimoDoLivro(livro.getCodigo())) {
            GerenciadorMensagens.jaPossuiExemplar(usuario.getNome(), livro.getTitulo());
            return false;
        }

        return true;
    }

    public int tempoDeEmprestimo() {
        return 8;
    }
}
