package motor.accion;

/**
 *
 * @author gcca
 */
import motor.Matriz;

public abstract class Accion {

    public enum Tipo {

        movimiento,
        ataque,
        construccion,
        recoleccion
    }
    public Tipo tipo;
    public int ox;
    public int oy;
    public int dx;
    public int dy;

    public abstract boolean accion(Matriz mapa);
}
