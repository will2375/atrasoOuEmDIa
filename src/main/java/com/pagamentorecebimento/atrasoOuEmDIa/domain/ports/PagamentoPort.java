package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;

import java.util.List;

public interface PagamentoPort {
     PagamentosModel pagamentoEmDia(PagamentosModel model);

      List<PagamentoResponse> buscarPagamentos();
}
