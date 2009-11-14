package motor.objeto;

import java.util.List;

/**
 *
 * @author gcca
 */
public class Jugador {

    private int recurso = 300;
    private List<Personaje> personajes;
    private List<Estructura> estructuras;

    public void mover(Personaje p) {
        //personajes.toArray()[0];
    }

    public void construir(Estructura e) {
        estructuras.add(e);
    }
}
