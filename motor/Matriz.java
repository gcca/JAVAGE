package motor;

/**
 *
 * @author gcca
 */
import motor.objeto.*;

public class Matriz {

    private Objeto[][] matriz = new Objeto[50][50];

    public boolean mover(int ox, int oy, int dx, int dy) {
        if (matriz[ox][oy] != null) {
            matriz[dx][dy] = matriz[ox][oy];
            matriz[ox][oy] = null;
            return true;
        }
        return false;
    }

    public void eliminar(int x, int y) {
        matriz[x][y] = null;
    }
}
