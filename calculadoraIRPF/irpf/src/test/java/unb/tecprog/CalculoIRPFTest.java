package unb.tecprog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculoIRPFTest {

    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CalculoSemDeducao() throws Exception {
        simuladorIRPF.cadastrarRendimento(new Rendimento("Salario", 100000.0));
        assertEquals(26630.64, simuladorIRPF.calculaIRPF(), 0.01);
    }

    @Test
    public void T02_CalculoComDeducao() throws Exception {
        simuladorIRPF.cadastrarRendimento(new Rendimento("Salario", 100000.0));
        simuladorIRPF.cadastrarDeducao(new Dependente("Filhos", 10));
        assertEquals(26109.26, simuladorIRPF.calculaIRPF(), 0.01);
    }

    @Test
    public void T03_CalculoComMultiplasDeducoes() throws Exception {
        simuladorIRPF.cadastrarRendimento(new Rendimento("Total", 10000.0));
        simuladorIRPF.cadastrarDeducao(new Dependente("Filhos", 10));
        simuladorIRPF.cadastrarDeducao(new PensaoAlimenticia("Pensoa do Joao", 1900.0));
        assertEquals(836.76, simuladorIRPF.calculaIRPF(), 0.01);
    }
}
