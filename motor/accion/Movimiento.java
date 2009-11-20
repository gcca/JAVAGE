package motor.accion;

import motor.Matriz;

/**
 *
 * @author gcca
 */
public class Movimiento extends Accion {

    public boolean accion(Matriz mapa) {
        mapa.mover(ox, oy, dx, dy);
        return true;
    }
}
