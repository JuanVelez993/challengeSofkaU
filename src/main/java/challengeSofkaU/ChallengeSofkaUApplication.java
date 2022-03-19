package challengeSofkaU;

import challengeSofkaU.DAO.*;
import challengeSofkaU.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ChallengeSofkaUApplication {
	private static CategoriaDAO<Categoria> daoCategoria;
	private static UsuarioDAO<Usuario> daoUsuario;
	private static HistorialDAO<Historial> daoHistorial;
	private static PreguntaDAO<Pregunta> daoPregunta;
	private static RespuestaDAO<Respuesta> daoRespuesta;

	public ChallengeSofkaUApplication(CategoriaDAO daoCategoria,UsuarioDAO daoUsuario,HistorialDAO daoHistorial,PreguntaDAO daoPregunta,RespuestaDAO daoRespuesta) {
		this.daoCategoria=daoCategoria;
		this.daoUsuario=daoUsuario;
		this.daoHistorial=daoHistorial;
		this.daoPregunta=daoPregunta;
		this.daoRespuesta=daoRespuesta;
	}


	public static void main(String[] args) {
		SpringApplication.run(ChallengeSofkaUApplication.class, args);

		List<Categoria> categorias=daoCategoria.mostrarCategorias();
		categorias.forEach(System.out::println);
	}

}
