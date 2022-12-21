package unb.tecprog;

import unb.tecprog.exception.ValorBaseInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimuladorIRPF {
    private List<Rendimento> rendimentos;

    private List<Deducao> deducoes;
    private Double totalRendimento;
    private Double totalDeducao;

    public SimuladorIRPF() {
        this.rendimentos = new ArrayList<>();
        this.deducoes = new ArrayList<>();
        totalDeducao = 0.0;
        totalRendimento = 0.0;
    }

    public void cadastrarRendimento(String descricao, Double valor) {
        Rendimento rendimento = new Rendimento(descricao, valor);
        rendimentos.add(rendimento);
        totalRendimento += valor;
    }

    public void cadastrarDeducao(String descricao, Double valor)
    {
        Deducao deducao = new Deducao(descricao,valor);
        deducoes.add(deducao);
        totalDeducao += valor;
    }

    public void cadastrarPrevidenciaOficial(String descricao, Double valor) {
        PrevidenciaOficial previdenciaOficial = new PrevidenciaOficial(descricao, valor);
        deducoes.add(previdenciaOficial);
        totalDeducao += valor;
    }

    public void cadastrarPensaoAlimenticia(Double valor) {
        PensaoAlimenticia pensaoAlimenticia = new PensaoAlimenticia(valor);
        this.deducoes.add(pensaoAlimenticia);
        totalDeducao += valor;
    }

    public void cadastrarDependente(String nome, Date dataNascimento) {
        Dependente dependente = new Dependente(nome, dataNascimento);
        deducoes.add(dependente);
        totalDeducao += 189.59;
    }

    public Double getTotalRendimentos(){
        return this.totalRendimento;
    }

    public Double getTotalDeducoes() {
        return this.totalDeducao;
    }

    public Double getBaseCalculo() {
        Double base = getTotalRendimentos() - getTotalDeducoes();
        if(base < 0.0) {
            throw new ValorBaseInvalidoException("Erro! Base de calculo nao pode ser negativa.");
        }
        return  base;
    }

    public double calculaIRPF() {
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
