package BIBLIOTECA.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;

public class GerenciadorDeReserva {

    private List<Reserva> reservas;

    public GerenciadorDeReserva() {
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(ILivroObservavel livro) {
        reservas.add(new Reserva(livro, new Date()));
    }

    public void removerReserva(int livroId) {
        reservas.removeIf(reserva -> {
            ILivroObservavel livro = reserva.getLivro();
            return livro != null && livro.getCodigo() == livroId;
        });
    }

    public List<java.util.Map<String, String>> getReservasFormatadas() {

        List<java.util.Map<String, String>> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Reserva reserva : reservas) {
            java.util.Map<String, String> info = new java.util.HashMap<>();

            ILivroObservavel livro = reserva.getLivro();
            String titulo = livro != null ? livro.getTitulo() : "Título não disponível";
            info.put("Título: ", titulo);
            
            Date data = reserva.getDataDeReserva();
            info.put("Data de reserva: ", data != null ? sdf.format(data) : "Data não disponível");
            lista.add(info);
        }
        return lista;
    }

    public boolean possuiReserva(ILivroObservavel livro) {

        int livroId = livro.getCodigo();

        for (Reserva reserva : reservas) {
            ILivroObservavel reservaLivro = reserva.getLivro();
            if (reservaLivro != null && reservaLivro.getCodigo() == livroId) {
                return true;
            }
        }
        return false;
    }
}