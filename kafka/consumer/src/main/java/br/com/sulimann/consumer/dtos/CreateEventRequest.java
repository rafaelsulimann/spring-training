package br.com.sulimann.consumer.dtos;

import java.time.LocalDate;

public record CreateEventRequest(String name, LocalDate date) {

}
