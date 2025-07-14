
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
        
        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();

        if (parametros.getParametros().length < 1) {
            System.out.println("----------------------------------------");
            System.out.println("Comando 'liv' requer o código do livro.");
            System.out.println("Uso: liv <código_livro>");
            System.out.println("----------------------------------------");
            
            return;
        }

        try {
            int idLivro = Integer.parseInt(parametros.getParametros()[0]);
            ILivroObservavel livro = null;

            for (ILivroObservavel l : sistema.getLivros()) {
                if (l.getCodigo() == idLivro) {
                    livro = l;
                    break;
                }
            }

            if (livro == null) {
                System.out.println("Livro com código " + idLivro + " não encontrado.");
                return;
            }

            System.out.println("----------------------------------------");
            System.out.println("Título: " + livro.getTitulo());

            List<Reserva> reservas = livro.getReservas();
            System.out.println("Quantidade de reservas: " + (reservas != null ? reservas.size() : 0));
            if (reservas != null && !reservas.isEmpty()) {
                for (Reserva reserva : reservas) {
                    if (reserva.getUsuario() != null) {
                        System.out.println("    - " + reserva.getUsuario().getNome());
                    }
                }
            }

            System.out.println("Exemplares:");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (IExemplarEmprestavel exemplar : livro.getExemplares()) {
                String status = exemplar.getEstado().estaDisponivel() ? "disponível" : "emprestado";
                System.out.println("    - Código: " + exemplar.getCodigo() + " | Status: " + status);

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
            System.out.println("----------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Parâmetro inválido | Use: liv <código_livro>");
        }
    }
}
