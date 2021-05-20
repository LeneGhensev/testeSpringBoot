package br.com.livelo.teste.repository;

import br.com.livelo.teste.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String>  {

}
