package br.com.livelo.teste.repository;

import br.com.livelo.teste.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String>  {
    @Query("SELECT u FROM Usuario u WHERE (u.nome = :nome) and (u.senha = :senha)")
    List<Usuario> findUserByNameAndPassword(@Param("nome") String username, @Param("senha") String password);
}
