package BIBLIOTECA.Observer;

import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Usuarios.IUsuarios;

public class Observador {
    private IUsuarios usuario;
    private int notificacoes;

    public Observador(IUsuarios usuario) {
        this.usuario = usuario;
        this.notificacoes = 0;
    }

    public void update(ILivroObservavel livro) {
        this.notificacoes++;
    }

    public IUsuarios getUsuario() {
        return usuario;
    }

    public int getNotificacoes() {
        return notificacoes;
    }
}
