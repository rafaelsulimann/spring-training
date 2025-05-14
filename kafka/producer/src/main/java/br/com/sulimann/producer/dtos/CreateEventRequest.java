package br.com.sulimann.producer.dtos;

import java.time.LocalDate;

public record CreateEventRequest(String name, LocalDate date) {

}
