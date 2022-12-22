package unb.tecprog;

import unb.tecprog.exception.DescricaoEmBrancoException;
import unb.tecprog.exception.ValorRendimentoInvalidoException;

public class Rendimento {
    private String descricao;
    private Double valor;


    public Rendimento(String descricao, Double valor) {
        if(descricao == null || descricao.isEmpty()) {
            throw new DescricaoEmBrancoException("Nao foi possivel cadastrar! descricao do rendimento esta vazia");
        }
        this.descricao = this.descricao;

        if( valor == null || valor <= 0.0) {
            throw new ValorRendimentoInvalidoException("Valor do rendimento nao pode ser menor de 0.");
        }
        this.valor = valor;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
