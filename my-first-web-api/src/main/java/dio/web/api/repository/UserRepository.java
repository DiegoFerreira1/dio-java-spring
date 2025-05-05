package dio.web.api.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import dio.web.api.model.Usuario;

@Repository
public class UserRepository {

    public void save(Usuario usuario){
        if(usuario.getId() == null){
            System.out.println("SAVE - recebendo o usuário na camada de repositório.");
        }
        else{
            System.out.println("UPDATE - recebendo o usuário na camada de repositório.");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - recebendo o id: %d para excluir o usuário. ", id));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - listando os usuários do sistema.");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Diego", "123"));
        usuarios.add(new Usuario("Gleyson", "321"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - recebendo o id: %d para localização", id));
        return new Usuario("Diego", "123");
    }

    public Usuario findByUserName(String username){
        System.out.println(String.format("FIND/username: %s - Recebendo o username para localização.", username));
        return new Usuario("Gleyson", "321");
    }


    
}
