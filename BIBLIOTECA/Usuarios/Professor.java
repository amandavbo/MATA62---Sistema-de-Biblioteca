package BIBLIOTECA.Usuarios;

public class Professor extends Usuarios {

    public Professor(int usuarioId, String nome) {
        super(usuarioId, nome);
    }

    public int maximoDeEmprestimos() {
        return Integer.MAX_VALUE;
    }

    public long maximoDeTempoDeEmprestimo() {
        return 8 * 24 * 60 * 60 * 1000; // 8 dias em milissegundos, vamos manter em milissegundos?
    }

    public boolean podeIgnorarListaDeReverva() {
        return true;
    }
    
}
