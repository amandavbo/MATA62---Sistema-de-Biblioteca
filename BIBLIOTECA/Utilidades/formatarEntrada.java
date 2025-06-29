package BIBLIOTECA.Utilidades;

public class formatarEntrada {
    private String entrada;

    public formatarEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String[] separarEntrada() {
        String[] partes;

        if (entrada == null || entrada.isEmpty()) {
            partes = new String[0];
        }
        else {
            partes = entrada.split(" ");
        }

        return partes;
    }
}