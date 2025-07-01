package BIBLIOTECA.Command;

public class ConsultaUsuarioCommand implements Command {
    @Override
    public void execute(CarregadorDeParametros parametros) {
        System.out.println("Consultando informações do usuário...");
    }
}
