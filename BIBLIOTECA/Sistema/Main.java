package BIBLIOTECA.Sistema;

import java.util.Scanner;
import BIBLIOTECA.Command.CarregadorDeParametros;
import BIBLIOTECA.Command.ComandosDoUsuario;

public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca.getInstance();
        ComandosDoUsuario interfaceUsuario = new ComandosDoUsuario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Comandos disponíveis:");
        System.out.println("emp [ID do usuário] [ID do livro] - Empréstimo de livro");
        System.out.println("dev [ID do usuário] [ID do livro] - Devolução de livro");
        System.out.println("res [ID do usuário] [ID do livro] - Reserva de livro");
        System.out.println("obs [ID do usuário] [ID do livro] - Observação de livro");
        System.out.println("liv [ID do livro] - Consulta de informações de livro");
        System.out.println("usu [ID do usuário] - Consulta de informações de usuário");
        System.out.println("ntf [ID do usuário] - Consulta de notificações recebidas");
        System.out.println("lus - Listar todos os usuários cadastrados");
        System.out.println("llv - Listar todos os livros disponíveis");
        System.out.println("sair - Sair do sistema");

        while (true) {
            System.out.print("Digite o comando: ");
            String command = scanner.nextLine();
            if (command.trim().equalsIgnoreCase("sair")) {
                System.out.println("Saindo do sistema...");
                break;
            }
            String[] parts = command.trim().split("\\s+");
            String strComando = parts[0];
            String[] parametrosArray = new String[parts.length - 1];
            System.arraycopy(parts, 1, parametrosArray, 0, parametrosArray.length);
            CarregadorDeParametros parametros = new CarregadorDeParametros(parametrosArray);
            interfaceUsuario.executarComando(strComando, parametros);
        }
        scanner.close();
    }
}
