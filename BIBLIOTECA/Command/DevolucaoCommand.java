package BIBLIOTECA.Command;

public class DevolucaoCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {
        System.out.println("Executando devolução: Usuário " + parametros.getParametro(0) + ", Livro " + parametros.getParametro(1));
    }
}
