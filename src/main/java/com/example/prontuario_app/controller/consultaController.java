package com.example.prontuario_app.controller;

import com.example.prontuario_app.model.consulta;
import com.example.prontuario_app.service.consultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class consultaController {

    private final consultaService service;

    public consultaController(consultaService service) {
        this.service = service;
    }

    @GetMapping
    public List<consulta> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/paciente/{id}")
    public List<consulta> buscarPorPaciente(
            @PathVariable Long id) {

        return service.buscarPorPaciente(id);
    }

    @GetMapping("/{id}")
    public consulta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public consulta salvar(@RequestBody consulta consulta) {
        return service.salvar(consulta);
    }

    @PutMapping("/{id}")
    public consulta atualizar(
            @PathVariable Long id,
            @RequestBody consulta consulta) {

        return service.atualizar(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}