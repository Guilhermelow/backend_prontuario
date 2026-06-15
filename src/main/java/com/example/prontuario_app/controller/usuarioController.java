package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.usuario;
import com.example.prontuario_app.service.usuarioService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {

    private final usuarioService service;

    public usuarioController(usuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os usuários")
    @GetMapping
    public List<usuario> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar usuário por ID")
    @GetMapping("/{id}")
    public usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar novo usuário")
    @PostMapping
    public usuario salvar(@RequestBody usuario usuario) {
        return service.salvar(usuario);
    }

    @Operation(summary = "Realizar login do usuário")
    @PostMapping("/login")
    public usuario login(@RequestBody usuario usuario) {
        return service.login(usuario.getEmail(), usuario.getSenha());
    }

    @Operation(summary = "Atualizar usuário")
    @PutMapping("/{id}")
    public usuario atualizar(
            @PathVariable Long id,
            @RequestBody usuario usuario) {

        return service.atualizar(id, usuario);
    }

    @Operation(summary = "Excluir usuário")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}