package com.dsa.conta.service;

import com.dsa.conta.document.Conta;
import com.dsa.conta.exception.DataNotFoundException;
import com.dsa.conta.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta findById(String id) {

        Optional<Conta> conta = contaRepository.findById(id);
        return conta.orElseThrow(DataNotFoundException::new);
    }

    public Conta insert(Conta conta) {

        conta.setDataCriacao(LocalDate.now());
        conta.setDataAtualizacao(LocalDate.now());
        conta.setStatus(Boolean.TRUE);

        return contaRepository.insert(conta);
    }
}
