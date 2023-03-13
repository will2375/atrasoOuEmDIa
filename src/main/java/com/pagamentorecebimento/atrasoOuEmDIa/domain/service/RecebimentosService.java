package com.pagamentorecebimento.atrasoOuEmDIa.domain.service;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.ports.RecebimentoPort;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.recebimentos.RecebimentosStatus;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.adapter.RecebimentoPostgressDBAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.PagamentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.RecebimentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.repository.RecebimentosRepository;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecebimentosService implements RecebimentoPort {

    final RecebimentoPostgressDBAdapter adapter;

    @Autowired
    private RecebimentosRepository recebimentosRepository;




    @Override
    public RecebimentosModel cadastrarRecebimento(RecebimentosModel model) {
        BigDecimal resultado = RecebimentosStatus.getCalculoRecebimento(model.getStatus()).calcularDesconto(model.getValorAReceber());
        BigDecimal resultadoFinal = model.getValorAReceber().subtract(resultado);
        model.setDiferencaValor(resultado);
        model.setValorRecebido(resultadoFinal);
        adapter.salvarRecebimento(model);
        return model;
    }

    @Override
    public List<RecebimentoResponse> buscarRecebimentos(String status) {
            List<RecebimentoEntity> recebimentoEntityList = adapter.listaPorStatus(status);
            return recebimentoEntityList.stream().map(entity -> {
                return RecebimentoResponse.builder()
                        .codigo(entity.getCodigo()).status(entity.getStatus()).diferencaValor(entity.getDiferencaValor())
                        .valorAReceber(entity.getValorAReceber()).valorRecebido(entity.getValorRecebido()).build();
            }).collect(Collectors.toList());
        }

    @Override
    public List<RecebimentoResponse> listaRecebimentos() {
        List<RecebimentoEntity> listaRecebimentos = adapter.listaRecebimentos();
        return listaRecebimentos.stream().map(entity ->{
            return RecebimentoResponse.builder()
                    .codigo(entity.getCodigo()).status(entity.getStatus()).valorRecebido(entity.getValorRecebido())
                    .diferencaValor(entity.getDiferencaValor()).valorAReceber(entity.getValorAReceber()).build();
        }).collect(Collectors.toList());
    }


}
