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
        simuladorIRPF.cadastrarRendimentos("Salario", 16000.0);
        assertEquals(16000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T02_CadastroDoisRendimento() {
        simuladorIRPF.cadastrarRendimentos("Salario", 10000.0);
        simuladorIRPF.cadastrarRendimentos("Aluguel", 2000.0);
        assertEquals(12000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

//    @Test
//    public void T03_CadastroTresRendimento() {
//        simuladorIRPF.cadastrarRendimentos("Salario Total", 12000.0);
//        simuladorIRPF.cadastrarRendimentos("Aluguel", 2000.0);
//        simuladorIRPF.cadastrarRendimentos("Rendimento de dividendos", 1000.0);
//        assertEquals(15000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
//    }

}
