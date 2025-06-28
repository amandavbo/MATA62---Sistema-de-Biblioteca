package BIBLIOTECA.Usuarios;

public interface IUsuarios {
    public String pegarEmprestado(int usuarioId, int livroId);
    public String devolver(int usuarioId, int livroId);
    public String reservar(int usuarioId, int livroId);
}
