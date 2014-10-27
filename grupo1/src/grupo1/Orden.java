/*
 * Los semáforos se usan a menudo para:
 * restringir el número de hilos que pueden acceder a algunos recursos.
TODO 
Mostrar la API y sus metodos

 */
package grupo1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author grupo1 (Gorriti, Esteibar, Lozada)
 */
public class Orden {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        // Un semáforo de conteo.
        // Conceptualmente, mantiene un conjunto de permisos.
        // 
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
                    "Hilo principal del proceso interrumpido.");
        }
        System.out.println(
                "Proceso acabando.");
    }
}
