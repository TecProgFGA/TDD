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
    public void T01_CalcularAliquotaFalsificação() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 12000.0);
        double aliquotaEfetiva = simuladorIRPF.calcularAliquotaEfetiva();
        assertEquals(20.25, aliquotaEfetiva, 0.01);
    }

    @Test
    public void T02_CalcularAliquotaFalsificação() {
        simuladorIRPF.cadastrarRendimento("Salario Total", 7000.0);
        double aliquotaEfetiva = simuladorIRPF.calcularAliquotaEfetiva();
        assertEquals(15.07, aliquotaEfetiva, 0.01);
    }
}
