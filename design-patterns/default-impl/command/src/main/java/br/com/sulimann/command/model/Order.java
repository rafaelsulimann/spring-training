package br.com.sulimann.command.model;

import java.util.UUID;

public record Order(UUID id, String productId, int quantity) {

}
