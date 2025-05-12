package subsistema1;

public class CrmService {

    private CrmService(){
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo no sistema CRM.");    
        
        System.out.println("\nNome: " + nome + "\nCep: " + cep + "\nCidade: " + cidade + "\nEstado: " + estado);
    }    
    
}
