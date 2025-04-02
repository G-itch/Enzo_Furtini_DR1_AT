import java.util.Scanner;

public class CalculadoraImpostos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite seu salário mensal: R$ ");
        double salarioMensal = scanner.nextDouble();
        
        double salarioAnual = salarioMensal * 12;
        double imposto = 0;
        double aliquota = 0;
        
        if (salarioAnual <= 22847.76) {
            imposto = 0;
            aliquota = 0;
        } else if (salarioAnual <= 33919.80) {
            imposto = salarioAnual * 0.075;
            aliquota = 7.5;
        } else if (salarioAnual <= 45012.60) {
            imposto = salarioAnual * 0.15;
            aliquota = 15.0;
        } else {
            imposto = salarioAnual * 0.275;
            aliquota = 27.5;
        }
        
        double salarioLiquido = salarioAnual - imposto;
        
        System.out.println("\nResultado para " + nome + ":");
        System.out.printf("Salário Anual: R$ %.2f%n", salarioAnual);
        System.out.printf("Alíquota: %.1f%%%n", aliquota);
        System.out.printf("Imposto a pagar: R$ %.2f%n", imposto);
        System.out.printf("Salário Líquido Anual: R$ %.2f%n", salarioLiquido);
        System.out.printf("Salário Líquido Mensal: R$ %.2f%n", salarioLiquido / 12);
        
        scanner.close();
    }
} 