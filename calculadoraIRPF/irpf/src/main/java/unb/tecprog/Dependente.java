package unb.tecprog;

import java.util.Date;

public class Dependente extends Deducao{
    private Date dataNascimento;

    public Dependente(String descricao, Date dataNascimento) {
        super(descricao, 189.59);
        this.dataNascimento = dataNascimento;

    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
