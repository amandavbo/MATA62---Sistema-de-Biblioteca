package BIBLIOTECA.Livros.EstadoExemplar;

import java.util.Date;
import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Emprestimo.Emprestimo;
import BIBLIOTECA.Usuarios.IUsuarios;

public class ExemplarEmprestado implements IExemplarEstado {

    private Exemplar exemplar;
    private IUsuarios usuarioEmprestimo;
    private Emprestimo emprestimo;

    public ExemplarEmprestado(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.exemplar = emprestimo.getExemplar();
        this.usuarioEmprestimo = emprestimo.getUsuarioEmprestimo();
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


    public Emprestimo emprestar(IUsuarios usuario) {
        return null;
    }

    public boolean estaDisponivel() {
        return false;
    }

    public void devolver() {
        exemplar.setEstado(new ExemplarDisponivel(exemplar));
    }
    
}
