package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.consulta;
import com.example.prontuario_app.service.consultaService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class consultaController {

    private final consultaService service;

    public consultaController(consultaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas as consultas")
    @GetMapping
    public List<consulta> listarTodas() {
        return service.listarTodas();
    }

    @Operation(summary = "Buscar consultas por paciente")
    @GetMapping("/paciente/{id}")
    public List<consulta> buscarPorPaciente(
            @PathVariable Long id) {

        return service.buscarPorPaciente(id);
    }

    @Operation(summary = "Buscar consulta por ID")
    @GetMapping("/{id}")
    public consulta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar nova consulta")
    @PostMapping
    public consulta salvar(@RequestBody consulta consulta) {
        return service.salvar(consulta);
    }

    @Operation(summary = "Atualizar consulta")
    @PutMapping("/{id}")
    public consulta atualizar(
            @PathVariable Long id,
            @RequestBody consulta consulta) {

        return service.atualizar(id, consulta);
    }

    @Operation(summary = "Excluir consulta")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}