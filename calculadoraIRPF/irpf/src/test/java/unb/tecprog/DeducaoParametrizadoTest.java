package unb.tecprog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DeducaoParametrizadoTest {
    Object[][] rendimentos;
    Double valorEsperado;

    SimuladorIRPF simuladorIRPF;

    @Before
    public void setup() {
        simuladorIRPF = new SimuladorIRPF();
    }

    public DeducaoParametrizadoTest(Object[][] deducaoERendimento, Double valorEsperado) {
        this.rendimentos = deducaoERendimento;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] valores = new Object[][]{
                {
                    new Object[][]{
                        {"Previdência", 202.99},
                        {"Salário", 10001.45}
                    },
                        10204.44
                },
                {new Object[][]{
                        {"Pensão", 300.59},
                        {"Aluguel", 2000.15}
                }, 2300.74},
                {new Object[][]{
                        {"Pensão", 400.0},
                        {"Aluguel", 2000.0}
                }, 2400.0}
        };
        return Arrays.asList(valores);
    }


    @Test
    public void testRendimentosTotal() {
        for (Object[] rendimento : rendimentos) {
            simuladorIRPF.cadastrarRendimento((String) rendimento[0], (Double) rendimento[1]);
        }
        assertEquals(valorEsperado, simuladorIRPF.getTotalRendimentos(), 0.01);
    }
}