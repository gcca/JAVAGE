package motor.accion;

import motor.Matriz;
import motor.objeto.Estructura;

/**
 *
 * @author gcca
 */
public class Construccion extends Accion {

    public boolean accion(Matriz mapa) {
        mapa.ingresar(dx, dy, new Estructura(dx, dy, "imagen"));
        return true;
    }
}
