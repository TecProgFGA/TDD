package unb.tecprog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unb.tecprog.exception.DescricaoEmBrancoException;

public class DeducaoExcessoesTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void T01_DeducaoDescricaoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Ola mundo");
        throw new DescricaoEmBrancoException("Ola mundo");
    }
}