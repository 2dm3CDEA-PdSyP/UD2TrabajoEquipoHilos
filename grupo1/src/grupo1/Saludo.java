package grupo1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author grupo1 (Gorriti, Esteibar, Lozada)
 */
class Saludo extends Thread {

    private Semaphore sem;
    private int id;

    Saludo(int orden, Semaphore s) {
        this.id = orden;
        this.sem = s;
    }

    public void run() {
        
        if (id == 1 || id == 3) {
            try {
           
                // Cada adquire() se bloquea,
                //hasta que un permiso esté disponible.                
                sem.acquire();
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                
               //Cada release() añade un permiso,
               //lo que podría liberar un adquire() bloqueado. 
                 
              // sem.release();
            }
            
        }
        System.out.println("Hola, soy el thread" + id);
        if (id == 2) {
             //Cada release() añade un permiso,
             // lo que podría liberar un adquire() bloqueo. 
            sem.release();
            sem.release();
        }
    }
}