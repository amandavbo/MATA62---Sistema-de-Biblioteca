package BIBLIOTECA.Strategy;

import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;

public class RegraDeEmprestimoProfessor implements RegrasDeEmprestimo {

    public boolean podeEmprestar(IUsuarios usuario, ILivroObservavel livro) {

        GerenciadorDeEmprestimos emprestimoManager = usuario.getGerenciadorDeEmprestimos();

        // não tem exemplar disponível
        if (livro.getExemplares().stream().noneMatch(ex -> ex.getEstado().estaDisponivel())) {
            System.out.println("Não há exemplares disponíveis para o livro " + livro.getTitulo());
            return false;
        }

        // usuário é devedor
        if (emprestimoManager.eDevedor()) {
            System.out.println("O usuário " + usuario.getNome() + " está com empréstimos em atraso");
            return false;
        }

        // já tem empréstimo desse livro
        if (emprestimoManager.possuiEmprestimoDoLivro(livro.getCodigo())) {
            System.out.println("O usuário " + usuario.getNome() + " já possui um exemplar do livro " + livro.getTitulo());
            return false;
        }

        return true;
    }

    public int tempoDeEmprestimo() {
        return 8;
    }
}
