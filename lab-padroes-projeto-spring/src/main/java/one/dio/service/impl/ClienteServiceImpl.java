package one.dio.service.impl;

import org.springframework.stereotype.Service;

import one.dio.model.Cliente;
import one.dio.service.ClienteService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser injetada pelo Spring (via {@link Autowired}).
 * Como essa classe é um {@link Service}, ela é tratada como um <b>Singleton</b>.
 * 
 * @author Diego Ferreira
 */

@Service
public class ClienteServiceImpl implements ClienteService {

    // TODO Singleton: Injetar os componentes do Spring com o @Autowired.
    // TODO Strategy: Implementar os métodos definidos na interface.
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar todos os Clientes
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // FIXME Buscar clientes pelo id
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        // FIXME Verificar se o endereço do Cliente já existe (pelo cep)
        // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno
        // FIXME Inserir o Cliente, vinculando o endereço (novo ou existente)
        
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // FIXME Buscar Cliente por ID, caso exista
        // FIXME Verificar se o endereço do cliente já existe (pelo cep)
        // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno
        // FIXME Alterar Cliente, vinculando o endereço (novo ou existente)
    
    }

    @Override
    public void deletar(Long id) {
        // FIXME Deletar o cliente pelo ID.        
    }
    
}
