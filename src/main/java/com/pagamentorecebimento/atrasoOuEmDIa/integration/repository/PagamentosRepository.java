package com.pagamentorecebimento.atrasoOuEmDIa.integration.repository;

import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentosRepository extends JpaRepository<PagamentoEntity, Long> {
}
