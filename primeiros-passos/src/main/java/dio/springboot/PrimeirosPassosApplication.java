package dio.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosApplication.class, args);

		/*
		Modo convencional de instanciar objetos

		Calculadora calculadora = new Calculadora();
		System.out.println("Resultado da soma: " + calculadora.somar(5, 6));
		*/
	}

}
