package conexion.objeto;

import motor.accion.Accion;

/**
 *
 * @author gcca
 */
public class Paquete {

    public char[][] mapa;
    public Accion accion;

    public Paquete(char[][] mapa, Accion accion) {
        this.mapa = mapa;
        this.accion = accion;
    }
}
