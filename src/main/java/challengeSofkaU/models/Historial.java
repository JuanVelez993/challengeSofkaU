package challengeSofkaU.models;

public class Historial {
     int id_historial;
     String documento;
     int ronda ;
     int premio;

     public Historial() {
     }

     public int getId_historial() {
          return id_historial;
     }

     public void setId_historial(int id_historial) {
          this.id_historial = id_historial;
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
