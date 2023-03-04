package com.pagamentorecebimento.atrasoOuEmDIa.integration.adapter;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.ports.SalvarRecebimentoPort;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.RecebimentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.repository.RecebimentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RecebimentoPostgressDBAdapter implements SalvarRecebimentoPort {
    @Autowired
    final RecebimentosRepository repository;

    @Override
    public void salvarRecebimento(RecebimentosModel model) {
        final RecebimentoEntity entity = RecebimentoEntity.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAReceber(model.getValorAReceber())
                .diferencaValor(model.getDiferencaValor())
                .valorRecebido(model.getValorRecebido()).build();
        repository.save(entity);
    }

    public List<RecebimentoEntity> listaRecebimentos() {
        return repository.findAll();
    }

    public List<RecebimentoEntity> listaPorStatus(String status) {
        return repository.findByStatus(status);
    }
}
