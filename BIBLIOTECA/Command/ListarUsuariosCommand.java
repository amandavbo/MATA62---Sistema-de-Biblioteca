package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;
import java.util.List;

public class ListarUsuariosCommand implements Command {

    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();
        List<IUsuarios> usuarios = sistema.getUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("Usuários cadastrados:");
        for (IUsuarios usuario : usuarios) {
            System.out.println("ID: " + usuario.getCodigo() + ", Nome: " + usuario.getNome() + ", Tipo: " + usuario.getTipoDeUsuario());
        }
    }
}

