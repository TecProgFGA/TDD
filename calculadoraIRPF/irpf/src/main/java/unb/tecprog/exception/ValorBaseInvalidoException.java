package unb.tecprog.exception;

public class ValorBaseInvalidoException extends RuntimeException {
    private final String mensagem;

    public ValorBaseInvalidoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
