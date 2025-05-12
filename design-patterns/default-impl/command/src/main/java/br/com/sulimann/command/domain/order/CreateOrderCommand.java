package br.com.sulimann.command.domain.order;

import java.util.UUID;

import br.com.sulimann.command.domain.Command;

public record CreateOrderCommand(UUID id, String productId, int quantity) implements Command
{}
