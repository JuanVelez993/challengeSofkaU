package challengeSofkaU.models;

public class Categoria {

    String categoria;
    int dificultad;

    public Categoria(int dificultad,String categoria) {
        this.dificultad=dificultad;
        this.categoria=categoria;

    }

    public Categoria() {
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public int getDificultad(int dificultad) {
        return this.dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }


}
