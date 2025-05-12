package one.dio.service;

import one.dio.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b>
 * 
 * @author Diego Ferreira
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
    
}
