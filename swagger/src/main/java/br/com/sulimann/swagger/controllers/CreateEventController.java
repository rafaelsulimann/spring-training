package br.com.sulimann.swagger.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sulimann.swagger.dtos.CreateEventRequest;
import br.com.sulimann.swagger.dtos.CreateEventResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event API", description = "API para gerenciamento de eventos")
public class CreateEventController {

  @Operation(summary = "Cria um novo evento", description = "Cria um novo evento com o nome e descrição fornecidos")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Evento criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateEventResponse.class))),
    @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(mediaType = "application/json"))
  })
  @PostMapping
  public ResponseEntity<CreateEventResponse> createEvent(@RequestBody @Valid CreateEventRequest request) {
    var eventId = UUID.randomUUID().toString();
    var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(eventId).toUri();
    return ResponseEntity.created(location).body(new CreateEventResponse(eventId));
  }
}
