package unb.tecprog.constants;

public enum FaixaIRPFEnum {
        FAIXA1(1903.98, 0.075),
        FAIXA2(922.67, 0.15),
        FAIXA3(924.40, 0.225),
        FAIXA4(913.63, 0.275);

        private final Double limite;
        private final Double aliquota;

        FaixaIRPFEnum(Double limite, Double aliquota) {
            this.limite = limite;
            this.aliquota = aliquota;
        }

        public Double getLimite() {
            return limite;
        }

        public Double getAliquota() {
            return aliquota;
        }
    }

