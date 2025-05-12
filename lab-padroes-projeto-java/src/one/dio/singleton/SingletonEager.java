package one.dio.singleton;

/**
 * Singleton "apressado"
 * @author Diego Ferreira
 */

public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstancia(){

        return instancia;
    }


    
}
