package unb.tecprog;

public class Rendimento {
    private String descricacao;
    private Double valor;


    public Rendimento(String descricacao, Double valor) {
        this.descricacao = descricacao;
        this.valor = valor;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

}
