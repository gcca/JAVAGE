package motor.objeto;

/**
 *
 * @author gcca
 */
public class Estructura extends Objeto {

    private int vida = 900;

    public Estructura(int x, int y, String imagen) {
        super(x, y, imagen);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
