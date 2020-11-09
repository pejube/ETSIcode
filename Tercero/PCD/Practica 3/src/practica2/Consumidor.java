package practica2;

import java.util.Random;

public class Consumidor implements Runnable {

    private final ICola c;

    public Consumidor(ICola c) {
        this.c = c;
    }

    private void consumir() {
        Random r = new Random();
        r.setSeed(System.nanoTime());
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(2000 + Math.abs(r.nextInt()) % 2000);
                System.out.println("Hilo " + Thread.currentThread().getId() + " Extraigo: " + c.Desacola());
            } catch (Exception ex) {
                System.out.println("Hilo " + Thread.currentThread().getId() + " Error al extraer: " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        consumir();
    }
}
