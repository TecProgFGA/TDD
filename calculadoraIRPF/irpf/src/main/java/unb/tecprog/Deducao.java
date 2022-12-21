package unb.tecprog;

public abstract class Deducao {
    private String descricao;

    public Deducao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract Double getValor();
}
