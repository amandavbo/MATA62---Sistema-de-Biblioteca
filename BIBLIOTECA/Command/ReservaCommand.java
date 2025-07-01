package BIBLIOTECA.Command;

public class ReservaCommand implements Command {
    @Override
    public void execute(CarregadorDeParametros parametros) {
        System.out.println("Reservando livro...");
    }
}
