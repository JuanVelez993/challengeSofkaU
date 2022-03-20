package challengeSofkaU.DAO;

import challengeSofkaU.models.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RespuestaDAOImpl implements RespuestaDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoriaDAOImpl.class);
    private JdbcTemplate jdt;

    public RespuestaDAOImpl(JdbcTemplate jdt) {
        this.jdt = jdt;
    }

    RowMapper<Respuesta> rm=(rs, rowNum) -> {
        Respuesta resp = new Respuesta();
        resp.setId_respuesta(rs.getInt("id_respuesta"));
        resp.setRespuesta(rs.getString("respuesta"));
        resp.setValor(rs.getBoolean("valor"));
        resp.setId_pregunta(rs.getInt("id_pregunta"));
        return resp;
    };


    final String readResps= "Select id_respuesta,respuesta,valor,id_pregunta from respuesta";
    final String filtResps= "select *from respuesta where id_pregunta=";

    @Override
    public List<Respuesta> mostrarRespuesta() {
        return jdt.query(readResps,rm);
    }

    @Override
    public List filtrarRespuesta(int preg) {
        return jdt.query(filtResps+preg,rm);
    }
}
