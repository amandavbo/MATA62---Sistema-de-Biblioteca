package BIBLIOTECA.Livros.Livro;

import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Observer.Observador;
import BIBLIOTECA.Reserva.Reserva;

import java.util.List;

public interface ILivroObservavel extends ILivro {
    int getQtdDeReservas();
    void adicionarDaQtdDeReservas();
    void removerDaQtdDeReservas();
    void adicionarExemplar(IExemplarEmprestavel exemplar);
    List<IExemplarEmprestavel> getExemplares();
    List<Reserva> getReservas();
    void adicionarReserva(Reserva reserva);
    void removerReserva(int usuarioId);
    void adicionarObservador(Observador observador);
}
