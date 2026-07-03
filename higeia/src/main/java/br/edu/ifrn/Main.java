package br.edu.ifrn;

import br.edu.ifrn.higeia.modelo.Ala;
import br.edu.ifrn.higeia.servico.AlaService;

public class Main {
    public static void main(String[] args) {
        AlaService alaService = new AlaService();

        System.out.println("\n--- [C] - INSERINDO Alas no MySQL (Pré-criado via Workbench) ---");
        Ala ala1 = new Ala("Maternidade", 5);
        Ala ala2 = new Ala("Isolamento Clínico", 3);

        alaService.salvarNovaAla(ala1);
        alaService.salvarNovaAla(ala2);
        
        System.out.println("\n--- [R] - SELECIONANDO e exibindo os registros ---");
        alaService.listarAlasDoHospital().forEach(System.out::println);

        System.out.println("\n--- [U] - ATUALIZANDO e Modificando Dados (Regra REQ.002) ---");
        ala2.setLeitosOcupados(3); // Alterando estado do objeto para lotado
        alaService.alterarDadosAla(ala2); 
        alaService.listarAlasDoHospital().forEach(System.out::println);

        System.out.println("\n--- [D] - EXCLUINDO um registro do MySQL ---");
        alaService.removerAlaDoHospital(ala1.getId()); 
        
        System.out.println("\nEstado final da tabela no MySQL:");
        alaService.listarAlasDoHospital().forEach(System.out::println);
    }
}