package BIBLIOTECA.Sistema;

//import java.util.ArrayList;

// Padrão Singleton

public class SistemaBiblioteca {

    private static SistemaBiblioteca instance;
    private SistemaBiblioteca() {};

    public static SistemaBiblioteca getInstance() {
        if (instance == null) {
            instance = new SistemaBiblioteca();
        }
        return instance;
    }
    
    //realizar emprestimo

    //realizar devolucao

    //realizar reserva

    //observar reserva de livros

    //mostrar dados dos livros

    //mostrar dados dos usuarios

    //mostrar notificacoes dos usuarios
}
