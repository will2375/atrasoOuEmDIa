package com.pagamentorecebimento.atrasoOuEmDIa.integration.controller;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.service.PagamentosService;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter.PagamentoAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    final PagamentoAdapter adapter;

    @GetMapping(path = "/pagamentos")
    public List<PagamentoResponse> buscarPagamentos() {
        return pagamentosService.buscarPagamentos();
    }

    @PostMapping(path = "/pagamentos/antecipado")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoResponse cadastrarPagamento(@RequestBody PagamentoRest rest) {
        PagamentoResponse response = adapter.converterPagamento(rest);
        return response;
    }

    @PostMapping(path = "/pagamentos/atrasado")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoResponse cadastrarPagamentoAtrasado(@RequestBody PagamentoRest rest) {
        PagamentoResponse response = adapter.converterPagamento(rest);
        return response;
    }
}