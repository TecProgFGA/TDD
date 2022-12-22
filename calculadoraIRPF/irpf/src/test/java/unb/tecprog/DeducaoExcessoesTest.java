package unb.tecprog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unb.tecprog.exception.DescricaoEmBrancoException;
import unb.tecprog.exception.ValorDeducaoInvalidoException;

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

    @Test
    public void T04_DeducaoDescricaoEmBrancoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        Deducao deducao = new Deducao("", 1000.0);
    }

    @Test
    public void T05_DeducaoDescricaoEmBrancoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        PrevidenciaOficial previdenciaOficial = new PrevidenciaOficial("", 1000.0);
    }

    @Test
    public void T06_DeducaoDescricaoEmBrancoExcessao () {
        exceptionRule.expect(DescricaoEmBrancoException.class);
        exceptionRule.expectMessage("Nao foi possivel cadastrar! descricao deducao esta vazia");
        Dependente dependente = new Dependente("", new Date(2010, 10, 10));
    }

    @Test
    public void T07_DeducaoValorNegativoExcessao () {
        exceptionRule.expect(ValorDeducaoInvalidoException.class);
        exceptionRule.expectMessage("Valor da deducao nao pode ser menor de 0.");
        Deducao deducao = new Deducao("Previdencia privada", -1.0);
    }

    @Test
    public void T08_DeducaoValorIgualZeroExcessao () {
        exceptionRule.expect(ValorDeducaoInvalidoException.class);
        exceptionRule.expectMessage("Valor da deducao nao pode ser menor de 0.");
        Deducao deducao = new Deducao("Previdencia privada", 0.0);
    }

    @Test
    public void T09_DeducaoValorNuloExcessao () {
        exceptionRule.expect(ValorDeducaoInvalidoException.class);
        exceptionRule.expectMessage("Valor da deducao nao pode ser menor de 0.");
        Deducao deducao = new Deducao("Previdencia privada", null);
    }
}