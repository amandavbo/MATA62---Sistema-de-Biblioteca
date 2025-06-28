package MATA62---Sistema-de-Biblioteca.BIBLIOTECA;


import java.util.ArrayList;


public class SistemaBiblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public SistemaBiblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public String consultarInfoLivro(){
        this.buscarLivroPorId();
    }

    public void buscarLivroPorId(int livroId) {
        for (Livro livro : livros) {
            if (livro.getLivroId() == livroId) {
                System.out.println("Livro encontrado: " + livro.getTitulo());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
        
    }

}
