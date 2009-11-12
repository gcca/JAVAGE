package hilo;

/**
 *
 * @author gcca
 */
public abstract class Hilo extends Thread {

    public abstract boolean funcion();
    private boolean interrupcion = false;

    public Hilo() {
        this.start();
    }

    @Override
    public void run() {
        while (!funcion() && !interrupcion) {
        }
    }

    public void innterrumpir() {
        interrupcion = true;
    }
}
