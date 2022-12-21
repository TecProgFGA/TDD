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
    public void T01_CadastraPrevidenciaOficial() {
        simuladorIRPF.cadastrarPrevidenciaOficial("INSS 1", 2100.0);
        assertEquals(2100.0, simuladorIRPF.getPrevidenciaOficial(),0.0);
    }
    @Test
    public void T02_CadastraPrevidenciaOficial() {
        simuladorIRPF.cadastrarPrevidenciaOficial("INSS 1", 3000.0);
        assertEquals(3000.0, simuladorIRPF.getPrevidenciaOficial(),0.0);
    }

    @Test
    public void T03_CadastraPrevidenciaOficial() {
        simuladorIRPF.cadastrarPrevidenciaOficial("INSS 1", 0.0);
        assertEquals(0.0, simuladorIRPF.getPrevidenciaOficial(),0.0);
    }

}