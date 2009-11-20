package suceso;

import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author gcca
 */
public class Suceso {

    public Suceso(String fichero) throws Exception {
        org.apache.log4j.RollingFileAppender conf =
                new RollingFileAppender(
                new Layout() {

                    @Override
                    public String format(LoggingEvent le) {
                        return le.getLoggerName() + ": "
                                + le.getMessage()
                                + "\n";
                    }

                    @Override
                    public boolean ignoresThrowable() {
                        return true;
                    }

                    public void activateOptions() {
                    }
                }, fichero);
        org.apache.log4j.BasicConfigurator.configure(conf);
    }

    public void registrar(String cabecera, String mensaje) {
        Logger.getLogger(cabecera).error(mensaje);
    }
}
