package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;

public interface IUsuarios extends IBiblioteca {
    String getNome();
    String getTipoDeUsuario();
    GerenciadorDeEmprestimos getGerenciadorDeEmprestimos();
}
