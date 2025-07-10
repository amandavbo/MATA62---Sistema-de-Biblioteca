package BIBLIOTECA.Livros.EstadoExemplar;

import BIBLIOTECA.Emprestimo.Emprestimo;
import BIBLIOTECA.Livros.Exemplar.Exemplar;
import BIBLIOTECA.Usuarios.IUsuarios;

public interface IExemplarEstado {
    public Emprestimo emprestar(IUsuarios usuario);
    public void devolver();
    public boolean estaDisponivel();
    public Exemplar getExemplar();
    public IUsuarios getUsuarioEmprestimo();
    public Emprestimo getEmprestimo();
}
