package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import unb.tecprog.exception.DescricaoEmBrancoException;

import static org.junit.Assert.assertEquals;


public class CadastroDeducaoTest{
    private SimuladorIRPF simuladorIRPF;
    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDeducaoPensaoAlimenticia() {
        simuladorIRPF.cadastrarDeducao("Deducao 1", 1500.0);
        assertEquals(1500.0, simuladorIRPF.getTotalDeducoes(), 0.009);
    }

    @Test
    public void T02_CadastraDeducaoPrevidenciaOficial() {
        simuladorIRPF.cadastrarPrevidenciaOficial("Previdencia privada", 1900.0);
        assertEquals(1900.0, simuladorIRPF.getTotalDeducoes(), 0.009);
    }
    @Test
    public void T03_CadastraDeducaoDependente() {
        simuladorIRPF.cadastrarDependente("Jao", new Date(2010, 10 ,30));
        assertEquals(189.59, simuladorIRPF.getTotalDeducoes(), 0.009);
    }

    @Test
    public void T04_InvalidaCadastraDeducaoEmBranco(){
        try {
        simuladorIRPF.cadastrarDeducao(" 10 ", 1500.0);
    } catch ( DescricaoEmBrancoException exec){
        assertEquals("Nao foi possivel cadastrar! descricao deducao esta vazia", exec.getMessage());
    }

    }


    @Test
    public void T05_InvalidaCadastraDeducaoValorNegativo(){
        try {
            simuladorIRPF.cadastrarDeducao(" ", 1500.0);
        } catch (DescricaoEmBrancoException exec){
            assertEquals("O campo de descrição está em branco", exec.getMessage());
        }

    }



}