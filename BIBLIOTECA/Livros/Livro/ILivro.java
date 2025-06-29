package BIBLIOTECA.Livros.Livro;

import BIBLIOTECA.Sistema.IBiblioteca;

public interface ILivro extends IBiblioteca {
    public String getTitulo();
    public String getEditora();
    public String getAutores();
    public String getEdicao();
    public String getAnoDePublicacao();
}
