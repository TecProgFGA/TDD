package unb.tecprog;

import unb.tecprog.constants.FaixaIRPFEnum;
import unb.tecprog.exception.ValorBaseInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimuladorIRPF {
    private List<Rendimento> rendimentos;
    private List<Deducao> deducoes;
    private List<PensaoAlimenticia> pensao;
    private List<PrevidenciaOficial> previdencia;
    private Double totalRendimento;
    private Double totalDeducao;
    private Double totalPensao;
    private Double valorPrevidencia;

    public SimuladorIRPF() {
        this.rendimentos = new ArrayList<>();
        this.deducoes = new ArrayList<>();
        this.pensao = new ArrayList<>();
        this.previdencia = new ArrayList<>();
        totalDeducao = 0.0;
        totalRendimento = 0.0;
        totalPensao = 0.0;
        valorPrevidencia = 0.0;
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
        previdencia.add(previdenciaOficial);
        valorPrevidencia = valor;
        totalDeducao += valor;
    }

    public void cadastrarPensaoAlimenticia(String nome, Double valor) {
        PensaoAlimenticia pensaoAlimenticia = new PensaoAlimenticia(valor);
        this.pensao.add(pensaoAlimenticia);
        this.deducoes.add(pensaoAlimenticia);
        totalPensao += valor;
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

    public double getPensaoAlimenticia() {return this.totalPensao;}
    public double getPrevidenciaOficial() {return this.valorPrevidencia;}

    public double calcularAliquotaEfetiva() {
        double imposto = calculaIRPF();
        double aliquotaEfetiva = (float)(Math.floor(imposto/this.getTotalRendimentos() * 10000) / 100.0);
        return aliquotaEfetiva;
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
        final double[] LIMITES_FAIXAS = {1903.98, 922.67, 924.40, 913.63,4664.68};
        final double[] ALIQUOTAS = {0.075, 0.15, 0.225, 0.275};
        return baseCalculo(baseCalculo, LIMITES_FAIXAS, ALIQUOTAS);
    }

    private double baseCalculo(Double baseCalculo, double LIMITE_FAIXAS[], double ALIQUOTAS[] ) {
        Double impostoFinal = 0.0;
        double valorFaixa = 0.0;

        if (baseCalculo > LIMITE_FAIXAS[4]) {
            valorFaixa = baseCalculo - LIMITE_FAIXAS[4];
            impostoFinal += valorFaixa * ALIQUOTAS[3];
        }

        if (baseCalculo > LIMITE_FAIXAS[2] + LIMITE_FAIXAS[1] + LIMITE_FAIXAS[0]) {
            valorFaixa = Math.min(baseCalculo - (LIMITE_FAIXAS[2] + LIMITE_FAIXAS[1] + LIMITE_FAIXAS[0]), LIMITE_FAIXAS[3]);
            impostoFinal += valorFaixa * ALIQUOTAS[2];
        }

        if (baseCalculo > LIMITE_FAIXAS[1] + LIMITE_FAIXAS[0]) {
            valorFaixa = Math.min(baseCalculo - (LIMITE_FAIXAS[1] + LIMITE_FAIXAS[0]), LIMITE_FAIXAS[2]);
            impostoFinal += valorFaixa * ALIQUOTAS[1];
        }

        if (baseCalculo > LIMITE_FAIXAS[0]) {
            valorFaixa = Math.min(baseCalculo - LIMITE_FAIXAS[0], LIMITE_FAIXAS[1]);
            impostoFinal += valorFaixa * ALIQUOTAS[0];
        }
        return impostoFinal;
    }


}

