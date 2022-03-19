package challengeSofkaU.controllers;

import challengeSofkaU.models.Historial;
import challengeSofkaU.services.ServiceHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challengeSofka")
public class ControllerHistorial {
    @Autowired
    private ServiceHistorial sh;


    @PostMapping("/historial")
    public ResponseEntity insertar(@RequestBody Historial hist) {
        if (sh.insertarHistorial(hist)){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/historiales")
    public ResponseEntity<List<Historial>> mostrarHistorial() {
        return new ResponseEntity<>(sh.mostrarHistorial(), HttpStatus.OK);


    }
}
