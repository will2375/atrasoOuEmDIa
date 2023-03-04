package com.pagamentorecebimento.atrasoOuEmDIa.integration.controller;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.service.RecebimentosService;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter.RecebimentoAdapter;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecebimentoController {
    @Autowired
    private RecebimentosService recebimentosService;
    final RecebimentoAdapter adapter;

    @GetMapping(path = "/recebimentos")
    public List<RecebimentoResponse> buscarRecebimentos() {
        return recebimentosService.listaRecebimento();
    }

//    @GetMapping(path = "/recebimentos/forma/{status}")
//    public List<RecebimentosModel> findBystatusRecebimento(@PathVariable String status) {
//        return recebimentosService.findyRecebimentos(status);
//    }

    @PostMapping(path = "/recebimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentoResponse cadastrarRecebimentoDinheiro(@RequestBody RecebimentoRest rest) {
        RecebimentoResponse response = adapter.converterRecebimento(rest);
        return response;
    }
}
