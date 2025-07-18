package BIBLIOTECA.Emprestimo;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

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
        emprestimo.setStatus("Finalizado");
        emprestimo.setDataDeDevolucao(new Date()); 
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

        List<Emprestimo> todosEmprestimos = new ArrayList<>();
        todosEmprestimos.addAll(emprestimosAtuais);
        todosEmprestimos.addAll(historicoEmprestimos);

        for (Emprestimo e : todosEmprestimos) {
            Map<String, String> info = new HashMap<>();
            info.put("Título: ", e.getExemplar().getLivro().getTitulo());
            info.put("Data do Empréstimo: ", e.getDataDeEmprestimo() != null ? sdf.format(e.getDataDeEmprestimo()) : "Data não disponível");
            info.put("Status: ", e.getStatus());
            info.put("Data de Devolucao: ", e.getDataDeDevolucao() != null ? sdf.format(e.getDataDeDevolucao()) : "Data não disponível");
            lista.add(info);
        }
        return lista;
    }
}

