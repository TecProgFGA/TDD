package unb.tecprog.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unb.tecprog.Rendimento;
import unb.tecprog.exception.DescricaoEmBrancoException;
import unb.tecprog.exception.ValorRendimentoInvalidoException;

import java.util.Date;

public class RendimentoExcecoesTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void T01_RendimentoDescricaoNulaExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao do rendimento esta vazia");
        Rendimento Rendimento = new Rendimento(null, 1000.0);
    }

    @Test
    public void T012_RendimentoDescricaoNulaExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao do rendimento esta vazia");
        Rendimento Rendimento = new Rendimento(null, 2000.0);
    }

    @Test
    public void T02_RendimentoDescricaoEmBrancoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao do rendimento esta vazia");

        Rendimento Rendimento = new Rendimento("", 1000.0);
    }

    @Test
    public void T021_RendimentoDescricaoEmBrancoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao do rendimento esta vazia");

        Rendimento Rendimento = new Rendimento("", 1200.0);
    }

    @Test
    public void T03_RendimentoValorNegativoExcessao () {
        exceptionRule.expect(ValorRendimentoInvalidoException.class);
        exceptionRule.expectMessage("Valor do rendimento nao pode ser menor de 0.");
        Rendimento Rendimento = new Rendimento("Previdencia privada", -1.0);
    }

    @Test
    public void T031_RendimentoValorNegativoExcessao () {
        exceptionRule.expect(ValorRendimentoInvalidoException.class);
        exceptionRule.expectMessage("Valor do rendimento nao pode ser menor de 0.");
        Rendimento Rendimento = new Rendimento("Previdencia privada", -12.0);
    }

    @Test
    public void T04_RendimentoValorIgualZeroExcessao () {
        exceptionRule.expect(ValorRendimentoInvalidoException.class);
        exceptionRule.expectMessage("Valor do rendimento nao pode ser menor de 0.");
        Rendimento Rendimento = new Rendimento("Previdencia privada", 0.0);
    }

    @Test
    public void T05_RendimentoValorNuloExcessao () {
        exceptionRule.expect(ValorRendimentoInvalidoException.class);
        exceptionRule.expectMessage("Valor do rendimento nao pode ser menor de 0.");
        Rendimento Rendimento = new Rendimento("Previdencia privada", null);
    }
}
