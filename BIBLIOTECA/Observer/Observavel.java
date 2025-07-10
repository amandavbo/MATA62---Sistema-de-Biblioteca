package BIBLIOTECA.Observer;

import java.util.ArrayList;
import java.util.List;

import BIBLIOTECA.Livros.Livro.ILivroObservavel;

public class Observavel {
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(ILivroObservavel livro) {
        for (Observador observador : observadores) {
            observador.update(livro);
        }
    }
}
