package challengeSofkaU.DAO;

import challengeSofkaU.models.Categoria;
import challengeSofkaU.models.Pregunta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PreguntaDAOImpl implements PreguntaDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoriaDAOImpl.class);
    private final JdbcTemplate jdt;

    public PreguntaDAOImpl(JdbcTemplate jdt) {
        this.jdt = jdt;
    }


    RowMapper<Pregunta> rm=(rs, rowNum) -> {
        Pregunta preg = new Pregunta();
        preg.setId_pregunta(rs.getInt("id_pregunta"));
        preg.setTextoPregunta(rs.getString("texto_pregunta"));
        preg.setDificultad(rs.getInt("dificultad"));
        preg.setId_respuesta(rs.getInt("id_respuesta"));
        return preg;
    };

    final String readPregs= "Select id_pregunta,texto_pregunta,dificultad,id_respuesta from pregunta";
    final String filtPregs= "Select id_pregunta,texto_pregunta,dificultad,id_respuesta from pregunta where dificultad=";




    @Override
    public List<Pregunta> mostrarPregunta() {
        return jdt.query(readPregs,rm);
    }

    @Override
    public List<Pregunta> filtrarDificultad(int dif) {
        return jdt.query(filtPregs+dif,rm);
    }


}
