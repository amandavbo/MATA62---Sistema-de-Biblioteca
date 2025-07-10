package BIBLIOTECA.Livros.Livro;

import java.util.ArrayList;
import java.util.List;
import BIBLIOTECA.Livros.Exemplar.IExemplarEmprestavel;
import BIBLIOTECA.Reserva.Reserva;
import BIBLIOTECA.Usuarios.IUsuarios;

public class Livro implements ILivroObservavel {
    private int livroId;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private String anoDePublicacao;
    private int qtdDeReservas;
    private List<IExemplarEmprestavel> exemplares;
    private List<Reserva> reservas;

    public Livro(int livroId, String titulo, String editora, String autores, String edicao, String anoDePublicacao) {
        this.livroId = livroId;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
        this.qtdDeReservas = 0;
        this.exemplares = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    public void adicionarExemplar(IExemplarEmprestavel exemplar) {
        this.exemplares.add(exemplar);
    }

    public List<IExemplarEmprestavel> getExemplares() {
        return exemplares;
    }

    public int getCodigo() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(String anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public int getQtdDeReservas() {
        return qtdDeReservas;
    }

    public void adicionarDaQtdDeReservas() {
        this.qtdDeReservas++;
    }

    public void removerDaQtdDeReservas() {
        if (this.qtdDeReservas > 0) {
            this.qtdDeReservas--;
        }
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        adicionarDaQtdDeReservas();
    }

    public void removerReserva(int usuarioId) {
        this.reservas.removeIf(reserva -> reserva.getUsuario().getCodigo() == usuarioId);
        removerDaQtdDeReservas();
    }

    public String toString() {
        return "Livro: " + livroId + "\n" +
               "Título: " + titulo + "\n" +
               "Editora: " + editora + "\n" +
               "Autores: " + autores + "\n" +
               "Edição: " + edicao + "\n" +
               "Ano de Publicação: " + anoDePublicacao + "\n" +
               "Quantidade de Reservas: " + qtdDeReservas + "\n";
    }

}
