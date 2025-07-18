package BIBLIOTECA.Emprestimo;

import java.util.Date;
import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;

public class Emprestimo implements IBiblioteca {
    private Exemplar exemplar;
    private Date dataDeEmprestimo;
    private Date dataDeDevolucao;
    private int emprestimoId;
    private IUsuarios usuarioEmprestimo;
    private String status;

    public Emprestimo(IUsuarios usuarioEmprestimo, Exemplar exemplar, Date dataDeEmprestimo, Date dataDeDevolucao) {
        this.usuarioEmprestimo = usuarioEmprestimo;
        this.exemplar = exemplar;
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataDeDevolucao = dataDeDevolucao;
        this.status = "Em curso";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean estaAtrasado() {
        Date hoje = new Date();
        return dataDeDevolucao != null && dataDeDevolucao.before(hoje);
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

    public int getCodigo() {
        return emprestimoId;
    }
    
    public IUsuarios getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }
}