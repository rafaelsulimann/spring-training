package br.com.sulimann.command.handler;

import br.com.sulimann.command.domain.Command;

public interface CommandHandler<T extends Command> {
  void handle(T command);
}
