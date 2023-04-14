package br.imd.ufrn.segurancaonlinebackend.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String message;

    private LocalDate timestamp;

}
