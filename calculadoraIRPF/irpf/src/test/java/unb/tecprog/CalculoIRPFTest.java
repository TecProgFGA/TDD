package unb.tecprog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculoIRPFTest {

    private SimuladorIRPF simuladorIRPF;

    private final Object[][] rendimentos;
    private final Double valorEsperado;

    public CalculoIRPFTest(Object[][] rendimentos, Double valorEsperado) {
        this.rendimentos = rendimentos;
        this.valorEsperado = valorEsperado;
    }

    @Before
    public void setup() {
        simuladorIRPF = new SimuladorIRPF();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] calculoSemDeducao = new Object[][]{
                {
                        new Object[][]{{"Salario", 100000.0}},
                        26630.64
                },
                {
                        new Object[][]{
                                {"Salario", 100000.0},
                                {"Dividendos de fundos imobiliarios", 1000.0},
                                {"Rendimento em acoes", 450.0}
                        },
                        27029.39
                },
                {
                        new Object[][]{
                                {"Salario", 10000.0},
                                {"Resultado Investimentos", 500.0}
                        },
                        2018.14
                },
        };
        return Arrays.asList(calculoSemDeducao);
    }

    @Test
    public void testCalculoRendimentos() {
        for(Object[] rendimento: rendimentos) {
            simuladorIRPF.cadastrarRendimento((String) rendimento[0],(Double) rendimento[1]);
        }
        assertEquals(valorEsperado, simuladorIRPF.calculaIRPF(), 0.01);
    }
//    @Test
//    public void T01_CalculoSemDeducao() throws Exception {
//        simuladorIRPF.cadastrarRendimento("Salario", 100000.0);
//        assertEquals(26630.64, simuladorIRPF.calculaIRPF(), 0.01);
//    }
//
//    @Test
//    public void T02_CalculoSemDeducao() throws Exception {
//        simuladorIRPF.cadastrarRendimento("Salario", 100000.0);
//        simuladorIRPF.cadastrarRendimento("Dividendos de fundos imobiliarios", 1000.0);
//        simuladorIRPF.cadastrarRendimento("Rendimento em acoes", 450.0);
//
//        assertEquals(27029.39, simuladorIRPF.calculaIRPF(), 0.01);
//    }
//
//    @Test
//    public void T03_CalculoSemDeducao() throws Exception {
//        simuladorIRPF.cadastrarRendimento("Salario", 10000.0);
//        simuladorIRPF.cadastrarRendimento("Resultado Investimentos", 500.0);
//        assertEquals(2018.14, simuladorIRPF.calculaIRPF(), 0.01);
//    }

    @Test
    public void T02_CalculoComDeducao() throws Exception {
        simuladorIRPF.cadastrarRendimento("Salario", 100000.0);
        simuladorIRPF.cadastrarDependente("Joao Silva Filhos", new Date(2010, 12, 30));
        assertEquals(26578.50, simuladorIRPF.calculaIRPF(), 0.01);
    }

    @Test
    public void T03_CalculoComMultiplasDeducoes() throws Exception {
        simuladorIRPF.cadastrarRendimento("Total", 10000.0);
        simuladorIRPF.cadastrarDependente("Joao Silva Filho", new Date(2010, 12, 30));
        simuladorIRPF.cadastrarPensaoAlimenticia("Pensao Alimenticia", 1900.0);
        simuladorIRPF.cadastrarDeducao("Cobranca agiota", 1000.0);
        simuladorIRPF.cadastrarPrevidenciaOficial("Previdencia Privada Bradesco", 1000.0);
        assertEquals(756.00, simuladorIRPF.calculaIRPF(), 0.01);
    }
}
