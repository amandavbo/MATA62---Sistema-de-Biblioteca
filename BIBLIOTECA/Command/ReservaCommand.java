package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Reserva.Reserva;

public class ReservaCommand implements Command {
    
    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();

        if (parametros.getParametros().length < 2) {
            System.out.println("Comando requer o código do usuário e do livro.");
            return;
        }
        try {
            
            int userId = Integer.parseInt(parametros.getParametros()[0]);
            int bookId = Integer.parseInt(parametros.getParametros()[1]);

            IUsuarios usuario = null;
            for (IUsuarios u : sistema.getUsuarios()) {
                if (u.getCodigo() == userId) {
                    usuario = u;
                    break;
                }
            }

            ILivroObservavel livro = null;
            for (ILivroObservavel l : sistema.getLivros()) {
                if (l.getCodigo() == bookId) {
                    livro = l;
                    break;
                }
            }

            if (usuario == null || livro == null) {

                System.out.println("Usuário ou livro não encontrado.");
                return;

            } else {
                //limite de reservas por usuário
                if (usuario.getGerenciadorDeReserva().getReservas().size() >= 2) {
                    System.out.println("Reserva não permitida para " + usuario.getNome() + " - Limite de reservas atingido");
                    return;
                }

                //usuário já possui reserva para o livro
                if (usuario.getGerenciadorDeReserva().possuiReserva(livro)) {
                    System.out.println("Reserva não permitida para " + usuario.getNome() + " - Usuário já possui reserva para o livro " + livro.getTitulo());
                    return;
                }

                //usuário já possui emprestimo do livro
                if (usuario.getGerenciadorDeEmprestimos().possuiEmprestimoDoLivro(livro.getCodigo())) {
                    System.out.println("Reserva não permitida para " + usuario.getNome() + " - Usuário já possui empréstimo do livro " + livro.getTitulo());
                    return;
                }

                //professores não podem reservar
                // if (usuario.getTipoDeUsuario().equals("Professor")) {
                //     System.out.println("Reserva não permitida para Professores");
                //     return;
                // }

                Reserva reserva = new Reserva(livro, usuario, new java.util.Date());
                usuario.adicionarReserva(livro);
                livro.adicionarReserva(reserva);

                System.out.println("Reserva realizada com sucesso para " + usuario.getNome() + " - " + livro.getTitulo());
            }
        } catch (NumberFormatException e) {
            System.out.println("Código do usuário ou livro inválido.");
        }
    }
}
