package com.example.prontuario_app.service;

import com.example.prontuario_app.model.paciente;
import com.example.prontuario_app.repository.pacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pacienteService {

    private final pacienteRepository repository;

    public pacienteService(pacienteRepository repository) {
        this.repository = repository;
    }

    public List<paciente> listarTodos() {
        return repository.findAll();
    }

    public List<paciente> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public paciente salvar(paciente paciente) {
        return repository.save(paciente);
    }

    public paciente atualizar(Long id, paciente pacienteAtualizado) {

        paciente paciente = buscarPorId(id);

        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        paciente.setSexo(pacienteAtualizado.getSexo());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setEndereco(pacienteAtualizado.getEndereco());
        paciente.setObservacoes(pacienteAtualizado.getObservacoes());
        paciente.setAtivo(pacienteAtualizado.getAtivo());

        return repository.save(paciente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}