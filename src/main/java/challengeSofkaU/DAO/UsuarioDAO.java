package challengeSofkaU.DAO;

import challengeSofkaU.models.Usuario;

import java.util.List;

public interface UsuarioDAO<Usuario> {

    boolean insertarUsuario(Usuario jugadorActual);
    List<Usuario> mostrarUsuarios();
}
