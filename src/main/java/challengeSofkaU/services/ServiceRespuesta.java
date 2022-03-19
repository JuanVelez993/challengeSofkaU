package challengeSofkaU.services;

import challengeSofkaU.DAO.RespuestaDAO;
import challengeSofkaU.models.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRespuesta {
    @Autowired
    private RespuestaDAO daoR;

    public List<Respuesta> mostrarRespuestas() {
        List<Respuesta> listaP = daoR.mostrarRespuesta();
        return listaP;
    }
}
