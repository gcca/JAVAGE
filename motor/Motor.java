package motor;

import conexion.Servidor;
import motor.accion.Accion;

/**
 *
 * @author gcca
 */
public class Motor {

    private Matriz mapa = new Matriz();
    private char mapa_car[][] = new char[50][50];
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
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    if (mapa.pos(i, j).tipo == null) {
                        mapa_car[i][j] = '\0';
                    } else {
                        switch (mapa.pos(i, j).tipo) {
                            case estructura:
                                mapa_car[i][j] = 'e';
                                break;
                            case personaje:
                                mapa_car[i][j] = 'p';
                                break;
                            case recurso:
                                mapa_car[i][j] = 'r';
                                break;
                        }
                    }
                }
            }

            servidor.notificarObservadores(mapa_car);
        }
    }
}
