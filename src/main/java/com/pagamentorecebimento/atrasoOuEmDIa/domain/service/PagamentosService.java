package com.pagamentorecebimento.atrasoOuEmDIa.domain.service;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.formaspagamento.PagamentosStatus;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.adapter.PagamentoPostegressDBAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.PagamentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagamentosService {

    final PagamentoPostegressDBAdapter adapter;

    public List<PagamentoResponse> buscarPagamentos() {
        List<PagamentoEntity> listaPagamentos = adapter.listaPagamentos();
        return listaPagamentos.stream().map(entity ->{
            return PagamentoResponse.builder()
                    .codigo(entity.getCodigo()).status(entity.getStatus()).diferencaValor(entity.getDiferencaValor())
                    .valorAPagar(entity.getValorAPagar()).valorPago(entity.getValorPago()).build();
        }).collect(Collectors.toList());
    }

    public PagamentosModel pagamentoEmDia(PagamentosModel model) {
        BigDecimal resultado = PagamentosStatus.getCalculoPagamento(model.getStatus()).calculoPagamento(model.getValorAPagar(), model.getDiferencaValor());
        model.setValorPago(resultado);
        adapter.salvarPagamento(model);
        return model;
    }
}
