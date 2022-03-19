package challengeSofkaU.models;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Pregunta> preguntas;
    Usuario jugador;
    int preguntaActual;

    public Quiz() {
        preguntas= new ArrayList<>();
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public Usuario getJugador() {
        return jugador;
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }

    public Pregunta siguientePregunta(){
        Pregunta p = preguntas.get(preguntaActual);

        if (p != null) {
            preguntaActual++;
        }
        return p;

    }

    public void reiniciarQuiz(){
        preguntaActual=0;
    }
}
