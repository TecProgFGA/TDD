package unb.tecprog;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CalculoAliquotaTest {

    private SimuladorIRPF simuladorIRPF;

    @Before
    public void setup (){
        simuladorIRPF = new SimuladorIRPF();
    }

    @Test
    public void T01_CalcularAliquotaRed() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
        double aliquotaEfetiva = simuladorIRPF.calcularAliquotaEfetiva();
        assertEquals(20.25, aliquotaEfetiva, 0.01);
    }
}
