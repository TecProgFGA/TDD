/*package unb.tecprog;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Calculadora {

        public static void main(String[] args) throws ParseException {
            double rendimento, previdenciaOficial,pensao;
            int qtde;
            String descricao1, descricao2, descricao3, descricao4, dataNascimento;

            Scanner ler = new Scanner (System.in);

            System.out.print("\n\n\n");
            System.out.print("------------------->>> Calculadora da Alíquota Efetiva<<<-----------------\n");
            System.out.print("\n");

            System.out.print(" 1 - Rendimentos tributáveis:\n");
            System.out.print(" Descrição:\n");
            descricao1 = ler.next();
            System.out.print(" Valor do rendimento:\n");
            rendimento = ler.nextDouble();
            SimuladorIRPF sim = new SimuladorIRPF();
            sim.cadastrarRendimento(descricao1, rendimento);

            System.out.print("2 - Deduções       \n");

            System.out.print("2.1 - Previdência Oficial: \n");
            System.out.print(" Descrição:\n");
            descricao2 = ler.next();
            System.out.print("Valor da previdência:\n");
            previdenciaOficial = ler.nextDouble();
            sim.cadastrarPrevidenciaOficial(descricao2, previdenciaOficial);

            System.out.print("2.2 - Dependente(quantidade): \n");
            qtde = ler.nextInt();
            for(int i = 0; i < qtde; i++){
                System.out.print(" Descrição:\n");
                descricao3 = ler.next();
                System.out.print(" Data de Nascimento(formato xx/yy/zzzz):\n");
                dataNascimento = ler.next();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(dataNascimento);
            }
            System.out.print("2.3 - Pensão alimentícia: \n");
            System.out.print(" Descrição:\n");
            descricao4 = ler.next();
            System.out.print(" Valor da pensão:\n");
            pensao = ler.nextDouble();
            sim.cadastrarPensaoAlimenticia(descricao4, pensao);

            double deducoes = sim.getTotalDeducoes();

            System.out.print("2.5 - O total de deduções é:");
            System.out.print(deducoes);
            System.out.print("\n");

            System.out.print("3 - Base de cálculo (1 - 2): ");
            double baseCalculo = sim.getBaseCalculo();
            System.out.print(baseCalculo);
            System.out.print("\n");

            System.out.print("4 - Imposto Total: ");
            double imposto = sim.calculaIRPF();
            System.out.print(baseCalculo);
            System.out.print("\n");
        }
}

 */


