package challengeSofkaU.controllers;

import challengeSofkaU.models.Categoria;
import challengeSofkaU.models.Usuario;
import challengeSofkaU.services.ServiceCategoria;
import challengeSofkaU.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challengeSofka")
public class ControllerUsuario {

    @Autowired
    private ServiceUsuario su;


    @PostMapping("/registrar")
    public ResponseEntity insertar(@RequestBody Usuario usur) {
        if (su.insertarUsuario(usur)){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> mostrarUsuarios() {
        return new ResponseEntity<>(su.mostrarUsuarios(), HttpStatus.OK);


    }
}
