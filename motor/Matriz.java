package motor;

import motor.objeto.*;

/**
 *
 * @author gcca
 */
public class Matriz {

    private Objeto[][] matriz = new Objeto[50][50];

    public void mover(int ox, int oy, int dx, int dy) {
            matriz[dx][dy] = matriz[ox][oy];
    }

    public void eliminar(int x, int y) {
        matriz[x][y] = null;
    }
}
