package challengeSofkaU.DAO;

import challengeSofkaU.models.Historial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistorialDAOImpl implements HistorialDAO {

    private static final Logger log = LoggerFactory.getLogger(CategoriaDAOImpl.class);
    private JdbcTemplate jdt;

    public HistorialDAOImpl(JdbcTemplate jdt) {
        this.jdt = jdt;
    }

    RowMapper<Historial> rm=(rs, rowNum) -> {
        Historial hist = new Historial();
        hist.setPremio(rs.getInt("premio"));
        hist.setRonda(rs.getInt("ronda"));
        return hist;
    };

    final String readHist = "Select ronda,premio from historial";
    final String instHist = "INSERT INTO historial (id_historial,documento,ronda,premio) VALUES (?,?,?,?)";


    @Override
    public boolean insertarHistorial(Historial historialActual) {
        int insert = jdt.update(instHist, historialActual.getPremio(),historialActual.getRonda());
        if (insert == 1) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List mostrarHistorial() {
        return jdt.query(readHist,rm);
    }
}
