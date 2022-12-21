package unb.tecprog;

public class PrevidenciaOficial extends Deducao {
    private Double valor;
    public PrevidenciaOficial(String descricao, Double valor) {
        super(descricao);
        this.valor = valor;
    }

    @Override
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
