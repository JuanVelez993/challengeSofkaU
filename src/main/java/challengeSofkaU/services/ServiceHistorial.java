package challengeSofkaU.services;

import challengeSofkaU.DAO.HistorialDAO;
import challengeSofkaU.models.Historial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHistorial {
    @Autowired
    private HistorialDAO daoh;

    public boolean insertarHistorial(Historial hist) {
        return daoh.insertarHistorial(hist);
    }

    public List<Historial> mostrarHistorial() {
        List<Historial> listaH = daoh.mostrarHistorial();
        return listaH;
    }
}
