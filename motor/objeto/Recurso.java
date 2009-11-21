package motor.objeto;

/**
 *
 * @author gcca
 */
public class Recurso extends Objeto {

    public int cantidad = 6000;

    public Recurso(int x, int y, String imagen) {
        super(x, y, imagen);
    }

    public void consumir(int cantidad) {
        this.cantidad -= cantidad;
    }
}
