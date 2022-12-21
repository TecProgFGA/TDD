package unb.tecprog;

import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {
    private List<Rendimento> rendimentos;

    private List<Deducao> deducoes;

    public SimuladorIRPF() {
        this.rendimentos = new ArrayList<>();
        this.deducoes = new ArrayList<>();
    }

    public void cadastrarRendimento(Rendimento rendimento) { rendimentos.add(rendimento); }

    public void cadastrarDeducao(Deducao deducao) {
        deducoes.add(deducao);
    }

    public Double getTotalRendimentos() {
        Double soma = 0.0;
        for (Rendimento rendimento : this.rendimentos) {
            soma += rendimento.getValor();
        }
        return soma;
    }

    public Double getTotalDeducoes() {
        Double soma = 0.0;
        for (Deducao deducao : this.deducoes) {
            soma += deducao.getValor();
        }
        return soma;
    }

    public Double getBaseCalculo() throws Exception {
        Double base = getTotalRendimentos() - getTotalDeducoes();
        if(base < 0.0) {
            throw new Exception("Erro! Base de calculo nao pode ser negativa.");
        }
        return  base;
    }

    public double calculaIRPF() throws Exception {
        Double baseCalculo = getBaseCalculo();
        Double impostoFinal = 0.0;

        Double LIMITE_FAIXA1 = 1903.98;
        Double LIMITE_FAIXA2 = 922.67;
        Double LIMITE_FAIXA3 = 924.40;
        Double LIMITE_FAIXA4 = 913.63;
        Double LIMITE_FAIXA5 = LIMITE_FAIXA4 + LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1;
        Double valorFaixa = 0.0;

        if (baseCalculo > LIMITE_FAIXA5) {
            valorFaixa = baseCalculo - LIMITE_FAIXA5;
            impostoFinal += valorFaixa * 0.275;
        }

        if (baseCalculo > LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1) {
            valorFaixa = Math.min(baseCalculo - (LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1), LIMITE_FAIXA4);
            impostoFinal += valorFaixa * 0.225;
        }

        if (baseCalculo > LIMITE_FAIXA2 + LIMITE_FAIXA1) {
            valorFaixa = Math.min(baseCalculo - (LIMITE_FAIXA2 + LIMITE_FAIXA1), LIMITE_FAIXA3);
            impostoFinal += valorFaixa * 0.15;
        }

        if (baseCalculo > LIMITE_FAIXA1) {
            valorFaixa = Math.min(baseCalculo - LIMITE_FAIXA1, LIMITE_FAIXA2);
            impostoFinal += valorFaixa * 0.075;
        }

        return impostoFinal;
    }
}
