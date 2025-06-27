package BIBLIOTECA.Usuarios;

public abstract class Usuarios implements IUsuarios {
    private int usuarioId;
    private String nome;

    public Usuarios(int usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
