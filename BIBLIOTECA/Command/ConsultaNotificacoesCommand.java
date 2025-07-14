package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;

public class ConsultaNotificacoesCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();

        try {
            if (parametros.getParametros().length < 1) {
                System.out.println("----------------------------------------");
                System.out.println("Comando 'ntf' requer o código do usuário.");
                System.out.println("Uso: ntf <código_usuário>");
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

            if (usuario != null) {
                System.out.println("----------------------------------------");
                System.out.println("O usuário " + usuario.getNome() + " recebeu " + usuario.getNotificacoes() + " notificações de múltiplas reservas simultâneas.");
                System.out.println("----------------------------------------");
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Usuário com código " + usuarioId + " não encontrado.");
                System.out.println("----------------------------------------");
            }

        } catch (NumberFormatException e) {
            System.out.println("Parâmetro inválido | Use: ntf <código_usuário>");
        }
    }
}