package motor;

import conexion.Servidor;
import motor.accion.Accion;

/**
 *
 * @author gcca
 */
public class Motor {

    private Matriz mapa = new Matriz();
    private Servidor servidor;

    public Motor() throws Exception {
        servidor = Servidor.obtenerInstancia();
    }

    public void juego() throws Exception {
        //Inicio de juego (falta)
        while (servidor.clientesN() < 4) {
        }

        //Iniciar mapa

        while (true) {
            Accion accion = (Accion) servidor.recibir();
            accion.accion(mapa);
            servidor.notificarObservadores(mapa);
        }
    }
}
