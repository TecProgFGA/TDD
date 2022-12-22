package unb.tecprog;

import unb.tecprog.exception.DescricaoEmBrancoException;
import unb.tecprog.exception.ValorDeducaoInvalidoException;

public class Deducao {
    private String descricao;

    private Double valor;

    public Deducao(String descricao, Double valor) {
        if(descricao == null || descricao.isEmpty()) {
            throw new DescricaoEmBrancoException("Nao foi possivel cadastrar! descricao deducao esta vazia");
        }
        this.descricao = descricao;

        if( valor == null || valor <= 0.0) {
            throw new ValorDeducaoInvalidoException("Valor da deducao nao pode ser menor de 0.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor(){
        return valor;
    }
}
