package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CadastroDeducaoTest{
    private Deducao deducao = new Deducao();
    private Cadastro cadastro;

    @before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDeducao() {
        simuladorIRPF.cadastraDeducao("Previdencia privada", 1500f);
        assertEquals(1500f, simuladorIRPF.getCadastraDeducao(), 0f);
    }

    @Test
    public void T02_CadastraDeducao() {
        simuladorIRPF.cadastraDeducao("Previdencia privada", 1900f);
        assertEquals(1900f, simuladorIRPF.getCadastraDeducao(), 0f);
    }

    @Test
    public void T03_CadastraDeducao() {
        simuladorIRPF.cadastraDeducao("Previdencia privada", 1100f);
        simuladorIRPF.cadastraDeducao("Funpresp", 1200f);

        assertEquals(2300f, simuladorIRPF.getCadastraDeducao(), 0f);
    }












}