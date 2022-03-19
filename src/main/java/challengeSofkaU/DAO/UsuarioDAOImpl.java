package challengeSofkaU.DAO;


import challengeSofkaU.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDAOImpl implements UsuarioDAO<Usuario> {
    private static final Logger log = LoggerFactory.getLogger(CategoriaDAOImpl.class);
    private JdbcTemplate jdt;

    public UsuarioDAOImpl(JdbcTemplate jdt) {
        this.jdt=jdt;
    }

    RowMapper<Usuario> rm=(rs, rowNum) -> {
        Usuario usur = new Usuario();
        usur.setDocumento(rs.getString("documento"));
        usur.setNombre(rs.getString("nombre"));
        return usur;
    };

    final String readUsuario = "Select documento,nombre from usuario";
    final String instUsuario = "INSERT INTO usuario (documento,nombre) VALUES (?,?)";

    @Override
    public boolean insertarUsuario(Usuario jugadorActual) {
        int insert = jdt.update(instUsuario, jugadorActual.getDocumento(),jugadorActual.getNombre());
        if (insert == 1) {
            log.info("Nuevo Usuario Registrado: " + jugadorActual.getNombre());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return jdt.query(readUsuario,rm);
    }
}
