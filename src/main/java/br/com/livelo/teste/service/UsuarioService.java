package br.com.livelo.teste.service;

import br.com.livelo.teste.model.Usuario;
import br.com.livelo.teste.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Iterable<Usuario> consulta() {
        return usuarioRepositorio.findAll();
    }

}