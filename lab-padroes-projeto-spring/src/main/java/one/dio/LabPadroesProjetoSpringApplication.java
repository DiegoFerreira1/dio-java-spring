package one.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring initializr
 * Módulos selecionados:
 * <p> - Spring Data JPA </p><br>
 * <p> - spring Web </p><br>
 * <p> - H2 Database </p><br>
 * <p> - OpenFeign </p><br>
 * 
 * @author Diego Ferreira
 */

 @EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}
