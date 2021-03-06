package motor.objeto;

/**
 *
 * @author gcca
 */
public class Objeto {

    public enum Tipo {

        estructura,
        jugador,
        objeto,
        personaje,
        recurso
    }
    public Tipo tipo=Tipo.objeto;
    private int x;
    private int y;
    private String imagen = null;

    public Objeto(int x, int y, String imagen) {
        this.x = x;
        this.y = y;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
