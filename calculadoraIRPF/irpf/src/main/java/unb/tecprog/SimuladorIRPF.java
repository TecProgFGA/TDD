package unb.tecprog;

import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {
    private List<Rendimento> rendimentos;

    public SimuladorIRPF() {
        this.rendimentos = new ArrayList<>();
    }

    public void cadastrarRendimentos(String descricao, Double valor) {
        rendimentos.add(new Rendimento(descricao, valor));

    }
    public Double getTotalRendimentos() {
        Double soma = 0.0;
        for (Rendimento rendimento : this.rendimentos) {
            soma += rendimento.getValor();
        }
        return soma;
    }
}
