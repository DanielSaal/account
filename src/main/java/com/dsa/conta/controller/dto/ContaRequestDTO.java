package com.dsa.conta.controller.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaRequestDTO {

    @Pattern(regexp = "^[0-9]*", message = "Somente dígitos são aceitos para o número da conta.")
    @NotNull(message = "Número da conta é obrigatório.")
    @Size(max = 6, message = "Máximo de 6 dígitos para o número da conta.")
    private String numero;

    @Pattern(regexp = "^[0-9]*", message = "Somente dígitos são aceitos para a agência da conta.")
    @NotNull(message = "Agência da conta é obrigatório.")
    @Size(max = 4, message = "Máximo de 4 dígitos para a agência da conta.")
    private String agencia;

    @Pattern(regexp = "^[0-9]*", message = "Somente dígitos são aceitos para o CPF da conta.")
    @NotNull(message = "CPF da conta é obrigatório.")
    @Size(min = 11,max = 11, message = "Obrigatório 11 dígitos para o CPF da conta.")
    private String cpf;
}
