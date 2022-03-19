package challengeSofkaU.services;


import challengeSofkaU.DAO.PreguntaDAO;
import challengeSofkaU.models.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePregunta {

    @Autowired
    private PreguntaDAO daoP;

    public List<Pregunta> mostrarPreguntas() {
        List<Pregunta> listaP = daoP.mostrarPregunta();
        return listaP;
    }
}
