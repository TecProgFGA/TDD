package unb.tecprog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CadastroDependentesTest{
    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CadastraDependente() {
        simuladorIRPF.cadastraDependente(("Arthur Talles", 2100.0));

    }

    @Test
    public void T02_CadastraDependente() {
        simuladorIRPF.cadastraDependente(("Arthur Talles", 2100.0));
        simuladorIRPF.cadastraDependente(("Eduardo", 2500.0));

    }

    @Test
    public void T03_CadastraDependente() {
        simuladorIRPF.cadastraDependente(("",""));


}