package BIBLIOTECA.Emprestimo;

import java.util.Date;
import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;

public class Emprestimo implements IBiblioteca {

    private int emprestismoId;
    private IUsuarios usuario;
    private Exemplar exemplar;
    private Date dataDeEmprestimo;
    private Date dataDeDevolucao;
    private boolean devolvido;

    public Emprestimo(IUsuarios usuario, Exemplar exemplar) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataDeEmprestimo = new Date();
    }

    public Emprestimo(IUsuarios usuario, Exemplar exemplar, Date dataDeEmprestimo) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataDeEmprestimo = dataDeEmprestimo != null ? dataDeEmprestimo : new Date();
        this.devolvido = false;
        this.dataDeDevolucao = this.calcularDataDeDevolucao();
    }

    public int getCodigo() {
        return emprestismoId;
    }

    public IUsuarios getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public boolean estaDisponivel() {
        return devolvido;
    }

    public Date calcularDataDeDevolucao() {
        long dataLimite = dataDeEmprestimo.getTime() + usuario.maximoDeTempoDeEmprestimo();
        return new Date(dataLimite);
    }

    public void devolver() {
        this.devolvido = true;
        this.dataDeDevolucao = new Date();
    }

    public String toString() {
        return "ID do Empréstimo: " + emprestismoId + "\n" +
               "Usuário: " + usuario.getNome() + "\n" +
               "ID do Usuário: " + usuario.getCodigo() + "\n" +
               "Título do Livro: " + exemplar.getLivro().getTitulo() + "\n" +
               "Exemplar: " + exemplar.getCodigo() + "\n" +
               "Data de Empréstimo: " + dataDeEmprestimo.toString() + "\n" +
               "Data de Devolução: " + (devolvido ? dataDeDevolucao.toString() : "Não devolvido") + "\n";
    }
}
