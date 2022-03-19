package challengeSofkaU.controllers;

import challengeSofkaU.models.Categoria;
import challengeSofkaU.services.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challengeSofka")
public class ControllerCategoria {

    @Autowired
    private ServiceCategoria sc;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> mostrarCategorias() {
        return new ResponseEntity<>(sc.mostrarCategorias(), HttpStatus.OK);


    }
}
