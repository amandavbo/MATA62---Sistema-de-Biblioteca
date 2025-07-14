package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import java.util.List;
import java.util.Map;

public class ConsultaUsuarioCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();

        try {
            if (parametros.getParametros().length < 1) {
                System.out.println("----------------------------------------");
                System.out.println("Comando 'usu' requer o código do usuário.");
                System.out.println("Uso: usu <código_usuário>");
                System.out.println("----------------------------------------");
                return;
            }

            int usuarioId = Integer.parseInt(parametros.getParametro(0));

            IUsuarios usuario = null;
            for (IUsuarios u : sistema.getUsuarios()) {
                if (u.getCodigo() == usuarioId) {
                    usuario = u;
                    break;
                }
            }

            if (usuario == null) {
                System.out.println("Usuário com código " + usuarioId + " não encontrado.");
                return;
            }

            System.out.println("----------------------------------------");
            System.out.println("Informações do Usuário: " + usuario.getNome() + " (Código: " + usuario.getCodigo() + ")");
            System.out.println("----------------------------------------");

            // Empréstimos
            System.out.println("Empréstimos:");
            List<Map<String, String>> emprestimos = usuario.getGerenciadorDeEmprestimos().getEmprestimosFormatados();
            if (emprestimos.isEmpty()) {
                System.out.println("  Nenhum empréstimo encontrado.");
            } else {
                for (Map<String, String> emp : emprestimos) {
                    System.out.println("  - Título: " + emp.get("Título: "));
                    System.out.println("    Data de Empréstimo: " + emp.get("Data do Empréstimo: "));
                    System.out.println("    Status: " + emp.get("Status: "));
                    String status = emp.get("Status: ");
                    String label = (status != null && status.equalsIgnoreCase("Em curso")) ? "Data de Devolução Prevista" : "Data de Devolução";
                    System.out.println("    " + label + ": " + emp.get("Data de Devolucao: "));
                    System.out.println("    --------------------");
                }
            }

            System.out.println("----------------------------------------");

            // Reservas
            System.out.println("Reservas:");
            List<Map<String, String>> reservas = usuario.getGerenciadorDeReserva().getReservasFormatadas();
            if (reservas.isEmpty()) {
                System.out.println("  Nenhuma reserva encontrada.");
            } else {
                for (Map<String, String> res : reservas) {
                    System.out.println("  - Título: " + res.get("Título: "));
                    System.out.println("    Data de reserva: " + res.get("Data de reserva: "));
                    System.out.println("    --------------------");
                }
            }

            System.out.println("----------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("----------------------------------------");
            System.out.println("Parâmetro inválido | Use: usu <código_usuário>");
            System.out.println("----------------------------------------");
        } catch (Exception e) {
            System.out.println("----------------------------------------");
            System.out.println("Ocorreu um erro ao consultar o usuário: " + e.getMessage());
            System.out.println("----------------------------------------");
    }
}
}
