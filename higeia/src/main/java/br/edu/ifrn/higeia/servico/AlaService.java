package br.edu.ifrn.higeia.servico;

import br.edu.ifrn.higeia.modelo.Ala;

/**
 * Classe responsável pelas regras de negócio relacionadas às Alas.
 * Implementa as validações descritas nos Critérios de Aceitação da REQ.001.
 */
public class AlaService {

    /**
     * Realiza o cadastro de uma nova ala validando os requisitos mínimos.
     * @param novaAla Objeto Ala preenchido
     * @throws IllegalArgumentException Caso os critérios de aceitação não sejam atendidos.
     */
    public void cadastrarAla(Ala novaAla) {
        
        // Critério de Aceitação REQ.001: Validar que o número de leitos é maior que zero
        if (novaAla.getCapacidadeMax() <= 0) {
            throw new IllegalArgumentException("Erro: O número máximo de leitos deve ser maior que zero!");
        }

        // Critério de Aceitação REQ.001: Impedir nomes vazios ou nulos (Boa prática)
        if (novaAla.getNome() == null || novaAla.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O nome ou código da ala é obrigatório!");
        }

        // Simulação de salvamento
        System.out.println("Processando cadastro...");
        System.out.println("Ala '" + novaAla.getNome() + "' validada e registrada com sucesso!");
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