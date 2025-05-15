package br.com.sulimann.clean_arch.infrastructure.usuario.persistence;

import br.com.sulimann.clean_arch.domain.usuario.Usuario;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated)
public class UsuarioJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String nome;

  private String email;

  @Embedded
  private TelefoneEntity telefone;

  @Embedded
  private EnderecoEntity endereco;

  public static UsuarioJpaEntity fromDomain(Usuario usuario) {
    return new UsuarioJpaEntity(
        usuario.getId(),
        usuario.getNome(),
        usuario.getEmail(),
        new TelefoneEntity(usuario.getTelefone().getNumero(), usuario.getTelefone().getDdd()),
        new EnderecoEntity(usuario.getEndereco().getRua(), usuario.getEndereco().getNumero(),
            usuario.getEndereco().getBairro(), usuario.getEndereco().getCidade(), usuario.getEndereco().getEstado(),
            usuario.getEndereco().getCep()));
  }

  public static Usuario toDomain(UsuarioJpaEntity usuarioJpaEntity) {
    return Usuario.newUsuario(usuarioJpaEntity.getId(), usuarioJpaEntity.getNome(), usuarioJpaEntity.getEmail(),
        usuarioJpaEntity.getTelefone().getCelular(), usuarioJpaEntity.getTelefone().getDdd(),
        usuarioJpaEntity.getEndereco().getRua(), usuarioJpaEntity.getEndereco().getNumero(),
        usuarioJpaEntity.getEndereco().getBairro(), usuarioJpaEntity.getEndereco().getCidade(),
        usuarioJpaEntity.getEndereco().getEstado(), usuarioJpaEntity.getEndereco().getCep());
  }
}
