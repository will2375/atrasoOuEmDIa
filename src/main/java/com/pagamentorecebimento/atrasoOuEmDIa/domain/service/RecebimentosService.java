package com.pagamentorecebimento.atrasoOuEmDIa.domain.service;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.recebimentos.RecebimentosFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.adapter.RecebimentoPostgressDBAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.entity.RecebimentoEntity;
import com.pagamentorecebimento.atrasoOuEmDIa.integration.repository.RecebimentosRepository;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecebimentosService {

    final RecebimentoPostgressDBAdapter adapter;

    @Autowired
    private RecebimentosRepository recebimentosRepository;

    public List<RecebimentoResponse> listaRecebimento() {
        List<RecebimentoEntity> recebimentoEntities = adapter.listaRecebimentos();
        return recebimentoEntities.stream().map(entity -> {
            return RecebimentoResponse.builder()
                    .codigo(entity.getCodigo()).status(entity.getStatus()).diferencaValor(entity.getDiferencaValor())
                    .valorAReceber(entity.getValorAReceber()).valorRecebido(entity.getValorRecebido()).build();
        }).collect(Collectors.toList());
    }

    public List<RecebimentoResponse> findyRecebimentos (String status){
        List<RecebimentoEntity> recebimentoEntityList = adapter.listaPorStatus(status);
        return recebimentoEntityList.stream().map(entity -> {
            return RecebimentoResponse.builder()
                    .codigo(entity.getCodigo()).status(entity.getStatus()).diferencaValor(entity.getDiferencaValor())
                    .valorAReceber(entity.getValorAReceber()).valorRecebido(entity.getValorRecebido()).build();
        }).collect(Collectors.toList());
    }

    public RecebimentosModel cadastrarRecebimento(RecebimentosModel recebimentosModel) {
        BigDecimal resultado = RecebimentosFactory.getCalculoRecebimento(recebimentosModel.getStatus()).calcularDesconto(recebimentosModel.getValorAReceber());
        BigDecimal resultadoFinal = recebimentosModel.getValorAReceber().subtract(resultado);
        recebimentosModel.setDiferencaValor(resultado);
        recebimentosModel.setValorRecebido(resultadoFinal);
        adapter.salvarRecebimento(recebimentosModel);
        return recebimentosModel;
    }
}
