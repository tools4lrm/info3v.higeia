package br.edu.ifrn;

import br.edu.ifrn.higeia.modelo.Ala;
import br.edu.ifrn.higeia.servico.AlaService;

public class Main {
    public static void main(String[] args) {
       // 1. Instanciando o serviço e o objeto
        AlaService service = new AlaService();
        
        Ala alaUti = new Ala();
        alaUti.setNome("UTI Cardiovascular");
        alaUti.setCapacidadeMax(10);
        alaUti.setLeitosOcupados(8);

        // 2. Testando a Regra de Negócio (REQ.001)
        System.out.println("--- Teste de Cadastro ---");
        try {
            service.cadastrarAla(alaUti);
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar: " + e.getMessage());
        }

        // 3. Testando a Visualização e Cálculos (REQ.002)
        service.exibirStatusAla(alaUti);
        
        if (alaUti.isLotada()) {
            System.out.println("Atenção: Esta ala está LOTADA!");
        } else {
            System.out.println("Status: Há leitos disponíveis.");
        }
    }
}