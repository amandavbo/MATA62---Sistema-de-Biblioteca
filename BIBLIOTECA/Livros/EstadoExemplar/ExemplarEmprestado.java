package BIBLIOTECA.Livros.EstadoExemplar;

import java.util.Date;
import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Emprestimo.Emprestimo;
import BIBLIOTECA.Usuarios.IUsuarios;

public class ExemplarEmprestado implements IExemplarEstado {

    private Exemplar exemplar;
    private IUsuarios usuarioEmprestimo;
    private Emprestimo emprestimo;

    public ExemplarEmprestado(IUsuarios usuarioEmprestimo, Exemplar exemplar, Date dataDeEmprestimo, Date dataDeDevolucao) {
        this.exemplar = exemplar;
        this.usuarioEmprestimo = usuarioEmprestimo;
        this.emprestimo = new Emprestimo(usuarioEmprestimo, exemplar, dataDeEmprestimo, dataDeDevolucao);
    } 

    public Exemplar getExemplar() {
        return exemplar;
    }

    public IUsuarios getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void emprestar(IUsuarios usuario) {
        // Método não aplicável quando o exemplar já está emprestado
        return;
    }

    @Override
    public void emprestar(IUsuarios usuario, Emprestimo emprestimo) {
        // Método não aplicável quando o exemplar já está emprestado
        return;
    }

    public boolean estaDisponivel() {
        return false;
    }

    public void devolver() {
        exemplar.setEstado(new ExemplarDisponivel(exemplar));
    }
    
}
