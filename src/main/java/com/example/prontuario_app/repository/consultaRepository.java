package com.example.prontuario_app.repository;

import java.util.List;
import com.example.prontuario_app.model.consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultaRepository extends JpaRepository<consulta, Long> {

    List<consulta> findByPacienteId(Long pacienteId);

    void deleteByPacienteId(Long pacienteId);
    
}