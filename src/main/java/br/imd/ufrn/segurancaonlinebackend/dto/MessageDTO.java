package br.imd.ufrn.segurancaonlinebackend.dto;

import java.time.LocalDate;


public class MessageDTO {
    private String message;

    private LocalDate timestamp;

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
