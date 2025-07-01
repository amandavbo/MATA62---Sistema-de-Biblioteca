package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Sistema.IBiblioteca;

public interface IUsuarios extends IBiblioteca {
    String getNome();
    public String pegarEmprestado(int usuarioId, int livroId);
    public String devolver(int usuarioId, int livroId);
    public String reservar(int usuarioId, int livroId);
    public long maximoDeTempoDeEmprestimo();
    public String getTipoDeUsuario();
}
