package one.dio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import one.dio.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}