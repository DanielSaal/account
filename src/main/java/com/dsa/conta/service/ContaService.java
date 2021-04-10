package com.dsa.conta.service;

import com.dsa.conta.document.Conta;
import com.dsa.conta.exception.BusinessException;
import com.dsa.conta.exception.DataNotFoundException;
import com.dsa.conta.repository.ContaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta findById(String id) {

        log.info("Buscando conta com ID [{}].", id);
        Optional<Conta> conta = contaRepository.findByIdAndStatusIsTrue(id);
        return conta.orElseThrow(DataNotFoundException::new);
    }

    public List<Conta> findAll(Pageable pageable) {

        if (pageable.isPaged()) {
            log.info("Buscando contas paginadas. Página: {}, Tamanho: {}", pageable.getPageNumber(), pageable.getPageSize());
            Page<Conta> contas = contaRepository.findAllByStatusIsTrue(pageable);
            return contas.getContent();
        }

        log.info("Buscando todas as contas.");
        return contaRepository.findAll();
    }

    public Conta insert(Conta conta) {

        log.info("Inserindo nova conta: {}", conta);
        conta.setDataCriacao(LocalDate.now());
        conta.setDataAtualizacao(LocalDate.now());
        conta.setStatus(Boolean.TRUE);

        return contaRepository.save(conta);
    }

    public void update(Conta contaAtualizada) {

        if (Objects.isNull(contaAtualizada.getId())) {
            throw new BusinessException("ID da conta é obrigatório");
        }

        log.info("Atualizando conta com ID [{}].", contaAtualizada.getId());
        prepareContaForUpdate(contaAtualizada, findById(contaAtualizada.getId()));
        contaRepository.save(contaAtualizada);
    }

    private void prepareContaForUpdate(Conta contaAtualizada, Conta contaAntiga) {

        contaAtualizada.setDataCriacao(contaAntiga.getDataCriacao());
        contaAtualizada.setStatus(contaAntiga.getStatus());
        contaAtualizada.setDataAtualizacao(LocalDate.now());
    }

    public void delete(String id) {

        log.info("Removendo conta com ID [{}].", id);
        Conta conta = findById(id);
        conta.setStatus(Boolean.FALSE);
        contaRepository.save(conta);
    }
}
