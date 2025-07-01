package BIBLIOTECA.Strategy;

import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;

public class RegraDeEmprestimoAlunoPosGraduacao implements RegrasDeEmprestimo {

    public boolean podeEmprestar(IUsuarios usuario, ILivroObservavel livro) {

        GerenciadorDeEmprestimos emprestimoManager = usuario.getGerenciadorDeEmprestimos();
        // GerenciadorDeReservas reservaManager = usuario.getGerenciadorDeReservas();

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

        // limite de 3 empréstimos
        if (emprestimoManager.quantidadeDeLivrosEmprestados() >= 3) {
            System.out.println("O usuário " + usuario.getNome() + " já possui 2 empréstimos");
            return false;
        }

        // 4. Reservas excedidas e usuário não reservou
        // if (livro.getQtdDeReservas() >= livro.getExemplares().size() && !reservaManager.possuiReserva(livro)) {
        //     System.out.println("O livro " + livro.getTitulo() + " possui " + livro.getQtdDeReservas() + " reservas e não está reservado por " + usuario.getNome());
        //     return false;
        // }

        // já tem empréstimo desse livro
        if (emprestimoManager.possuiEmprestimoDoLivro(livro.getCodigo())) {
            System.out.println("O usuário " + usuario.getNome() + " já possui um exemplar do livro " + livro.getTitulo());
            return false;
        }

        return true;
    }

    public int tempoDeEmprestimo() {
        return 5;
    }
}
