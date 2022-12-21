package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CadastroPensaoTest{
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraPensaoAlimenticia() {
        simuladorIRPF.cadastraPensaoAlimenticia(new PensaoAlimenticia("Pensao alimenticia", 1500.0));
        assertEquals(1500.0, simuladorIRPF.getPensaoAlimenticia(), 0.000);
    }

    @Test
    public void T02_CadastraPensaoAlimenticia() {
        simuladorIRPF.cadastraPensaoAlimenticia(new PensaoAlimenticia("Pensao alimenticia 1", 1500.0));
        simuladorIRPF.cadastraPensaoAlimenticia(new PensaoAlimenticia("Pensao alimenticia 2", 1700.0));
        assertEquals(3200.0, simuladorIRPF.getPensaoAlimenticia(), 0.000);

    }

    @Test
    public void T03_CadastraDeducaoDependente() {
        simuladorIRPF.cadastraPensaoAlimenticia(new PensaoAlimenticia(" ", 1500.0));
        assertEquals(3200.0, simuladorIRPF.getPensaoAlimenticia(), 0.000);
    }

    @Test
    public void T03_CadastraDeducaoDependente() {
        simuladorIRPF.cadastraPensaoAlimenticia(new PensaoAlimenticia("Pensão zero", 0.0));

    }

}