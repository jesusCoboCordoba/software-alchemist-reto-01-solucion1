package reto01;

import reto01.model.ClaseMala;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("ExtractMethodRecommender")
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Software-Alchemist: Reto 01");
        ejecutarCosasDeLaClaseMala();
    }

    private static void ejecutarCosasDeLaClaseMala() {
        ClaseMala cm = new ClaseMala();
        Method[] methods = cm.getClass().getMethods();
        int threads = 100;
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);

        Arrays.stream(methods)
                .forEach(method->threadPool.submit(()->method.invoke(cm)));
        threadPool.shutdown();

    }
}
