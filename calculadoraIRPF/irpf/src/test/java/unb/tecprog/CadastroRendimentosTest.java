package unb.tecprog;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CadastroRendimentosTest
{
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastroUmRendimento() {
        simuladorIRPF.cadastrarRendimento("Salario", 16000.0);
        assertEquals(16000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T02_CadastroDoisRendimento() {
        simuladorIRPF.cadastrarRendimento("Salario", 10000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
        assertEquals(12000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T03_CadastroTresRendimento() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
        simuladorIRPF.cadastrarRendimento("Rendimento de dividendos", 1000.0);
        assertEquals(15000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

}
