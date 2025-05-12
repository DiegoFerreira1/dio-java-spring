package one.dio.singleton;

public class Teste {
    public static void main(String[] args) {
        //teste Singleton lazy
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy.getInstancia();
        System.out.println(lazy);
        
        //teste Singleton eager
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager.getInstancia();
        System.out.println(eager);

        //teste Singleton lazyholder
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder.getInstancia();
        System.out.println(lazyHolder);

    }
    
}
