package BIBLIOTECA.Usuarios;

import BIBLIOTECA.Emprestimo.GerenciadorDeEmprestimos;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Reserva.GerenciadorDeReserva;
import BIBLIOTECA.Reserva.Reserva;
import BIBLIOTECA.Strategy.RegraDeEmprestimoAlunoGraduacao;
import BIBLIOTECA.Strategy.RegraDeEmprestimoAlunoPosGraduacao;
import BIBLIOTECA.Strategy.RegraDeEmprestimoProfessor;
import BIBLIOTECA.Strategy.RegrasDeEmprestimo;
import BIBLIOTECA.Observer.Observador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Usuarios implements IUsuarios {
    private int usuarioId;
    private String nome;
    private String TipoDeUsuario;
    private GerenciadorDeEmprestimos gerenciadorDeEmprestimos;
    private RegrasDeEmprestimo regraDeEmprestimo;
    private GerenciadorDeReserva gerenciadorDeReserva;
    private Observador observadorUsuario; //composição
    private List<ILivroObservavel> livrosObservados;

    public Usuarios(int usuarioId, String nome, String tipoDeUsuario) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.TipoDeUsuario = tipoDeUsuario;
        this.gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos();
        this.regraDeEmprestimo = definirRegraDeEmprestimo(tipoDeUsuario);
        this.gerenciadorDeReserva = new GerenciadorDeReserva();
        this.observadorUsuario = new Observador(this);
        this.livrosObservados = new ArrayList<>();

    }
    public GerenciadorDeEmprestimos getGerenciadorDeEmprestimos() {
        return gerenciadorDeEmprestimos;
    }

    public int getNotificacoes() {
        return observadorUsuario.getNotificacoes();
    }

    private RegrasDeEmprestimo definirRegraDeEmprestimo(String tipoDeUsuario) {
        Map<String, RegrasDeEmprestimo> estrategia = new HashMap<>();
        estrategia.put("Aluno de Graduação", new RegraDeEmprestimoAlunoGraduacao());
        estrategia.put("Aluno de Pós-Graduação", new RegraDeEmprestimoAlunoPosGraduacao());
        estrategia.put("Professor", new RegraDeEmprestimoProfessor());
        return estrategia.get(tipoDeUsuario);
    }

    public RegrasDeEmprestimo getRegraDeEmprestimo() {
        return regraDeEmprestimo;
    }

    public GerenciadorDeReserva getGerenciadorDeReserva() {
        return gerenciadorDeReserva;
    }

    public void adicionarReserva(ILivroObservavel livro) {
        this.gerenciadorDeReserva.addReserva(livro, this);
    }

    public void removerReserva(int livroId) {
        this.gerenciadorDeReserva.removerReserva(livroId);
    }

    public List<Reserva> getReservas() {
        return this.gerenciadorDeReserva.getReservas();
    }

    public List<Map<String, String>> getReservasFormatadas() {
        return this.gerenciadorDeReserva.getReservasFormatadas();
    }

    public boolean possuiReserva(ILivroObservavel livro) {
        return this.gerenciadorDeReserva.possuiReserva(livro);
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

    public void observar(ILivroObservavel livro) {
        if (!livrosObservados.contains(livro)) {
            livrosObservados.add(livro);
            livro.adicionarObservador(this.observadorUsuario);
            System.out.println("----------------------------------------");
            System.out.println(this.nome + " agora está observando o livro " + livro.getTitulo() + ".");
            System.out.println("----------------------------------------");
        }
    }
}
