package challengeSofkaU.DAO;


import challengeSofkaU.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    final String filtUsu= "select * from usuario where documento = ? ";

    @Override
    public boolean insertarUsuario(Usuario jugadorActual) {
        int insert = jdt.update(instUsuario, jugadorActual.getDocumento(),jugadorActual.getNombre());
        if (insert == 1) {
            //log.info("Nuevo Usuario Registrado: " + jugadorActual.getNombre());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return jdt.query(readUsuario,rm);
    }

    @Override
    public Optional<Usuario> buscarUsuario(String doc) {
        Usuario usuario = null;
        try{
            usuario = jdt.queryForObject(filtUsu, new Object[]{doc}, rm);
        }catch (Exception e){
            System.out.println("Usuario no existe");
        }
        return Optional.ofNullable(usuario);
    }
}
