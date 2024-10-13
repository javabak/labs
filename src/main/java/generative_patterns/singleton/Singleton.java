package generative_patterns.singleton;

public class Singleton {


    private static volatile Singleton instance;


    private Singleton() {
    }

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
