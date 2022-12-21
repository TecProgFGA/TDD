package unb.tecprog.exception;

public class ValorDeducaoInvalidoException extends RuntimeException{
    public static final String mensagem = "Dedução inválida";
    public ValorDeducaoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
