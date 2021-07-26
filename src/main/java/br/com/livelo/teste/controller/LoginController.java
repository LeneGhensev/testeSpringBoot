package br.com.livelo.teste.controller;

import br.com.livelo.teste.model.LoginForm;
import br.com.livelo.teste.model.Usuario;
import br.com.livelo.teste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(Model model) {
        LoginForm loginModel = new LoginForm();
        model.addAttribute("loginform", loginModel);
        return "login";
    }

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/efetuaLogin")
    public String efetuaLogin(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session, Model model, HttpServletRequest request) {
        LoginForm loginModel = new LoginForm();
        model.addAttribute("loginform", loginModel);
        Usuario user = usuarioService.findUserByNameAndPassword(loginForm.getUsername(), loginForm.getPassword());
        if (user != null) {
            session.setAttribute("usuarioLogado", user);
            user.setAuthenticated(true);
            return "redirect:/consulta";
        }
        return "redirect:login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        try {
            Usuario user = (Usuario) session.getAttribute("usuarioLogado");
            user.setAuthenticated(false);
            session.invalidate();
            return "redirect:login";
        } catch (Exception e) {
            return "error";
//       throw new RuntimeException("Nao foi possivel pegar o usuario da sessao.", e);
        }
    }

}
