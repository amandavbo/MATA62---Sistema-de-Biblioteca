package BIBLIOTECA.Livros.EstadoExemplar;

public class ExemplarDisponivel implements IExemplarEstado {

    private Exemplar exemplar;

    public ExemplarDisponivel(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

}
