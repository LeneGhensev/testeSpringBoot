package br.com.livelo.teste.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
            throws Exception {
        //return true;
        // se for a pagina de login ou resources, deixa passar
        String uri = request.getRequestURI();
        if (uri.endsWith("login") || uri.endsWith("efetuaLogin") || uri.contains("resources") || uri.endsWith("consulta"))  {
            return true;
        }
        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
