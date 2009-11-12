package patron.observador;

/**
 *
 * @author gcca
 */
public interface Observador {

    public void registrar(Object o);

    public void notificar();
}
