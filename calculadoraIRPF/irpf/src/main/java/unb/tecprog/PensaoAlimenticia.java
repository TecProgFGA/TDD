package unb.tecprog;

public class PensaoAlimenticia extends Deducao {
    private Double valor;

    public PensaoAlimenticia(String descricao, Double valor) {
        super(descricao);
        this.valor = valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public Double getValor() {
        return valor;
    }
}
