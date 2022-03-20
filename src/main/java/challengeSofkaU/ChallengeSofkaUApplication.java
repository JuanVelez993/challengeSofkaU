package challengeSofkaU;

import challengeSofkaU.DAO.*;
import challengeSofkaU.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
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
		Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
		int opcion;
		boolean menu=true;
		boolean respuesta;

		do{
			Concurso.printMenu(opcionesMenuInicial);
			try{
				opcion=scanner.nextInt();
				switch(opcion) {
					case 1: // Concurso de Preguntas
						//Preparacion de usuario para la partida
						Concurso challenge=new Concurso();
						Usuario participante = new Usuario();
						System.out.println("Ingrese su Documento de identidad");
						participante.setDocumento(scanner.next());
						optionalParticipanteExistente = daoUsuario.buscarUsuario(participante.getDocumento());
						challenge.setParticipante(optionalParticipanteExistente.orElse(participante));
						challenge.validarUsuario(scanner,daoUsuario);
						//Preparacion de las rondas
						boolean jugardorGanador = true;
						for(int i = 1 ; i < 6; i++){
							challenge.setRonda(i);
							challenge.setPreguntas(daoPregunta.filtrarDificultad(i));
							challenge.selecPregRandom();
							List<Respuesta> resps = daoRespuesta.filtrarRespuesta(challenge.getPreguntaActual().getId_pregunta());
							challenge.imprimirPregunta(resps);
							//validacion de respuesta y continuacion o no de la partida
							boolean valorResp = false;
							int j=4;
							while (!valorResp) {
								try {
									j= scanner.nextInt();
									valorResp = true;
								} catch (InputMismatchException e) {
									System.out.println("Ingrese un valor numerico correspondientes a las respuestas");
									valorResp = false;
									scanner.nextLine();
								}
							}
							respuesta=challenge.validarRespuesta(resps,resps.get(j-1));
							if(respuesta){
								challenge.setPuntosConcurso(challenge.getPuntosConcurso()+(i*10000));
								System.out.println("Desea avanzar a la siguiente ronda? :");
								String seguirPartida="value";
								while (!seguirPartida.equals ("si") && !seguirPartida.equals ("no")){
									System.out.println("La respuesta debe ser si o no");
									seguirPartida= scanner.next();
								}
								if(seguirPartida.equals("no")){
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
						//Si se terminaron las rondas de manera exitosa
						if(jugardorGanador){
							guardarHistorial(challenge);
							System.out.println("Felicidades has superado las 5 rondas ");
						}
						break;
					case 2: // Historial de Puntuaciones
						List<Historial> hists=daoHistorial.mostrarHistorial();
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
				boolean valorResp = false;
				int k=4;
				while (!valorResp) {
					try {
						k= scanner.nextInt();
						valorResp = true;
					} catch (InputMismatchException e) {
						System.out.println("Ingrese un valor numerico entre 1 y 3");
						valorResp = false;
						scanner.nextLine();
					}
				}

			}
		}while(menu);
	}

	 private static void guardarHistorial(Concurso challenge){
		Historial historial = new Historial(
				challenge.getParticipante().getDocumento(),
				challenge.getRonda(),
				challenge.getPuntosConcurso());
		daoHistorial.insertarHistorial(historial);

	}
}

