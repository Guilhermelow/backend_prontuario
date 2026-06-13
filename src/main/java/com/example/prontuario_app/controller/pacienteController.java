package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.paciente;
import com.example.prontuario_app.service.pacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {

    private final pacienteService service;

    public pacienteController(pacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<paciente> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<paciente> listarPorUsuario(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public paciente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public paciente salvar(@RequestBody paciente paciente) {
        return service.salvar(paciente);
    }

    @PutMapping("/{id}")
    public paciente atualizar(
            @PathVariable Long id,
            @RequestBody paciente paciente) {

        return service.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}