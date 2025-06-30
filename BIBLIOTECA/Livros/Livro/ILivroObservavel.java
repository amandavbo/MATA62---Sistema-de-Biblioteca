package BIBLIOTECA.Livros.Livro;

public interface ILivroObservavel extends ILivro {

    public int getQtdDeReservas();
    public void adicionarDaQtdDeReservas();
    public void removerDaQtdDeReservas();
    
}
