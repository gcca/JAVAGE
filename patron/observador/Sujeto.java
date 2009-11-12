package patron.observador;

/**
 *
 * @author gcca
 */
public interface Sujeto {

    public void registrar();

    public void anular(Object o);

    public void notificarObservadores(Object o);
}
