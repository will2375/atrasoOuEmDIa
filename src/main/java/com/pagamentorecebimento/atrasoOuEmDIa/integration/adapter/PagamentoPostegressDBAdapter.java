package com.pagamentorecebimento.atrasoOuEmDIa.integration.adapter;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.ports.SalvarPagamentoPort;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.PagamentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.repository.PagamentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PagamentoPostegressDBAdapter implements SalvarPagamentoPort {
    @Autowired
    final PagamentosRepository repository;

    final
    @Override
    public void salvarPagamento(PagamentosModel model) {
        final PagamentoEntity entity = PagamentoEntity.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAPagar(model.getValorAPagar())
                .diferencaValor(model.getDiferencaValor())
                .valorPago(model.getValorPago()).build();
        repository.save(entity);
    }

    public List<PagamentoEntity> listaPagamentos() {
        return repository.findAll();
    }
}
