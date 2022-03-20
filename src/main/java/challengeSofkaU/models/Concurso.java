package challengeSofkaU.models;

import challengeSofkaU.DAO.UsuarioDAO;

import java.util.*;

public class Concurso {
    //Atributos de la clase concurso

    //Sirve para guarda una lista de objetos pregunta que se usaran en la ronda
    List<Pregunta> preguntas;
    //Sirve para la pregunta seleccionada en la ronda actual
    Pregunta preguntaActual;
    //cuenta el puntaje de la partida
    int puntosConcurso;
    //cuenta la ronda de la partida
    int ronda;
    // el usuario que inicio la partida
    Usuario participante;

    //constructor y getters and setters
    public Concurso() {}

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

    public void setPreguntaActual(Pregunta preguntaActual) {
        this.preguntaActual = preguntaActual;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getPuntosConcurso() {
        return puntosConcurso;
    }

    public Usuario getParticipante() {
        return participante;
    }

    public void setParticipante(Usuario participante) {
        this.participante = participante;
    }

    public void setPuntosConcurso(int puntosConcurso) {
        this.puntosConcurso = puntosConcurso;
    }

    //Este metodo muestra las opciones del menu por consola
    public static void printMenu(String[] opciones) {
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
    }
    //Este metodo imprime los valores de la lista historial de partidas anteriores
    public static void imprimirHistorial(List<Historial> players) {
        System.out.println("A Continuacion ser muestran los jugadores por orden de participacion:");
        for (Historial player : players) {
            System.out.println("El jugador de documento: " + player.getDocumento() + " alcanzo la ronda " + player.getRonda()
                    + " Y consiguio un premio de " + player.getPremio());
        }

    }
    //Este metodo selecciona una pregunta de manera aletoria de la lista de preguntas de la ronda actual
    public void selecPregRandom() {
        this.preguntaActual = this.preguntas.get(new Random().nextInt(this.preguntas.size()));
    }

    //Este metodo imprime la pregunta y sus respectivas respuestas de la ronda actual
    public void imprimirPregunta(List<Respuesta> respuestas) {
        this.preguntaActual.setRespuestas(respuestas);
        int i = 1;
        System.out.println(this.preguntaActual.getTextoPregunta());
        for (Respuesta r : this.preguntaActual.getRespuestas()) {
            System.out.println(i + ". " + r.getRespuesta());
            i++;
        }
    }

    //Este metodo comprueba que la respuesta seleccionada sea la correcta
    public boolean validarRespuesta(List<Respuesta> rests, Respuesta respuesta) {
        for (Respuesta r : rests) {
            if (r.id_respuesta == respuesta.id_respuesta) {
                if (r.getValor()) {
                    System.out.println("La respuesta: " + r.getRespuesta() + "es correcta");
                    return true;
                }
            }
        }
        return false;
    }

    //Este metodo valida si el participante es un usuario nuevo o antiguo, y si es nuevo lo registra
    public void validarUsuario(Scanner scanner, UsuarioDAO<Usuario> daou) {
        if(this.participante.getNombre() == null || "".equals(this.participante.getNombre())) {
            System.out.println("Ingrese el nombre del jugador");
            this.participante.setNombre(scanner.next());
            daou.insertarUsuario(this.participante);
        } else {
            System.out.println("Bienvenido de Nuevo " + this.participante.getNombre() + "!");
        }
    }
}
