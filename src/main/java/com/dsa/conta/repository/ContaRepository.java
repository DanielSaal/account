package com.dsa.conta.repository;

import com.dsa.conta.document.Conta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String> {
}
