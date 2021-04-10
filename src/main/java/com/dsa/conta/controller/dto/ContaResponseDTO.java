package com.dsa.conta.controller.dto;

import lombok.*;

import java.time.LocalDate;

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
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
}
