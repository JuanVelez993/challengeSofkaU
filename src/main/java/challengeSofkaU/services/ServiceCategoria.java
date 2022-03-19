package challengeSofkaU.services;

import challengeSofkaU.DAO.CategoriaDAO;
import challengeSofkaU.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoria {
    @Autowired
    private CategoriaDAO daoC;

    public List<Categoria> mostrarCategorias() {
        List<Categoria> listaC = daoC.mostrarCategorias();
        return listaC;
    }

}
