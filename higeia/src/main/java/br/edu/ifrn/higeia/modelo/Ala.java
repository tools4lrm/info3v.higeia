package br.edu.ifrn.higeia.modelo;

/**
 * Entidade que representa uma Ala Hospitalar.
 * Abrange os requisitos de armazenamento de dados da REQ.001 e REQ.002.
 */
public class Ala {
    private String nome;
    private int capacidadeMax;
    private int leitosOcupados;

    // Construtor padrão
    public Ala() {}

    // Construtor com parâmetros para facilitar a criação
    public Ala(String nome, int capacidadeMax) {
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.leitosOcupados = 0; // Inicia vazia por padrão
    }

    // Métodos de Regra de Negócio (REQ.002)
    public int getLeitosDisponiveis() {
        return this.capacidadeMax - this.leitosOcupados;
    }

    public boolean isLotada() {
        return this.leitosOcupados >= this.capacidadeMax;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public int getLeitosOcupados() {
        return leitosOcupados;
    }

    public void setLeitosOcupados(int leitosOcupados) {
        this.leitosOcupados = leitosOcupados;
    }
}
