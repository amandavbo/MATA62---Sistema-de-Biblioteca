package BIBLIOTECA.Command;

public class ConsultaExemplaresLivroCommand implements Command {
    @Override
    public void execute(CarregadorDeParametros parametros) {
        System.out.println("Consultando exemplares do livro...");
    }
}
