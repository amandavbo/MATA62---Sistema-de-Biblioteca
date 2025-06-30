package BIBLIOTECA.Usuarios;

public class AlunoPosGraduacao extends Usuarios {
    // private static final int tempoMaxEmprestimo = 5;

    public AlunoPosGraduacao(int usuarioId, String nome) {
        super(usuarioId, nome);
    }

    public int maximoDeEmprestimos() {
        return 3;
    }

    public long maximoDeTempoDeEmprestimo() {
        return 5 * 24 * 60 * 60 * 1000; // 5 dias em milissegundos
    }
    
}
