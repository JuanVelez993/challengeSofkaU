package challengeSofkaU.models;

public class Respuesta {
    //EL identificador de la respuesta
    int id_respuesta;
    //La descripcion de la respuesta
    String respuesta;
    //EL valor de la respuesta,si es positivo la respuesta es correcta
    Boolean valor;
    //La pregunta a la cual esta asociada la respuesta
    int id_pregunta;

    //constructores y getters and setters
    public Respuesta() {
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }


    public boolean respuestaCorrecta(){
        return valor;
    }


}
