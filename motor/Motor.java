package motor;

import conexion.Servidor;
import java.util.*;
import motor.accion.Accion;
import motor.objeto.Jugador;
import motor.objeto.Personaje;

/**
 *
 * @author gcca
 */
public class Motor {

    private Matriz mapa = new Matriz();
    private char mapa_car[][] = new char[50][50];
    private Servidor servidor;
    private List<Jugador> jugadores = new ArrayList<Jugador>();

    public Motor() throws Exception {
        servidor = Servidor.obtenerInstancia();
    }

    public void juego() throws Exception {
        int ant = servidor.clientesN();
        int act = ant;
        while ((act = servidor.clientesN()) < 4) {
            if (ant != act) {
                jugadores.add(new Jugador());
                ant = act;
            }
        }

        Personaje temp;
        jugadores.get(0).crearPersonaje(temp = new Personaje(0, 0, null));
        mapa.ingresar(0, 0, temp);
        jugadores.get(1).crearPersonaje(new Personaje(0, 50, null));
        mapa.ingresar(0, 50, temp);
        jugadores.get(2).crearPersonaje(new Personaje(50, 0, null));
        mapa.ingresar(50, 0, temp);
        jugadores.get(3).crearPersonaje(new Personaje(50, 50, null));
        mapa.ingresar(50, 50, temp);

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
            servidor.notificarObservadores(accion);
        }
    }
}
