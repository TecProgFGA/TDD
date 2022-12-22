package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

public class CadastroDependentesTest{
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDependente() {
        //simuladorIRPF.cadastrarDependente("Arthur Talles","05/10/2000");

    }

    @Test
    public void T02_CadastraDependente() {
        //simuladorIRPF.cadastrarDependente("Arthur Talles","05/10/2000" );
        //simuladorIRPF.cadastrarDependente("Eduardo","07/09/1999" );

    }

    @Test
    public void T03_CadastraDependente() {
        //simuladorIRPF.cadastrarDependente("","" );
    }


}