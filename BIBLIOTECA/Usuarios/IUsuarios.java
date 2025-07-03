package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Reserva.GerenciadorDeReserva;

public interface IUsuarios extends IBiblioteca {
    String getNome();
    String getTipoDeUsuario();
    GerenciadorDeEmprestimos getGerenciadorDeEmprestimos();
    GerenciadorDeReserva getGerenciadorDeReserva();
}
