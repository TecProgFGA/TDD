package unb.tecprog.exception;

public class ValorRendimentoInvalidoException extends RuntimeException {
    private final String mensagem;

    public ValorRendimentoInvalidoException(String mensagem) {

        super(mensagem);
        this.mensagem = mensagem;
    }
    public String getMensagem() {
        return mensagem;
    }
}
