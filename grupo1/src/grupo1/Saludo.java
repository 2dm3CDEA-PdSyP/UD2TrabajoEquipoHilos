/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author grupo1
 */
class Saludo extends Thread {

    private Semaphore sem;
    private int id;

    Saludo(int orden, Semaphore s) {
        this.id = orden;
        this.sem = s;
    }

    public void run() {
        if (id == 1) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hola, soy el thread" + id);
        if (id == 2) {
            sem.release();
        }
    }
}

class Orden {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Saludo t1 = new Saludo(1, semaphore);
        Saludo t2 = new Saludo(2, semaphore);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(
                    "Hilo principaldel proceso interrumpido.");
        }
        System.out.println(
                "Proceso acabando.");
    }
}
