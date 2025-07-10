package BIBLIOTECA.Emprestimo;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GerenciadorDeEmprestimos {

    private List<Emprestimo> emprestimosAtuais;
    private List<Emprestimo> historicoEmprestimos;

    public GerenciadorDeEmprestimos() {
        this.emprestimosAtuais = new ArrayList<>();
        this.historicoEmprestimos = new ArrayList<>();
    }

    public List<Emprestimo> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimosAtuais.add(emprestimo);
    }

    public void devolverEmprestimo(Emprestimo emprestimo) {
        emprestimo.getExemplar().getEstado().devolver();
        emprestimosAtuais.remove(emprestimo);
        historicoEmprestimos.add(emprestimo);
    }

    public boolean eDevedor() {
        for (Emprestimo e : emprestimosAtuais) {
            if (e.estaAtrasado()) {
                return true;
            }
        }
        return false;
    }

    public int quantidadeDeLivrosEmprestados() {
        return emprestimosAtuais.size();
    }

    public boolean possuiEmprestimoDoLivro(int livroId) {
        for (Emprestimo e : emprestimosAtuais) {
            if (e.getExemplar().getLivro().getCodigo() == livroId) {
                return true;
            }
        }
        return false;
    }

    public List<Map<String, String>> getEmprestimosFormatados() {

        List<Map<String, String>> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Emprestimo e : emprestimosAtuais) {
            Map<String, String> info = new HashMap<>();
            info.put("Título: ", e.getExemplar().getLivro().getTitulo());
            info.put("Data do Empréstimo: ", e.getDataDeEmprestimo() != null ? sdf.format(e.getDataDeEmprestimo()) : "Data não disponível");
            info.put("Status: ", "Em curso");
            info.put("Data de Devolucao: ", e.getDataDeDevolucao() != null ? sdf.format(e.getDataDeDevolucao()) : "Data não disponível");
            lista.add(info);
        }
        for (Emprestimo e : historicoEmprestimos) {
            Map<String, String> info = new HashMap<>();
            info.put("Título: ", e.getExemplar().getLivro().getTitulo());
            info.put("Data do Empréstimo: ", e.getDataDeEmprestimo() != null ? sdf.format(e.getDataDeEmprestimo()) : "Data não disponível");
            info.put("Status: ", "Finalizado");
            info.put("Data de Devolucao: ", e.getDataDeDevolucao() != null ? sdf.format(e.getDataDeDevolucao()) : "Data não disponível");
            lista.add(info);
        }
        return lista;
    }
}

