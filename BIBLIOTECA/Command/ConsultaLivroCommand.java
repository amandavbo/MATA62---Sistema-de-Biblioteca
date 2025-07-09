
package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;

import java.text.SimpleDateFormat;
import java.util.List;

import BIBLIOTECA.Emprestimo.Emprestimo;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Reserva.Reserva;


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

            System.out.println("(i) Título: " + livro.getTitulo());

            List<Reserva> reservas = livro.getReservas();
            System.out.println("(ii) Quantidade de reservas: " + (reservas != null ? reservas.size() : 0));
            if (reservas != null && !reservas.isEmpty()) {
                for (Reserva reserva : reservas) {
                    if (reserva.getUsuario() != null) {
                        System.out.println("    - " + reserva.getUsuario().getNome());
                    }
                }
            }

            System.out.println("(iii) Exemplares:");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (IExemplarEmprestavel exemplar : livro.getExemplares()) {
                String status = exemplar.getEstado().estaDisponivel() ? "disponível" : "emprestado";
                System.out.println("    - Código: " + exemplar.getCodigo() + ", Status: " + status);

                if (!exemplar.getEstado().estaDisponivel()) {
                    Emprestimo emprestimo = exemplar.getEstado().getEmprestimo();
                    if (emprestimo != null && emprestimo.getUsuarioEmprestimo() != null) {
                        System.out.println("        - Usuário: " + emprestimo.getUsuarioEmprestimo().getNome());
                        if (emprestimo.getDataDeEmprestimo() != null) {
                            System.out.println("        - Data de empréstimo: " + sdf.format(emprestimo.getDataDeEmprestimo()));
                        }
                        if (emprestimo.getDataDeDevolucao() != null) {
                            System.out.println("        - Data de devolução: " + sdf.format(emprestimo.getDataDeDevolucao()));
                        }
                    }
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Código do livro inválido.");
        }
    }
}
