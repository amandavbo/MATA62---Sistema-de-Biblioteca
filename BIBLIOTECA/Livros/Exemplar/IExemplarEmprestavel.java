package BIBLIOTECA.Livros.Exemplar;

import BIBLIOTECA.Livros.Livro.ILivro;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.EstadoExemplar.IExemplarEstado;

public interface IExemplarEmprestavel extends ILivro {
    public int getCodigo();
    public void setExemplarId(int exemplarId);
    public ILivroObservavel getLivro();
    public void setLivro(ILivroObservavel livro);
    public IExemplarEstado getEstado();
    public void setEstado(IExemplarEstado estado);
}
