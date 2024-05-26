package id.ac.ui.cs.advprog.authuserservice.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public record ErrorTemplate(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
}
