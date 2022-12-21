package unb.tecprog;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CalculoIRPFTest {

    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CalculoSemDeducao() throws Exception {
        simuladorIRPF.cadastrarRendimento("Salario", 100000.0);
        assertEquals(26630.64, simuladorIRPF.calculaIRPF(), 0.01);
    }

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
        simuladorIRPF.cadastrarPensaoAlimenticia( 1900.0);
        assertEquals(1306.00, simuladorIRPF.calculaIRPF(), 0.01);
    }
}
