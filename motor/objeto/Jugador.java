package motor.objeto;

/**
 *
 * @author gcca
 */
import java.util.List;

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
