package dio.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.spring_security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = :username")
    User findByUserName(@Param("username") String username);

}
