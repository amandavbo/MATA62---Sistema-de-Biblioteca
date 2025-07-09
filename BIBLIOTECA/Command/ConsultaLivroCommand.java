
package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;

import java.text.SimpleDateFormat;
import java.util.List;

import BIBLIOTECA.Emprestimo.Emprestimo;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Reserva.Reserva;
import BIBLIOTECA.Livros.Livro.Livro;

public class ConsultaLivroCommand implements Command {
    
    public void execute(CarregadorDeParametros parametros) {
        if (parametros.getParametros().length < 1) {
            System.out.println("Comando 'liv' requer o código do livro.");
            return;
        }

        try {
            int idLivro = Integer.parseInt(parametros.getParametros()[0]);
            ILivroObservavel livro = null;

            for (ILivroObservavel l : SistemaBiblioteca.getInstance().getLivros()) {
                if (l.getCodigo() == idLivro) {
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

            long exemplaresDisponiveis = livro.getExemplares().stream().filter(e -> e.getEstado().estaDisponivel()).count();
            int totalExemplares = livro.getExemplares().size();

            System.out.println("Exemplares disponíveis: " + exemplaresDisponiveis + " de " + totalExemplares);

            System.out.println("--------------------------------------------------");

            System.out.println("\nExemplares do livro '" + livro.getTitulo() + "':");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (IExemplarEmprestavel exemplar : livro.getExemplares()) {
                String status = exemplar.getEstado().estaDisponivel() ? "Disponível" : "Emprestado";
                if (status.equals("Disponível")) {
                    System.out.println("  - Exemplar ID: " + exemplar.getCodigo() + " - Disponível");
                } else {
                    Emprestimo emprestimo = exemplar.getEstado().getEmprestimo();
                    if (emprestimo != null) {
                        System.out.println("  - Exemplar ID: " + exemplar.getCodigo() + " - Emprestado para " + emprestimo.getUsuarioEmprestimo().getNome());
                        if (emprestimo.getDataDeEmprestimo() != null)
                            System.out.println("    Data de Empréstimo: " + sdf.format(emprestimo.getDataDeEmprestimo()));
                        if (emprestimo.getDataDeDevolucao() != null)
                            System.out.println("    Data de Devolução: " + sdf.format(emprestimo.getDataDeDevolucao()));
                    } else {
                        System.out.println("  - Exemplar ID: " + exemplar.getCodigo() + " - Emprestado");
                    }
                }
            }

            System.out.println("--------------------------------------------------");

            List<Reserva> reservas = livro.getReservas();

            if (reservas != null && !reservas.isEmpty()) {
                System.out.println("\nUsuários que reservaram este livro:");
                for (Reserva reserva : reservas) {
                    if (reserva.getUsuario() != null)
                        System.out.println(" ID: " + reserva.getUsuario().getCodigo() + " - " + reserva.getUsuario().getNome());
                    else
                        System.out.println(" ID: (usuário não informado)");
                }
            } else {
                System.out.println("\nNenhuma reserva para este livro.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Código do livro inválido.");
        }
    }
}
