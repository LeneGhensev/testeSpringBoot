package br.com.livelo.teste.repository;

import br.com.livelo.teste.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String>  {

}
