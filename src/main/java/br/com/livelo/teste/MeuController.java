package br.com.livelo.teste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeuController {
    @GetMapping("/")
    public String mostraHome(){
        return "home";
    }
}
