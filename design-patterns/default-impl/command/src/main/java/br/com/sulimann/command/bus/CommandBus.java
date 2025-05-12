package br.com.sulimann.command.bus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.sulimann.command.domain.Command;
import br.com.sulimann.command.handler.CommandHandler;

@Component
public class CommandBus {
  private final Map<Class<?>, CommandHandler<?>> handlers;

  public CommandBus(List<CommandHandler<?>> handlers) {
    this.handlers = handlers.stream()
        .collect(Collectors.toMap(
            handler -> {
                // Pega o tipo genérico do CommandHandler
                Type[] genericInterfaces = handler.getClass().getGenericInterfaces();
                ParameterizedType commandHandlerType = (ParameterizedType) genericInterfaces[0];
                Type commandType = commandHandlerType.getActualTypeArguments()[0];
                return (Class<?>) commandType;
            },
            Function.identity()
        ));
  }

  @SuppressWarnings("unchecked")
  public <C extends Command> void send(C command) {
    var handler = (CommandHandler<C>) handlers.get(command.getClass());
    if (handler == null) {
      throw new RuntimeException("Handler not found for command: " + command.getClass());
    }
    handler.handle(command);
  }
}
