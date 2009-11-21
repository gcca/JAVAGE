package motor.objeto;

/**
 *
 * @author gcca
 */
public class Personaje extends Objeto {

    public int vida = 100;
    private int ataque = 10;
    public int recoleccion = 5;

    public Personaje(int x, int y, String imagen) {
        super(x, y, imagen);
        tipo = Tipo.personaje;
    }

    public void atacar(Personaje p) {
        p.vida -= ataque;
    }

    public void recolectar(Recurso r) {
        r.cantidad -= recoleccion;
    }
}
