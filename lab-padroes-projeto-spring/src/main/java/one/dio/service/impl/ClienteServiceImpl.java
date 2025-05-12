package one.dio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.dio.model.Cliente;
import one.dio.model.Endereco;
import one.dio.repository.ClienteRepository;
import one.dio.repository.EnderecoRepository;
import one.dio.service.ClienteService;
import one.dio.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser injetada pelo Spring (via {@link Autowired}).
 * Como essa classe é um {@link Service}, ela é tratada como um <b>Singleton</b>.
 * 
 * @author Diego Ferreira
 */

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com o @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar clientes pelo id
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        getEnderecoCliente(cliente);
        
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            getEnderecoCliente(cliente);
        }
    
    }

    @Override
    public void deletar(Long id) {
        // Deletar o cliente pelo ID.    
        clienteRepository.deleteById(id);    
    }

    private void getEnderecoCliente(Cliente cliente) {
        // Verificar se o endereço do Cliente já existe (pelo cep)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
            // Caso não exista, integrar com o ViaCEP e persistir o retorno
            Endereco novEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novEndereco);
            return novEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir o Cliente, vinculando o endereço (novo ou existente)
        clienteRepository.save(cliente);
    }
    
}
