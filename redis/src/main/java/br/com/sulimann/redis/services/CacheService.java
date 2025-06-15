package br.com.sulimann.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sulimann.redis.dtos.UsuarioResponse;
import br.com.sulimann.redis.repositories.UsuarioRepository;

@Service
public class CacheService {

  @Autowired
  private CacheManager cacheManager;

  @Autowired
  private UsuarioRepository usuarioRepository;

  public void clearCache(String cacheName) {
    cacheManager.getCache(cacheName).clear();
  }

  @CachePut(value = "usuarios", key = "#pageable.pageNumber")
  public Page<UsuarioResponse> updateCache(Pageable pageable){
    var usuarios = usuarioRepository.findAll(pageable);
    return usuarios.map(UsuarioResponse::new);
  }

}
