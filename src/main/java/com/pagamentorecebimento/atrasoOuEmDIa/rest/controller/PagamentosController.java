package com.pagamentorecebimento.atrasoOuEmDIa.rest.controller;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.service.PagamentosService;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter.PagamentoAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagamentos")
public class PagamentosController {

    final PagamentosService pagamentosService;
    final PagamentoAdapter adapter;

    @GetMapping
    public List<PagamentoResponse> buscarPagamentos() {
        return pagamentosService.buscarPagamentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoResponse cadastrarPagamento(@RequestBody PagamentoRest rest) {
        PagamentosModel model = adapter.converterPagamento(rest);
        pagamentosService.pagamentoEmDia(model);
        PagamentoResponse response = adapter.response(model);
        return response;
    }
}