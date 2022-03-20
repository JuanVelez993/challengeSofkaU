package challengeSofkaU.models;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    //El identificador de la pregunta
    int id_pregunta;
    //La dificultad o categoria
    int dificultad;
    //La descripcion de la pregunta
    String textoPregunta;
    //La posicion de la respuesta correcta
    int id_respuesta;
    //La lista de posibles respuestas
    List<Respuesta> respuestas;

    //constructores y getters and setters
    public Pregunta() {
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_repsuesta) {
        this.id_respuesta = id_repsuesta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }




}
