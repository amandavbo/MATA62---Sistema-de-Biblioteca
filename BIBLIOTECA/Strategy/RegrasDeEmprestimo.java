package BIBLIOTECA.Strategy;

import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Usuarios.IUsuarios;    

public interface RegrasDeEmprestimo {
    boolean podeEmprestar(IUsuarios usuario, ILivroObservavel livro);
    int tempoDeEmprestimo();
}

