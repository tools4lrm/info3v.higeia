package br.edu.ifrn.higeia.modelo;

/**
 * Entidade que representa uma Ala Hospitalar.
 * Mapeia diretamente os dados da tabela e abrange os requisitos REQ.001 e REQ.002.
 */
public class Ala {

    private Long id; // Identificador correspondente à Chave Primária do MySQL
    private String nome;
    private int capacidadeMax;
    private int leitosOcupados;

    public Ala() {}

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
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCapacidadeMax() { return capacidadeMax; }
    public void setCapacidadeMax(int capacidadeMax) { this.capacidadeMax = capacidadeMax; }

    public int getLeitosOcupados() { return leitosOcupados; }
    public void setLeitosOcupados(int leitosOcupados) { this.leitosOcupados = leitosOcupados; }

    @Override
    public String toString() {
        return "Ala{id=" + id + ", nome='" + nome + "', capacidadeMax=" + capacidadeMax + 
               ", leitosOcupados=" + leitosOcupados + ", disponíveis=" + getLeitosDisponiveis() + "}";
    }
}