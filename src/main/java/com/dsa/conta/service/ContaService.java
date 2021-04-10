package com.dsa.conta.service;

import com.dsa.conta.document.Conta;
import com.dsa.conta.exception.BusinessException;
import com.dsa.conta.exception.DataNotFoundException;
import com.dsa.conta.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
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

        return contaRepository.save(conta);
    }

    public void update(Conta contaAtualizada) {

        if (Objects.isNull(contaAtualizada.getId())) {
            throw new BusinessException("ID da conta é obrigatório");
        }

        prepareContaForUpdate(contaAtualizada, findById(contaAtualizada.getId()));
        contaRepository.save(contaAtualizada);
    }

    private void prepareContaForUpdate(Conta contaAtualizada, Conta contaAntiga) {

        contaAtualizada.setDataCriacao(contaAntiga.getDataCriacao());
        contaAtualizada.setStatus(contaAntiga.getStatus());
        contaAtualizada.setDataAtualizacao(LocalDate.now());
    }

    public void delete(String id) {

        Conta conta = findById(id);
        conta.setStatus(Boolean.FALSE);
        contaRepository.save(conta);
    }
}
