package unb.tecprog;

import unb.tecprog.constants.FaixaIRPFEnum;

public class Imposto {
    public static double baseCalculo(Double baseCalculo) {
        Double impostoFinal = 0.0;
        Double valorFaixa = 0.0;
        for (FaixaIRPFEnum faixa : FaixaIRPFEnum.values()) {
            if (baseCalculo > faixa.getLimite()) {
                valorFaixa = Math.min(baseCalculo - faixa.getLimite(), faixa.getLimite());
                impostoFinal += valorFaixa * faixa.getAliquota();
            }
        }
        return impostoFinal;
    }
}

