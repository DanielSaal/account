package com.dsa.conta.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "conta")
public class Conta {

    @Id
    private String id;
    private String numero;
    private String agencia;
    private String cpf;
    private Boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;


}
