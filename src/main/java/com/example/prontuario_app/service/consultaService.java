package com.example.prontuario_app.service;

import com.example.prontuario_app.model.consulta;
import com.example.prontuario_app.model.paciente;
import com.example.prontuario_app.model.usuario;
import com.example.prontuario_app.repository.consultaRepository;
import com.example.prontuario_app.repository.pacienteRepository;
import com.example.prontuario_app.repository.usuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class consultaService {

    private final consultaRepository consultaRepository;
    private final pacienteRepository pacienteRepository;
    private final usuarioRepository usuarioRepository;

    public consultaService(
            consultaRepository consultaRepository,
            pacienteRepository pacienteRepository,
            usuarioRepository usuarioRepository) {

        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public List<consulta> buscarPorPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public consulta salvar(consulta consulta) {

        Long pacienteId = consulta.getPaciente().getId();
        Long usuarioId = consulta.getUsuario().getId();

        paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setUsuario(usuario);

        return consultaRepository.save(consulta);
    }

    public consulta atualizar(Long id, consulta consultaAtualizada) {

        consulta consulta = buscarPorId(id);

        consulta.setDataConsulta(consultaAtualizada.getDataConsulta());
        consulta.setQueixaPrincipal(consultaAtualizada.getQueixaPrincipal());
        consulta.setHistoricoDoenca(consultaAtualizada.getHistoricoDoenca());
        consulta.setDiagnostico(consultaAtualizada.getDiagnostico());
        consulta.setConduta(consultaAtualizada.getConduta());
        consulta.setObservacoes(consultaAtualizada.getObservacoes());

        return consultaRepository.save(consulta);
    }

    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }
}