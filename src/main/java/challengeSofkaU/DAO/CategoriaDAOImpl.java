package challengeSofkaU.DAO;

import challengeSofkaU.models.Categoria;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Component
public class CategoriaDAOImpl implements CategoriaDAO<Categoria> {

    private static final Logger log =LoggerFactory.getLogger(CategoriaDAOImpl.class);
    private JdbcTemplate jdt;

    public CategoriaDAOImpl(JdbcTemplate jdt) {
        this.jdt = jdt;
    };

    RowMapper<Categoria> rm=(rs, rowNum) -> {
        Categoria catego = new Categoria();
        catego.setCategoria(rs.getString("categoria"));
        catego.setDificultad(rs.getInt("dificultad"));
        return catego;
    };
    final String readCategoria = "Select categoria,dificultad from categoria";

    @Override
    public List<Categoria> mostrarCategorias() {
        return jdt.query(readCategoria,rm);
    }
}
