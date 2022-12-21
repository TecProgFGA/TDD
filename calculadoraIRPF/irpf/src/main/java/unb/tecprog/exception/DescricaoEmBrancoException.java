package unb.tecprog.exception;

public class DescricaoEmBrancoException extends RuntimeException{
    public static final String mensagem = "O campo de descrição está em branco";
    public DescricaoEmBrancoException(String mensagem) {
        super(mensagem);
    }

}
