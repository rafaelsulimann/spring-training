package br.com.sulimann.postgres.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.sulimann.postgres.entities.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
  @Spec(path = "nome", spec = LikeIgnoreCase.class),
  @Spec(path = "email", spec = LikeIgnoreCase.class)
})
public interface UsuarioSpec extends Specification<Usuario> {

}
