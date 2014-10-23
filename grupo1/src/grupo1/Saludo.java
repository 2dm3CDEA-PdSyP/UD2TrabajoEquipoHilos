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
        if (id == 1 || id == 3) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
               // sem.release();
            }
            
        }
        System.out.println("Hola, soy el thread" + id);
        if (id == 2) {
            sem.release();
            //sem.release();
        }
    }
}