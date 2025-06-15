package br.com.sulimann.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.redis.services.CacheService;

@RestController
@RequestMapping(value = "/cache")
public class CacheController {

  @Autowired
  private CacheService cacheService;

  @DeleteMapping(value = "/clear")
  public void clearCache(@RequestParam String cacheName) {
    cacheService.clearCache(cacheName);
  }

  @PutMapping(value = "/update")
  public void updateCachePage(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    cacheService.updateCache(pageable);
  }
}
