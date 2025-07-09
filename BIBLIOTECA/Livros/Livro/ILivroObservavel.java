package BIBLIOTECA.Livros.Livro;

import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Reserva.Reserva;

import java.util.List;

public interface ILivroObservavel extends ILivro {
    int getQtdDeReservas();
    void adicionarDaQtdDeReservas();
    void removerDaQtdDeReservas();
    void adicionarExemplar(IExemplarEmprestavel exemplar);
    List<IExemplarEmprestavel> getExemplares();
    List<Reserva> getReservas();
}
