package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Livro.Livro;
import BIBLIOTECA.Reserva.Reserva;

public class ReservaCommand implements Command {
    
    public void execute(CarregadorDeParametros parametros) {
        if (parametros.getParametros().length < 2) {
            System.out.println("Comando requer o código do usuário e do livro.");
            return;
        }
        try {
            int userId = Integer.parseInt(parametros.getParametros()[0]);
            int bookId = Integer.parseInt(parametros.getParametros()[1]);

            IUsuarios usuario = null;
            for (IUsuarios u : SistemaBiblioteca.getInstance().getUsuarios()) {
                if (u.getCodigo() == userId) {
                    usuario = u;
                    break;
                }
            }

            ILivroObservavel livro = null;
            for (ILivroObservavel l : SistemaBiblioteca.getInstance().getLivros()) {
                if (l.getCodigo() == bookId) {
                    livro = l;
                    break;
                }
            }

            if (usuario == null || livro == null) {
                System.out.println("Usuário ou livro não encontrado.");
                return;
            }

            // Limite de reservas por usuário
            if (usuario.getGerenciadorDeReserva().getReservas().size() >= 3) {
                System.out.println("Reserva não permitida para " + usuario.getNome() + " - Limite de reservas atingido");
                return;
            }

            // Usuário já possui reserva para o livro
            boolean jaReservou = usuario.getGerenciadorDeReserva().possuiReserva(livro);
            if (jaReservou) {
                System.out.println("Reserva não permitida para " + usuario.getNome() + " - Usuário já possui reserva para o livro " + livro.getTitulo());
                return;
            }

            // Todas as reservas preenchidas
            if (livro.getQtdDeReservas() >= livro.getExemplares().size()) {
                System.out.println("Reserva não permitida para " + usuario.getNome() + " - Todas as reservas estão preenchidas");
                return;
            }

            livro.adicionarReserva(usuario);
            usuario.addReserva(livro);

            System.out.println("Reserva realizada com sucesso para " + usuario.getNome() + " - " + livro.getTitulo());
        } catch (NumberFormatException e) {
            System.out.println("Código do usuário ou livro inválido.");
        }
    }
}
