package com.dsa.conta.controller.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaResponseDTO {

    private String id;
    private String numero;
    private String agencia;
    private String cpf;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
