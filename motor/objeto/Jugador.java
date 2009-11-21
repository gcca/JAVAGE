package motor.objeto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gcca
 */
public class Jugador {

    public int recurso = 300;
    private List<Personaje> personajes = new ArrayList<Personaje>();
    private List<Estructura> estructuras = new ArrayList<Estructura>();

    public void crearEstructura(Estructura e) {
        estructuras.add(e);
    }

    public void crearPersonaje(Personaje p) {
        personajes.add(p);
    }
}
