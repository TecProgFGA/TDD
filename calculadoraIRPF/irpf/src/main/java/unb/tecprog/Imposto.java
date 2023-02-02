package unb.tecprog;

public class Imposto {
    public static double baseCalculo(Double baseCalculo, double LIMITE_FAIXAS[], double ALIQUOTAS[] ) {
        Double impostoFinal = 0.0;
        Double valorFaixa = 0.0;

        for (int i = 0; i < LIMITE_FAIXAS.length; i++) {
            if (baseCalculo > LIMITE_FAIXAS[i]) {
                valorFaixa = Math.min(baseCalculo - LIMITE_FAIXAS[i], LIMITE_FAIXAS[i]);
                impostoFinal += valorFaixa * ALIQUOTAS[i];
            }
        }
        return impostoFinal;
    }
}

