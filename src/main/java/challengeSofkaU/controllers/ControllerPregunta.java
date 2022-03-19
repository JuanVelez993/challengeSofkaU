package challengeSofkaU.controllers;

import challengeSofkaU.models.Pregunta;
import challengeSofkaU.services.ServicePregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challengeSofka")
public class ControllerPregunta {

    @Autowired
    private ServicePregunta sp;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> mostrarPreguntas() {
        return new ResponseEntity<>(sp.mostrarPreguntas(), HttpStatus.OK);


    }
}
