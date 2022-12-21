package unb.tecprog;

public class Dependente extends Deducao{
    private Integer quantidade;
    private final Double VALOR_POR_DEPENDENTE = 189.59;

    public Dependente(String descricao, Integer quantidade) {
        super(descricao);
        this.quantidade = quantidade;
    }

    @Override
    public Double getValor() {
        return quantidade * VALOR_POR_DEPENDENTE;
    }

}
