package br.com.devpradev.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devpradev.models.entity.UsuarioModel;
import br.com.devpradev.repository.UsuarioRepository;
import br.com.devpradev.utils.Endpoints;

@RestController
@RequestMapping(Endpoints.REQUEST_USUARIO)
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> findAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping(Endpoints.REQUEST_USUARIO_CREATE)
    public ResponseEntity<UsuarioModel> saveUser(@RequestBody UsuarioModel usuarioModel)  {
        return ResponseEntity.ok(usuarioRepository.save(usuarioModel));
    }

}
