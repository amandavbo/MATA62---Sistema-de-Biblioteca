package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Strategy.RegraDeEmprestimoAlunoGraduacao;
import BIBLIOTECA.Strategy.RegraDeEmprestimoAlunoPosGraduacao;
import BIBLIOTECA.Strategy.RegraDeEmprestimoProfessor;
import BIBLIOTECA.Strategy.RegrasDeEmprestimo;

public class Usuarios implements IUsuarios {
    private int usuarioId;
    private String nome;
    private String TipoDeUsuario;
    private GerenciadorDeEmprestimos gerenciadorDeEmprestimos;
    private RegrasDeEmprestimo regraDeEmprestimo;

    public Usuarios(int usuarioId, String nome, String tipoDeUsuario) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.TipoDeUsuario = tipoDeUsuario;
        this.gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos();
        this.regraDeEmprestimo = definirRegraDeEmprestimo(tipoDeUsuario);
    }
    
    public GerenciadorDeEmprestimos getGerenciadorDeEmprestimos() {
        return gerenciadorDeEmprestimos;
    }

    private RegrasDeEmprestimo definirRegraDeEmprestimo(String tipoDeUsuario) {
        java.util.Map<String, RegrasDeEmprestimo> estrategia = new java.util.HashMap<>();
        estrategia.put("Aluno de Graduação", new RegraDeEmprestimoAlunoGraduacao());
        estrategia.put("Aluno de Pós-Graduação", new RegraDeEmprestimoAlunoPosGraduacao());
        estrategia.put("Professor", new RegraDeEmprestimoProfessor());
        return estrategia.get(tipoDeUsuario);
    }

    public RegrasDeEmprestimo getRegraDeEmprestimo() {
        return regraDeEmprestimo;
    }

    public int getCodigo() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeUsuario() {
        return TipoDeUsuario;
    }
}
