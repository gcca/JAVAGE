package conexion;

/**
 *
 * @author gcca
 */
import java.io.*;
import java.net.*;

import patron.observador.Observador;

public class Cliente implements Observador {

    private static Cliente instancia = null;
    private Socket ranura = null;
    private ObjectOutputStream flujoSalida = null;
    private ObjectInputStream flujoEntrada = null;

    private Cliente(String maquina) {
        registrar(maquina);
    }

    public static Cliente obtenerInstancia(String maquina) {
        if (instancia == null) {
            instancia = new Cliente(maquina);
        }
        return instancia;
    }

    public void cerrar() throws IOException {
        flujoSalida.close();
        flujoEntrada.close();
        ranura.close();
    }

    public void enviar(Object o) throws IOException {
        flujoSalida.writeObject(o);
    }

    public Object recibir() {
        try {
            return flujoEntrada.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void notificar() {
    }

    @Override
    public void registrar(Object o) {
        try {
            ranura = new Socket((String) o, 9999);
            flujoSalida = new ObjectOutputStream(ranura.getOutputStream());
            flujoEntrada = new ObjectInputStream(ranura.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
