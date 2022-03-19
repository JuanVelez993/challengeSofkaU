package challengeSofkaU.DAO;

import challengeSofkaU.models.Historial;

import java.util.List;

public interface HistorialDAO<Historial> {

    boolean insertarHistorial(challengeSofkaU.models.Historial historialActual);
    List<challengeSofkaU.models.Historial> mostrarHistorial();
}
