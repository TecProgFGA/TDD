package unb.tecprog;
import unb.tecprog.Deducao;
import unb.tecprog.Rendimento;
import unb.tecprog.SimuladorIRPF;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DeducaoTestParametrizado {
    Object[][] deducaoERendimento;
    float valorEsperado;

    SimuladorIRPF dedu;

    @Before
    public void setup() {
        dedu = new SimuladorIRPF();
    }

    public DeducaoTestParametrizado(Object[][] deducaoERendimento, float valorEsperado) {
        this.deducaoERendimento = deducaoERendimento;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] valores = new Object[][] {
                {new Object[][] {
                        {"Previdência", 200.0, "Salário", 10000.0}
                }, 9800.0},
                {new Object[][] {
                        {"Pensão", 400.0, "Aluguel", 2000.0}
                }, 1600.0},
                {new Object[][] {
                        {"Pensão", -400.0, "Aluguel", -2000.0}
                }, 0.0}
        };
        return Arrays.asList(valores);
    }


    @Test
    public void testCalculoDeducao() {
        ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
        ArrayList<Deducao> deducoes = new ArrayList<Deducao>();

        for (Object[] deduRendi : deducaoERendimento) {
            if (deduRendi[0] != null && deduRendi[1] != null) {
                deducoes.add(new Deducao((String) deduRendi[0], (double)deduRendi[1]));
            }
            if (deduRendi[2] != null && deduRendi[3] != null) {
                rendimentos.add(new Rendimento((String)deduRendi[2], (double)deduRendi[3]));
            }

        }
        dedu.getTotalDeducoes();
    }
}