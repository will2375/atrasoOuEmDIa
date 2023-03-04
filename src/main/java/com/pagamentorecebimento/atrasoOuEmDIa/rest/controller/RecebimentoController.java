package com.pagamentorecebimento.atrasoOuEmDIa.rest.controller;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.service.RecebimentosService;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter.RecebimentoAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recebimentos")
public class RecebimentoController {

    final RecebimentosService recebimentosService;
    final RecebimentoAdapter adapter;

    @GetMapping
    public List<RecebimentoResponse> buscarRecebimentos() {
        return recebimentosService.listaRecebimento();
    }

    @GetMapping(path = "/forma/{status}")
    public List<RecebimentoResponse> findBystatusRecebimento(@PathVariable String status) {
        return recebimentosService.findyRecebimentos(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentoResponse cadastrarRecebimentoDinheiro(@RequestBody RecebimentoRest rest) {
        RecebimentosModel model = adapter.calcularRecebimento(rest);
        recebimentosService.cadastrarRecebimento(model);
        RecebimentoResponse response = adapter.converterRecebimento(model);
        return response;
    }
}
