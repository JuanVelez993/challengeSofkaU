package challengeSofkaU;

import challengeSofkaU.DAO.*;
import challengeSofkaU.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ChallengeSofkaUApplication {

	private static UsuarioDAO<Usuario> daoUsuario;
	private static HistorialDAO<Historial> daoHistorial;
	private static PreguntaDAO<Pregunta> daoPregunta;
	private static RespuestaDAO<Respuesta> daoRespuesta;

	public ChallengeSofkaUApplication(UsuarioDAO daoUsuario,HistorialDAO daoHistorial,PreguntaDAO daoPregunta,RespuestaDAO daoRespuesta) {
		this.daoUsuario=daoUsuario;
		this.daoHistorial=daoHistorial;
		this.daoPregunta=daoPregunta;
		this.daoRespuesta=daoRespuesta;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSofkaUApplication.class, args);

		String[] opcionesMenuInicial =new String[]{"-------Bienvenido al Concurso de Preguntas---------",
		"1.Participar","2.Ver Historial","3.Salir"};

		Optional<Usuario> optionalParticipanteExistente;
		List<Historial> hists=daoHistorial.mostrarHistorial();
		Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
		int opcion;
		boolean menu=true;
		boolean respuesta;
		Usuario participante = new Usuario();

		do{
			Concurso.printMenu(opcionesMenuInicial);
			try{
				opcion=scanner.nextInt();
				switch(opcion) {
					case 1: // Concurso de Preguntas
						Concurso challenge=new Concurso();
						System.out.println("Ingrese su Documento de identidad");
						participante.setDocumento(scanner.next());
						optionalParticipanteExistente = daoUsuario.buscarUsuario(participante.getDocumento());
						challenge.setParticipante(optionalParticipanteExistente.orElse(participante));
						challenge.validarUsuario(scanner,daoUsuario);
						boolean jugardorGanador = true;
						for(int i = 1 ; i < 6; i++){
							challenge.setRonda(i);
							challenge.setPreguntas(daoPregunta.filtrarDificultad(i));
							challenge.selecPregRandom();
							List<Respuesta> resps = daoRespuesta.filtrarRespuesta(challenge.getPreguntaActual().getId_pregunta());
							challenge.imprimirPregunta(resps);

							// TODO hacer validaciones para respuestas incorrectas
							// while con try catch interno hasta que las respuesta este correcta

							respuesta=challenge.validarRespuesta(resps,resps.get(scanner.nextInt()-1));
							if(respuesta){
								challenge.setPuntosConcurso(challenge.getPuntosConcurso()+(i*10000));
								System.out.println("Desea avanzar a la siguiente ronda?");
								// TODO especificar en el mensaje tipo de respuesta 1.SI 2.NO  y validarlo
								if(scanner.next().equals("no")){
									guardarHistorial(challenge);
									jugardorGanador = false;
									System.out.println("Su premio es de: " + challenge.getPuntosConcurso());
									break;
								}
							}else{
								challenge.setPuntosConcurso(0);
								guardarHistorial(challenge);
								System.out.println("La respuesta es incorrecta, intentalo de nuevo en otra partida");
								jugardorGanador = false;
								break;
							}
						}

						if(jugardorGanador){
							guardarHistorial(challenge);
							System.out.println("Felicidades has superado las 5 rondas ");
						}
						break;
					case 2: // Historial de Puntuaciones
						Concurso.imprimirHistorial(hists);
						break;
					case 3:// salir
						System.out.println("Hasta la Proxima");
						menu=false;
						return;
					default:
						System.out.println("Por favor seleccione una opcion entre 1 y " + opcionesMenuInicial.length);
				}

			}
			catch (Exception ex){
				System.out.println("Por favor seleccione una opcion entre 1 y  " + opcionesMenuInicial.length);
				// TODO validaciones
				scanner.nextInt();
			}
		}while(menu);
	}

	static private void guardarHistorial(Concurso challenge){
		Historial historial = new Historial(
				challenge.getParticipante().getDocumento(),
				challenge.getRonda(),
				challenge.getPuntosConcurso());
		daoHistorial.insertarHistorial(historial);

	}
}

