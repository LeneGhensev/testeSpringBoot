package br.com.livelo.teste.controller;

import br.com.livelo.teste.model.Usuario;
import br.com.livelo.teste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeuController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostraHome(){
        return "home";
    }

    @GetMapping("/consulta")
    public String mostraUsuarios(Model model){
        Iterable<Usuario> usuarios = usuarioService.consulta();
        for(Usuario u : usuarios){
            System.out.println(u.getNome());
        }
        model.addAttribute("usuarios", usuarios);

        return "consulta";
    }
}