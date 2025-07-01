package BIBLIOTECA.Command;

import BIBLIOTECA.Sistema.SistemaBiblioteca;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import java.util.List;

public class ListarLivrosCommand implements Command {
    
    public void execute(CarregadorDeParametros parametros) {

        SistemaBiblioteca sistema = SistemaBiblioteca.getInstance();
        List<ILivroObservavel> livros = sistema.getLivros();
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("Livros disponíveis:");
        for (ILivroObservavel livro : livros) {
            System.out.println("ID: " + livro.getCodigo() + ", Título: " + livro.getTitulo() + ", Autor(es): " + livro.getAutores() + ", Editora: " + livro.getEditora() + ", Ano: " + livro.getAnoDePublicacao());
        }
    }
}
