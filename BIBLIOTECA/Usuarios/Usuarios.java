package BIBLIOTECA.Usuarios;

public abstract class Usuarios implements IUsuarios {
    private int usuarioId;
    private String nome;
    // private int tempoMaxEmprestimo;
    // private boolean devedor;
    // private int tempoLimLivros;
    // private ArrayList<Emp

    public Usuarios(int usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
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

    //talvez fazer uma classe ou interface para emprestimo 
    public String pegarEmprestado(int usuarioId, int livroId){
        // Implementar lógica de empréstimo
        return "Empréstimo realizado (implementação pendente)";
    }

    public String devolver(int usuarioId, int livroId){
        // Implementar lógica de devolução
        return "Empréstimo realizado (implementação pendente)";

    }

    public String reservar(int usuarioId, int livroId) {
        // Implementar lógica de reserva
        return "Empréstimo realizado (implementação pendente)";
    }


}
