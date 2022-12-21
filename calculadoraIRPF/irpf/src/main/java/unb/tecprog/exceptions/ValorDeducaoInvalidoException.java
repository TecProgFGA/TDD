package unb.tecprog.exceptions;

public class ValorDeducaoInvalidoException extends Exception{
    public ValorDeducaoInvalidoException() {
        super("Valor da dedução inválido, insira um valor maior que zero");
    }
}