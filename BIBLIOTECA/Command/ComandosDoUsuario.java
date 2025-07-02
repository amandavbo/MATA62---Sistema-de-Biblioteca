package BIBLIOTECA.Command;

import java.util.HashMap;
import java.util.Map;

public class ComandosDoUsuario {

    private final Map<String, Command> comandos;

    public ComandosDoUsuario() {
        comandos = new HashMap<>();
        comandos.put("emp", new EmprestimoCommand());
        comandos.put("dev", new DevolucaoCommand());
        comandos.put("lus", new ListarUsuariosCommand());
        comandos.put("llv", new ListarLivrosCommand());
        comandos.put("liv", new ConsultaLivroCommand());
        comandos.put("obs", new ObservacaoCommand());
        comandos.put("res", new ReservaCommand());
        comandos.put("usu", new ConsultaUsuarioCommand());
        comandos.put("ntf", new ConsultaNotificacoesCommand());
    }

    public void executarComando(String strComando, CarregadorDeParametros parametros) {
        Command comando = comandos.get(strComando);
        if (comando != null) {
            comando.execute(parametros);
        } else {
            System.out.println("Comando não reconhecido.");
        }
    }
}
