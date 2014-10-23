/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author lmll
 */
public class Orden {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Saludo t1 = new Saludo(1, semaphore);
        Saludo t2 = new Saludo(2, semaphore);
        Saludo t3 = new Saludo(3, semaphore);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(
                    "Hilo principaldel proceso interrumpido.");
        }
        System.out.println(
                "Proceso acabando.");
    }
}
