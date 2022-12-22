package unb.tecprog;


import org.junit.Before;
import org.junit.Test;
import unb.tecprog.exception.ValorRendimentoInvalidoException;

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
    public void T01_CadastroUmRendimentoDuplicado() {
        simuladorIRPF.cadastrarRendimento("Salario", 20000.0);
        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }


    @Test
    public void T02_CadastroDoisRendimento() {
        simuladorIRPF.cadastrarRendimento("Salario", 10000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
        assertEquals(12000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T02_CadastroDoisRendimentoDuplicado() {
        simuladorIRPF.cadastrarRendimento("Salario", 18000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T03_CadastroTresRendimento() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 2000.0);
        simuladorIRPF.cadastrarRendimento("Rendimento de dividendos", 1000.0);
        assertEquals(15000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

    @Test
    public void T03_CadastroTresRendimentoDuplicado() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
        simuladorIRPF.cadastrarRendimento("Aluguel", 5000.0);
        simuladorIRPF.cadastrarRendimento("Rendimento de dividendos", 3000.0);
        assertEquals(20000.0, simuladorIRPF.getTotalRendimentos(), 0.0);
    }

}
