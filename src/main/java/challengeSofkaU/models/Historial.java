package challengeSofkaU.models;

public class Historial {
    //Este atributo guarda el documento del jugador a registrar en el historial
    String documento;
    //Este atributo guarda la ronda a la que llego
    int ronda;
    //Este atributo guarda el premio que obtuvo
    int premio;


    //constructor y getters and setters
    public Historial() {
    }

    public Historial(String documento, int ronda, int premio) {
        this.documento = documento;
        this.ronda = ronda;
        this.premio = premio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

}

