package br.edu.ifrn.higeia.servico;

import java.util.List;

import br.edu.ifrn.higeia.modelo.Ala;
import br.edu.ifrn.higeia.repositorio.AlaRepositorio;

/**
 * Classe responsável pelas regras de negócio relacionadas às Alas.
 * Implementa as validações descritas nos Critérios de Aceitação da REQ.001.
 */
public class AlaService {

    private final AlaRepositorio repositorio = new AlaRepositorio();

    public void salvarNovaAla(Ala ala) {
        if (ala.getNome() == null || ala.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Regra: O nome da ala é obrigatório.");
        }
        if (ala.getCapacidadeMax() <= 0) {
            throw new IllegalArgumentException("Erro de Regra: A capacidade deve ser positiva.");
        }
        repositorio.inserir(ala);
    }

    public List<Ala> listarAlasDoHospital() {
        return repositorio.selecionarTodas();
    }

    public void alterarDadosAla(Ala ala) {
        if (ala.getId() == null) {
            throw new IllegalArgumentException("Erro de Regra: Não é possível atualizar um registro sem ID.");
        }
        if (ala.isLotada()) {
            System.out.println("LOG ALERTA: A ala '" + ala.getNome() + "' atingiu a lotação máxima!");
        }
        repositorio.atualizar(ala);
    }

    public void removerAlaDoHospital(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Erro de Regra: ID inválido para exclusão.");
        }
        repositorio.excluir(id);
    }

    /**
     * Simula a listagem das alas (REQ.002)
     */
    public void exibirStatusAla(Ala ala) {
        System.out.println("------------------------------------");
        System.out.println("Relatório de Ocupação - Sistema Higeia");
        System.out.println("Ala: " + ala.getNome());
        System.out.println("Capacidade: " + ala.getCapacidadeMax());
        System.out.println("Ocupados: " + ala.getLeitosOcupados());
        System.out.println("Disponíveis: " + ala.getLeitosDisponiveis());
        System.out.println("Status: " + (ala.isLotada() ? "LOTADA" : "DISPONÍVEL"));
        System.out.println("------------------------------------");
    }
}