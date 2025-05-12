package one.dio.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import one.dio.model.Endereco;

/**
 * Client HTTP, criado via <b> OpenFeign</b>, para consumo da API <b>ViaCEP</b>
 * 
 *@see <a href="https://viacep.com.br/">ViaCep</a>
 * 
 * @author Diego Ferreira
 */

 @FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
    
}

