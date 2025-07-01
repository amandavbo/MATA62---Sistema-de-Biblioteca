package BIBLIOTECA.Command;

// armazenar e acessar os parâmetros recebidos de comandos, individualmente ou como array.

public class CarregadorDeParametros {

    private String[] parametros;

    public CarregadorDeParametros(String[] parametros) {
        this.parametros = parametros;
    }

    public String getParametro(int index) {
        if (parametros != null && index >= 0 && index < parametros.length) {
            return parametros[index];
        }
        return null;
    }

    public String[] getParametros() {
        return parametros;
    }
}
