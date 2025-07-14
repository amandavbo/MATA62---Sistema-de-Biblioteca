import BIBLIOTECA.Command.ComandosDoUsuario;
import BIBLIOTECA.Command.CarregadorDeParametros;

public class teste {

    public static void executeCommand(String command) {
        System.out.println("Executando comando: " + command);
        String[] parts = command.split(" ");
        String str_comando = parts[0];
        String[] parametrosArray = new String[parts.length - 1];
        System.arraycopy(parts, 1, parametrosArray, 0, parts.length - 1);

        ComandosDoUsuario comandosDoUsuario = new ComandosDoUsuario();
        CarregadorDeParametros parametros = new CarregadorDeParametros(parametrosArray);
        
        comandosDoUsuario.executarComando(str_comando, parametros);
    }

    public static void main(String[] args) {

        executeCommand("lus");
        executeCommand("llv");

        System.out.println("\nTestar Observação");
        executeCommand("obs 100 100");
        executeCommand("obs 100 101");
        executeCommand("res 123 100");
        executeCommand("res 456 100");
        executeCommand("res 123 101");
        executeCommand("ntf 100");
        executeCommand("res 789 100");
        executeCommand("ntf 100");
        executeCommand("res 456 101");
        executeCommand("res 789 101");
        executeCommand("ntf 100");

        System.out.println("\nTestar Consulta Livros");
        executeCommand("liv 100");
        executeCommand("liv 101");

        System.out.println("\nTestar Histórico de Emprestimo");
        executeCommand("emp 123 101");
        executeCommand("dev 123 101");
        executeCommand("emp 123 100");

        System.out.println("\nTestar Consulta Usuario");
        executeCommand("res 123 200");
        executeCommand("usu 123");
    }
}
