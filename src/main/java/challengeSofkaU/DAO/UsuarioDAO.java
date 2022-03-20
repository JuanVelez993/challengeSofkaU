package challengeSofkaU.DAO;

import challengeSofkaU.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO<Usuario> {

    boolean insertarUsuario(Usuario jugadorActual);
    List<Usuario> mostrarUsuarios();
    Optional<Usuario> buscarUsuario(String doc);


}
