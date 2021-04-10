package com.dsa.conta.converter;

import com.dsa.conta.controller.dto.ContaRequestDTO;
import com.dsa.conta.controller.dto.ContaResponseDTO;
import com.dsa.conta.document.Conta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContaConverter {

    public List<ContaResponseDTO> toResponseDTOList(List<Conta> contas) {

        return contas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ContaResponseDTO toResponseDTO(Conta conta) {

        return ContaResponseDTO.builder()
                .id(conta.getId())
                .numero(conta.getNumero())
                .agencia(conta.getAgencia())
                .cpf(conta.getCpf())
                .dataCriacao(conta.getDataCriacao())
                .dataAtualizacao(conta.getDataAtualizacao())
                .build();
    }

    public Conta toDocument(ContaRequestDTO contaRequestDTO) {

        return Conta.builder()
                .id(contaRequestDTO.getId())
                .agencia(contaRequestDTO.getAgencia())
                .numero(contaRequestDTO.getNumero())
                .cpf(contaRequestDTO.getCpf())
                .build();
    }
}
