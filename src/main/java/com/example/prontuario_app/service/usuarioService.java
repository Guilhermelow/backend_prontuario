package com.example.prontuario_app.service;

import com.example.prontuario_app.model.usuario;
import com.example.prontuario_app.repository.usuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioService {

    private final usuarioRepository repository;

    public usuarioService(usuarioRepository repository) {
        this.repository = repository;
    }

    public List<usuario> listarTodos() {
        return repository.findAll();
    }

    public usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public usuario login(String email, String senha) {
        return repository.findByEmailAndSenhaAndAtivoTrue(email, senha)
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
    }

    public usuario salvar(usuario usuario) {
        return repository.save(usuario);
    }

    public usuario atualizar(Long id, usuario usuarioAtualizado) {
        usuario usuario = buscarPorId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setPerfil(usuarioAtualizado.getPerfil());
        usuario.setAtivo(usuarioAtualizado.getAtivo());

        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}