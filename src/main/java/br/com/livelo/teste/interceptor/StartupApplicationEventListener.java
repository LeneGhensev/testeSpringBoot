package br.com.livelo.teste.interceptor;

import br.com.livelo.teste.model.Usuario;
import br.com.livelo.teste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationEventListener {
    @Autowired
    private UsuarioService usuarioService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        Usuario usuario = new Usuario();
        usuario.setNome("Felipe");
        usuario.setSenha("5896");
       // usuarioService.save(usuario);
    }
}
