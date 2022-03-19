package challengeSofkaU.models;

import java.util.ArrayList;

public class Pregunta {
    int id_pregunta;
    int dificultad;
    String textoPregunta;
    int id_respuesta;
    ArrayList<Respuesta> respuestas;

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

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void mostrarPregunta(){
        System.out.println(this.textoPregunta);
        int i=0;
        while (i<respuestas.size()){
            System.out.println("\t "+(i+1)+". "+respuestas.get(i));
            i++;

        }

    }

    public boolean comprobarRespuesta(int respuesta) {
        Respuesta r = respuestas.get(respuesta - 1);

        if (r != null) {
            return r.respuestaCorrecta();
        }
        return false;


    }

}
