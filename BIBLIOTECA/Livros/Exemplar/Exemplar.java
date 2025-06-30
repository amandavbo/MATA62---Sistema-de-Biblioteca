package BIBLIOTECA.Livros.Exemplar;

import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.EstadoExemplar.IExemplarEstado;
import BIBLIOTECA.Livros.EstadoExemplar.ExemplarDisponivel;

public class Exemplar implements IExemplarEmprestavel {
    private IExemplarEstado estado;
    private int exemplarId;
    private ILivroObservavel livro;
    
    public Exemplar(int exemplarId, ILivroObservavel livro) {
        this.exemplarId = exemplarId;
        this.livro = livro;
        // inicializa o estado do exemplar como disponível
        setEstado(new ExemplarDisponivel(this));
    }

    public int getCodigo() {
        return exemplarId;
    }

    public void setExemplarId(int exemplarId) {
        this.exemplarId = exemplarId;
    }

    public ILivroObservavel getLivro() {
        return livro;
    }

    public void setLivro(ILivroObservavel livro) {
        this.livro = livro;
    }

    public IExemplarEstado getEstado() {
        return estado;
    }

    public void setEstado(IExemplarEstado estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return livro.getTitulo();
    }

    public String getEditora() {
        return livro.getEditora();
    }

    public String getAutores() {
        return livro.getAutores();
    }

    public String getEdicao() {
        return livro.getEdicao();
    }

    public String getAnoDePublicacao() {
        return livro.getAnoDePublicacao();
    }

    public String toString() {
        return "Titulo do Livro: " + getTitulo() + "\n" +
               "Código do Livro: " + getLivro().getCodigo() + "\n" +
               "Autor(es): " + getAutores() + "\n" +
               "Editora: " + getEditora() + "\n" +
               "Edição: " + getEdicao() + "\n" +
               "Ano de Publicação: " + getAnoDePublicacao() + "\n" +
               "Codigo do Exemplar: " + getCodigo() + "\n";
               //"Disponibilidade: " + (estaDisponivel() ? "Disponível" : "Indisponível") + "\n";

              
    }
}

