package BIBLIOTECA.Sistema;

//import java.util.ArrayList;

//Padrão Singleton

import java.util.ArrayList;
import java.util.List;
import BIBLIOTECA.Usuarios.IUsuarios;
import BIBLIOTECA.Usuarios.Usuarios;
import BIBLIOTECA.Livros.Livro.Livro;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Livros.Exemplar.Exemplar;

public class SistemaBiblioteca {

    private static SistemaBiblioteca instance;

    private List<IUsuarios> usuarios;
    private List<ILivroObservavel> livros;

    private SistemaBiblioteca() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        inicializarDadosTeste();
    }

    public static SistemaBiblioteca getInstance() {
        if (instance == null) {
            instance = new SistemaBiblioteca();
        }
        return instance;
    }

    private void inicializarDadosTeste() {
        //add usuários
        usuarios.add(new Usuarios(123, "João da Silva", "Aluno de Graduação"));
        usuarios.add(new Usuarios(456, "Luiz Fernando Rodrigues", "Aluno de Pós-Graduação"));
        usuarios.add(new Usuarios(789, "Pedro Paulo", "Aluno de Graduação"));
        usuarios.add(new Usuarios(100, "Carlos Lucena", "Professor"));

        //add livros
        Object[][] livrosData = {
            {100, "Engenharia de Software", "Addison Wesley", "Ian Sommerville", "6ª", "2000", 2},
            {101, "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", "2000", 1},
            {200, "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", "2014", 1},
            {201, "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", "Robert Martin", "1ª", "2002", 1},
            {300, "Refactoring: Improving the Design of Existing Code", "Addison Wesley", "Martin Fowler", "1ª", "1999", 2},
            {301, "Software Metrics: A rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3ª", "2014", 0},
            {400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison Wesley", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", "1994", 2},
            {401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley", "Martin Fowler", "3ª", "2003", 0}
        };

        int ContadorexemplarId = 1;

        for (Object[] livroData : livrosData) {

            int livroId = (int) livroData[0];
            String titulo = (String) livroData[1];
            String editora = (String) livroData[2];
            String autores = (String) livroData[3];
            String edicao = (String) livroData[4];
            String ano = (String) livroData[5];
            int qtdExemplares = (int) livroData[6];

            ILivroObservavel livro = new Livro(livroId, titulo, editora, autores, edicao, ano);

            for (int i = 0; i < qtdExemplares; i++) {
                livro.adicionarExemplar(new Exemplar(ContadorexemplarId++, livro));
            }

            livros.add(livro);
        }
    }

    public List<IUsuarios> getUsuarios() {
        return usuarios;
    }

    public List<ILivroObservavel> getLivros() {
        return livros;
    }

}
