
package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Reserva.Reserva;

public class ConsultaLivroCommand implements Command {
    @Override
    public void execute(CarregadorDeParametros parametros) {
        if (parametros.getParametros().length < 1) {
            System.out.println("Comando 'liv' requer o código do livro.");
            return;
        }

        try {
            int idLivro = Integer.parseInt(parametros.getParametros()[0]);
            ILivroObservavel livro = null;

            for (ILivroObservavel l : SistemaBiblioteca.getInstance().getLivros()) {
                if (l instanceof BIBLIOTECA.Livros.Livro.Livro && ((BIBLIOTECA.Livros.Livro.Livro) l).getCodigo() == idLivro) {
                    livro = l;
                    break;
                }
            }

            if (livro == null) {
                System.out.println("Livro com código " + idLivro + " não encontrado.");
                return;
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Informações do Livro");
            System.out.println("--------------------------------------------------");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Autores: " + livro.getAutores());
            System.out.println("Edição: " + livro.getEdicao());
            System.out.println("Ano de Publicação: " + livro.getAnoDePublicacao());

            long exemplaresDisponiveis = SistemaBiblioteca.getInstance().getExemplaresDoLivro(livro).stream().filter(e -> e.getEstado().estaDisponivel()).count();
            int totalExemplares = SistemaBiblioteca.getInstance().getExemplaresDoLivro(livro).size();

            System.out.println("Exemplares disponíveis: " + exemplaresDisponiveis + " de " + totalExemplares);

            System.out.println("--------------------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Código do livro inválido.");
        }
    }
}
