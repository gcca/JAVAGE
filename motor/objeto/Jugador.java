package motor.objeto;

import java.util.ArrayList;

/**
 *
 * @author gcca
 */
public class Jugador {

    public int recurso = 300;
    private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    private ArrayList<Estructura> estructuras = new ArrayList<Estructura>();

    public void crearEstructura(Estructura e) {
        estructuras.add(e);
    }

    public void crearPersonaje(Personaje p) {
        personajes.add(p);
    }
}
