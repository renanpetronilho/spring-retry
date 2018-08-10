package br.com.conductor.retryexemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<Void> recuperarUsuario(){
        usuarioService.recuperarUsuarios("tste");
        return new ResponseEntity(HttpStatus.OK);
    }
}
