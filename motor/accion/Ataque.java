package motor.accion;

import motor.Matriz;
import motor.objeto.Personaje;

/**
 *
 * @author gcca
 */
public class Ataque extends Accion {

    public boolean accion(Matriz mapa) {

        ((Personaje) mapa.pos(ox, oy)).atacar((Personaje) mapa.pos(dx, dy));
        return true;
    }
}
