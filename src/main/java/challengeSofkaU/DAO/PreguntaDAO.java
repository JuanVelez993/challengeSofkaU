package challengeSofkaU.DAO;

import challengeSofkaU.models.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaDAO<Pregunta> {

    List<Pregunta> mostrarPregunta();
    List<Pregunta> filtrarDificultad(int dif);
}
