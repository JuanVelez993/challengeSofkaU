package challengeSofkaU.services;

import challengeSofkaU.DAO.CategoriaDAO;
import challengeSofkaU.DAO.UsuarioDAO;
import challengeSofkaU.models.Categoria;
import challengeSofkaU.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {
    @Autowired
    private UsuarioDAO daoU;

    public boolean insertarUsuario(Usuario usur) {
        return daoU.insertarUsuario(usur);
    }

    public List<Usuario> mostrarUsuarios() {
        List<Usuario> listaU = daoU.mostrarUsuarios();
        return listaU;
    }
}
