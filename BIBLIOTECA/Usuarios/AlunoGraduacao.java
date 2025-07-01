package BIBLIOTECA.Usuarios;

public class AlunoGraduacao extends Usuarios {
    private static final String TipoDeusuario = "Aluno de Graduação";

    public AlunoGraduacao(int usuarioId, String nome) {
        super(usuarioId, nome);
    }

    public int maximoDeEmprestimos() {
        return 2;
    }

    public long maximoDeTempoDeEmprestimo() {
        return 4 * 24 * 60 * 60 * 1000; // 4 dias em milissegundos
    }

    public String getTipoDeUsuario() {
        return TipoDeusuario;
    }
    
}
