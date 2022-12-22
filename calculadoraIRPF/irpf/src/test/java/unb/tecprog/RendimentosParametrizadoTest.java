package unb.tecprog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class RendimentosParametrizadoTest {

    SimuladorIRPF simulador;

    Object[][] rendimentos;
    Double resultadoEsperado;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    public RendimentosParametrizadoTest(Object[][] rendimentos, Double resultadoEsperado) {
        this.rendimentos = rendimentos;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][]{
                {new Object[][]{
                        {"Salário", 1000.0},
                }, 1000.0},
                {new Object[][]{
                        {"Salário", 900.0},
                        {"Aluguel", 100.0}
                }, 1000.0},
                {new Object[][]{
                        {"Salário", 800.0},
                        {"Aluguel", 100.0},
                        {"Divídendo", 200.0}
                }, 1100.0},
        };
        return Arrays.asList(parametros);
    }

    @Test
    public void T01_CadastroUmRendimento() {
        for (Object[] o : rendimentos) {
            simulador.cadastrarRendimento((String) o[0], (Double) o[1]);
        }
        assertEquals(resultadoEsperado, simulador.getTotalRendimentos(), 0.0);
    }

//    @Test
//    public void T01_CadastroUmRendimento() {
//        simuladorIRPF.cadastrarRendimento("Salario", 16000.0);
//        assertEquals(16000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }
//
//    @Test
//    public void T01_CadastroUmRendimentoDuplicado() {
//        simuladorIRPF.cadastrarRendimento("Salario", 20000.0);
//        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }
//
//
//    @Test
//    public void T02_CadastroDoisRendimento() {
//        simuladorIRPF.cadastrarRendimento("Salario", 10000.0);
//        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
//        assertEquals(12000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }
//
//    @Test
//    public void T02_CadastroDoisRendimentoDuplicado() {
//        simuladorIRPF.cadastrarRendimento("Salario", 18000.0);
//        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
//        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }
//
//    @Test
//    public void T03_CadastroTresRendimento() {
//        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
//        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
//        simuladorIRPF.cadastrarRendimento("Rendimento de dividendos", 1000.0);
//        assertEquals(15000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }
//
//    @Test
//    public void T03_CadastroTresRendimentoDuplicado() {
//        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
//        simuladorIRPF.cadastrarRendimento("Aluguel", 5000.0);
//        simuladorIRPF.cadastrarRendimento("Rendimento de dividendos", 3000.0);
//        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }

}