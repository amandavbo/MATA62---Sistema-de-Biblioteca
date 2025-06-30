package BIBLIOTECA.Usuarios;

public class Professor extends Usuarios {
    // private static final int tempoMaxEmprestimo = 8;

    public Professor(int usuarioId, String nome) {
        super(usuarioId, nome);
    }

    public int maximoDeEmprestimos() {
        return Integer.MAX_VALUE;
    }

    public long maximoDeTempoDeEmprestimo() {
        return 8 * 24 * 60 * 60 * 1000; // 8 dias em milissegundos
    }

    public boolean podeIgnorarListaDeReverva() {
        return true;
    }
    
}
