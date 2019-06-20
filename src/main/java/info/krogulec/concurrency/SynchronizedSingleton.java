package info.krogulec.concurrency;

/**
 * Jak stworzyć bezpiecznego wątkowo singletona
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){

    }

    public static SynchronizedSingleton getInstance(){
        if (instance != null){
            return instance;
        } else {
            if (instance == null){
                synchronized (SynchronizedSingleton.class){
                    if (instance == null){
                        instance = new SynchronizedSingleton();
                    }
                }
            }

            return instance;
        }
    }
}