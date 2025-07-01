package BIBLIOTECA.Command;

public class ObservacaoCommand implements Command {
    @Override
    public void execute(CarregadorDeParametros parametros) {
        System.out.println("Observando livro...");
    }
}
