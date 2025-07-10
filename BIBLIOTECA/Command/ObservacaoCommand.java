package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;

public class ObservacaoCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();

        try {
            if (parametros.getParametros().length < 2) {
                System.out.println("----------------------------------------");
                System.out.println("Comando 'obs' requer o código do usuário e o código do livro.");
                System.out.println("Uso: obs <código_usuário> <código_livro>");
                System.out.println("----------------------------------------");
                return;
            }

            int usuarioId = Integer.parseInt(parametros.getParametro(0));
            int livroId = Integer.parseInt(parametros.getParametro(1));

            IUsuarios usuario = null;

            for (IUsuarios u : sistema.getUsuarios()) {
                if (u.getCodigo() == usuarioId) {
                    usuario = u;
                    break;
                }
            }

            ILivroObservavel livro = null;
            for (ILivroObservavel l : sistema.getLivros()) {
                if (l.getCodigo() == livroId) {
                    livro = l;
                    break;
                }
            }

            if (usuario != null && livro != null) {
                usuario.observar(livro);

            } else {
                System.out.println("----------------------------------------");
                System.out.println("Usuário ou livro não encontrado.");
                System.out.println("----------------------------------------");
            }

        } catch (NumberFormatException e) {
            System.out.println("Códigos de usuário ou livro inválidos.");
        }
    }
}