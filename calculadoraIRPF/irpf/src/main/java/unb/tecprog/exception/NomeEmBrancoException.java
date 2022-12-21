package unb.tecprog.exception;

public class NomeEmBrancoException  extends RuntimeException{
    public static final String mensagem = "O campo de nome está em branco";

    public NomeEmBrancoException(String mensagem) {
        super(mensagem);
    }
}
