package com.example.prontuario_app.repository;

import com.example.prontuario_app.model.paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface pacienteRepository extends JpaRepository<paciente, Long> {
    List<paciente> findByUsuarioId(Long usuarioId);
}