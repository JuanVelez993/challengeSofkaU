package challengeSofkaU.DAO;

import challengeSofkaU.models.Respuesta;

import java.util.List;

public interface RespuestaDAO<Respuesta> {

    List<Respuesta> mostrarRespuesta();
    List<Respuesta> filtrarRespuesta(int preg);
}
