package BIBLIOTECA.Livros.EstadoExemplar;

import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Emprestimo.Emprestimo;

public class ExemplarDisponivel implements IExemplarEstado {

    private Exemplar exemplar;

    public ExemplarDisponivel(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void devolver() {
        return;
    }

    public void emprestar(IUsuarios usuario, Emprestimo emprestimo) {
        exemplar.setEstado(new ExemplarEmprestado(usuario, exemplar, emprestimo.getDataDeEmprestimo(), emprestimo.getDataDeDevolucao()));
    }

    public boolean estaDisponivel() {
        return true;
    }

    public Emprestimo getEmprestimo() {
        return null;
    }

    public IUsuarios getUsuarioEmprestimo() {
        return null;
    }

}
