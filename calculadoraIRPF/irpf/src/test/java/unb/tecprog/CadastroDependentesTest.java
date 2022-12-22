package unb.tecprog;
import org.junit.Before;
import org.junit.Test;



import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CadastroDependentesTest{
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDependente() {
        simuladorIRPF.cadastrarDependente("Arthur Talles",new Date(2000, 12, 02));

    }
    @Test
    public void T01_CadastraDependenteDuplicado() {
        simuladorIRPF.cadastrarDependente("João",new Date(2003, 02, 02));

    }

    @Test
    public void T02_CadastraDependente() {
        simuladorIRPF.cadastrarDependente("Arthur Talles",new Date(2000, 12,02));
        simuladorIRPF.cadastrarDependente("Eduardo",new Date(1999, 9,07));

    }

    @Test
    public void T03_CadastraDependente() {
        simuladorIRPF.cadastrarDependente("Fernanda",new Date(2000, 12,22));
        simuladorIRPF.cadastrarDependente("Alberto",new Date(1986, 9,27));
        simuladorIRPF.cadastrarDependente("Larissa",new Date(1992, 05,04));

    }
    //@Test
    //public void T03_CadastraDependente() {
        //simuladorIRPF.cadastrarDependente("","" );
    //}


}