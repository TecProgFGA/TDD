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
        return Imposto.baseCalculo(baseCalculo);
    }

}

