package BIBLIOTECA.Livros.EstadoExemplar;

import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Emprestimo.Emprestimo;
import java.util.Date;
import java.util.Calendar;

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

    public Emprestimo emprestar(IUsuarios usuario) {
        Date dataDeEmprestimo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataDeEmprestimo);
        calendar.add(Calendar.DAY_OF_MONTH, usuario.getRegraDeEmprestimo().tempoDeEmprestimo());
        Date dataDeDevolucao = calendar.getTime();

        Emprestimo novoEmprestimo = new Emprestimo(usuario, exemplar, dataDeEmprestimo, dataDeDevolucao);
        exemplar.setEstado(new ExemplarEmprestado(novoEmprestimo));
        return novoEmprestimo;
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
