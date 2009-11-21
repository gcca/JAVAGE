package motor.accion;

import motor.Matriz;
import motor.objeto.*;

/**
 *
 * @author gcca
 */
public class Recoleccion extends Accion {

    public boolean accion(Matriz mapa) {
        ((Personaje) mapa.pos(ox, oy)).recolectar((Recurso) mapa.pos(dx, dy));
        return true;
    }
}
