package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.paciente;
import com.example.prontuario_app.service.pacienteService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {

    private final pacienteService service;

    public pacienteController(pacienteService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os pacientes")
    @GetMapping
    public List<paciente> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Listar pacientes por usuário")
    @GetMapping("/usuario/{usuarioId}")
    public List<paciente> listarPorUsuario(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }

    @Operation(summary = "Buscar paciente por ID")
    @GetMapping("/{id}")
    public paciente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar novo paciente")
    @PostMapping
    public paciente salvar(@RequestBody paciente paciente) {
        return service.salvar(paciente);
    }

    @Operation(summary = "Atualizar paciente")
    @PutMapping("/{id}")
    public paciente atualizar(
            @PathVariable Long id,
            @RequestBody paciente paciente) {

        return service.atualizar(id, paciente);
    }

    @Operation(summary = "Excluir paciente")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}