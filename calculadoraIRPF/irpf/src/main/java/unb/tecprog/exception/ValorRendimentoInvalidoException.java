package unb.tecprog.exception;

public class ValorRendimentoInvalidoException extends RuntimeException {
    public static final String mensagem = "O rendimento apresentado é inválido";

    public ValorRendimentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
