package com.dsa.conta.repository;

import com.dsa.conta.document.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String> {

    Optional<Conta> findByIdAndStatusIsTrue(String id);
    Page<Conta> findAllByStatusIsTrue(Pageable pageable);
}
