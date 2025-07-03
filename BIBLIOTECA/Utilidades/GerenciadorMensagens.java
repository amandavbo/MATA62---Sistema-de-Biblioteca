package BIBLIOTECA.Utilidades;

public class GerenciadorMensagens {

    // private static String pularLinha = "\n";

    public static void semExemplarDisponivel(String tituloLivro) {
        System.out.println("Não há exemplares disponíveis para o livro " + tituloLivro);
    }

    public static void usuarioDevedor(String nomeUsuario) {
        System.out.println("O usuário " + nomeUsuario + " está com empréstimos em atraso");
    }

    public static void limiteEmprestimos(String nomeUsuario, int limite) {
        System.out.println("O usuário " + nomeUsuario + " já possui " + limite + " empréstimos");
    }

    public static void reservasExcedidas(String tituloLivro, int qtdReservas, String nomeUsuario) {
        System.out.println("O livro " + tituloLivro + " possui " + qtdReservas + " reservas e não está reservado por " + nomeUsuario);
    }

    public static void jaPossuiExemplar(String nomeUsuario, String tituloLivro) {
        System.out.println("O usuário " + nomeUsuario + " já possui um exemplar do livro " + tituloLivro);
    }
}