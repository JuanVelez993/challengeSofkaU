package challengeSofkaU.controllers;


import challengeSofkaU.models.Respuesta;
import challengeSofkaU.services.ServiceRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challengeSofka")
public class ControllerRespuesta {
    @Autowired
    private ServiceRespuesta sr;

    @GetMapping("/respuestas")
    public ResponseEntity<List<Respuesta>> mostrarRespuestas() {
        return new ResponseEntity<>(sr.mostrarRespuestas(), HttpStatus.OK);


    }
}
