package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingletonService {
    private SingletonService() {
        logic();
    }

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤객체 로직 호출");
    }


}
