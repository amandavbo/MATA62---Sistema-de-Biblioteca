package BIBLIOTECA.Reserva;

import java.util.Date;
import BIBLIOTECA.Livros.Livro.ILivroObservavel;
import BIBLIOTECA.Sistema.IBiblioteca;
import BIBLIOTECA.Usuarios.IUsuarios;

public class Reserva implements IBiblioteca {
    private int reservaId;
    private ILivroObservavel livro;
    private IUsuarios usuario;
    private Date dataDeReserva;
    private boolean ativa;

    public Reserva(ILivroObservavel livro, Date dataDeReserva) {
        this.livro = livro;
        this.dataDeReserva = dataDeReserva; 
        this.ativa = true; 
    }

    public int getCodigo() {
        return reservaId;
    }

    public ILivroObservavel getLivro() {
        return livro;
    }

    public IUsuarios getUsuario() {
        return usuario;
    }

    public Date getDataDeReserva() {
        return dataDeReserva;
    }

    public boolean reservaAtiva() {
        return ativa;
    }

    public String toString() {
        return "Reserva: " + reservaId + "\n" +
               "Título do Livro: " + livro.getTitulo() + "\n" +
               "Codigo do Livro: " + livro.getCodigo() + "\n" +
               "Usuário: " + usuario.getNome() + "\n" +
               "ID do Usuário: " + usuario.getCodigo() + "\n" +
               "Data de Reserva: " + dataDeReserva.toString() + "\n" +
               "Reserva ativa: " + (reservaAtiva() ? "Sim" : "Não") + "\n";
    }
}
