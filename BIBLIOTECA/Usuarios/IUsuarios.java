package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Reserva.GerenciadorDeReserva;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Strategy.RegrasDeEmprestimo;


public interface IUsuarios extends IBiblioteca {
    String getNome();
    String getTipoDeUsuario();
    GerenciadorDeEmprestimos getGerenciadorDeEmprestimos();
    GerenciadorDeReserva getGerenciadorDeReserva();
    void adicionarReserva(ILivroObservavel livro);
    RegrasDeEmprestimo getRegraDeEmprestimo();
    int getNotificacoes(); // Adicionado para o contador de notificações
    void observar(ILivroObservavel livro); // Adicionado para a funcionalidade de observação
}
