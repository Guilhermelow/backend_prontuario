package com.example.prontuario_app.repository;

import com.example.prontuario_app.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuarioRepository extends JpaRepository<usuario, Long> {
    Optional<usuario> findByEmailAndSenhaAndAtivoTrue(String email, String senha);
}