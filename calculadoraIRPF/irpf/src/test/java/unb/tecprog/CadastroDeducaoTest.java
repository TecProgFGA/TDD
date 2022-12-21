package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CadastroDeducaoTest{
    private SimuladorIRPF simuladorIRPF;
    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDeducaoPensaoAlimenticia() {
        simuladorIRPF.cadastrarDeducao(new PensaoAlimenticia("Pensao alimenticia", 1500.0));
        assertEquals(1500.0, simuladorIRPF.getTotalDeducoes(), 0.009);
    }

    @Test
    public void T02_CadastraDeducaoPrevidenciaOficial() {
        simuladorIRPF.cadastrarDeducao(new PrevidenciaOficial("Previdencia privada", 1900.0));
        assertEquals(1900.0, simuladorIRPF.getTotalDeducoes(), 0.009);
    }

    @Test
    public void T03_CadastraDeducaoDependente() {
        simuladorIRPF.cadastrarDeducao(new Dependente("Previdencia privada", 10));
        assertEquals(1895.9, simuladorIRPF.getTotalDeducoes(), 0.009);
    }












}