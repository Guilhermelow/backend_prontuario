package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.usuario;
import com.example.prontuario_app.service.usuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {

    private final usuarioService service;

    public usuarioController(usuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<usuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public usuario salvar(@RequestBody usuario usuario) {
        return service.salvar(usuario);
    }

    @PostMapping("/login")
    public usuario login(@RequestBody usuario usuario) {
        return service.login(usuario.getEmail(), usuario.getSenha());
    }

    @PutMapping("/{id}")
    public usuario atualizar(
            @PathVariable Long id,
            @RequestBody usuario usuario) {

        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}