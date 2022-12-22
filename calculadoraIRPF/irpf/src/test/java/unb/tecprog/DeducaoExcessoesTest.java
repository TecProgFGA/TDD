package unb.tecprog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unb.tecprog.exception.DescricaoEmBrancoException;

import java.util.Date;

public class DeducaoExcessoesTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void T01_DeducaoDescricaoNulaExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        Deducao deducao = new Deducao(null, 1000.0);
    }

    @Test
    public void T02_DeducaoDescricaoNulaExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        PrevidenciaOficial previdenciaOficial = new PrevidenciaOficial(null, 1000.0);
    }

    @Test
    public void T03_DeducaoDescricaoNulaExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        Dependente dependente = new Dependente(null, new Date(2010, 10, 10));
    }
}