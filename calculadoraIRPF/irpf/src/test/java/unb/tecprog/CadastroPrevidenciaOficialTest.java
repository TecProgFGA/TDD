package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CadastroPrevidenciaOficialTest {
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup() {
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDependente() {
        simuladorIRPF.cadastrarPrevidenciaOficial("INSS 1", 2100.0);
        simuladorIRPF.cadastrarPrevidenciaOficial("INSS 2", 1700.0);
        //assertEquals(3800.0, simuladorIRPF.getTotalDeducaoPrevidenciaOficial(),0.0);
    }

}