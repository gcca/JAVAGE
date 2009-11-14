package conexion;

import java.io.*;
import java.net.*;
import java.util.*;

import patron.observador.Sujeto;
import hilo.Hilo;

/**
 *
 * @author gcca
 */
public class Servidor implements Sujeto {

    private static Servidor instancia = null;
    private ServerSocket ranura = null;
    private Stack<Object> pila = null;

    private class _Cliente {

        public Socket cliente = null;
        public ObjectOutputStream flujoSalida = null;
        public ObjectInputStream flujoEntrada = null;
    }
    private ArrayList<_Cliente> clientes = null;

    private Servidor() throws IOException {
        clientes = new ArrayList<_Cliente>();
        ranura = new ServerSocket(9999);
        pila = new Stack<Object>();
        registrar();
    }

    public static Servidor obtenerInstancia() throws IOException {
        if (instancia == null) {
            instancia = new Servidor();
        }
        return instancia;
    }

    public Object recibir() throws Exception {
        while (pila.isEmpty()) {
        }
        return pila.pop();
    }

    @Override
    public void anular(Object o) {
        pila.remove(o);
    }

    @Override
    public void notificarObservadores(Object o) {
        try {
            Iterator<_Cliente> i = clientes.iterator();
            while (i.hasNext()) {
                i.next().flujoSalida.writeObject(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrar() {
        new Hilo() {

            @Override
            public boolean funcion() {
                try {
                    final _Cliente _c = new _Cliente();
                    _c.cliente = ranura.accept();
                    _c.flujoSalida = new ObjectOutputStream(_c.cliente.getOutputStream());
                    _c.flujoEntrada = new ObjectInputStream(_c.cliente.getInputStream());
                    clientes.add(_c);
                    new Hilo() {

                        @Override
                        public boolean funcion() {
                            try {
                                Object o = _c.flujoEntrada.readObject();
                                pila.push(o);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        };
    }
}
