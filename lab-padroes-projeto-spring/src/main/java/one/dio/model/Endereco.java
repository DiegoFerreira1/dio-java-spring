package one.dio.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *@see <a href="https://www.jsonschema2pojo.org/#google_vignette">JsonSchema</a>
 *@see <a href="https://viacep.com.br/">ViaCep</a>
 *@author Diego Ferreira
 */

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;   

    
}
