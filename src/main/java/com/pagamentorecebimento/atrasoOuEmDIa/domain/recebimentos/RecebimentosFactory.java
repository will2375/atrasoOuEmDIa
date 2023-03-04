package com.pagamentorecebimento.atrasoOuEmDIa.domain.recebimentos;

public class RecebimentosFactory {
    public static Recebimentos getCalculoRecebimento(String statusRecebimento) {
        if (statusRecebimento.equalsIgnoreCase("cartao_credito")) {
            return new Credito();
        } else if (statusRecebimento.equalsIgnoreCase("cartao_debito")) {
            return new Debito();
        } else if (statusRecebimento.equalsIgnoreCase("vale_refeicao")) {
            return new ValeRefeicao();
        } else if (statusRecebimento.equalsIgnoreCase("DIN_PIX_CHEQUE")) {
            return new PixDinCheque();
        }else {
            return null;
        }
    }
}
