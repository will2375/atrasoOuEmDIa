package com.pagamentorecebimento.atrasoOuEmDIa.integration.repository;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.RecebimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecebimentosRepository extends JpaRepository<RecebimentoEntity, Long> {
    public List<RecebimentoEntity> findByStatus (String status);
}
