import java.util.Scanner;

public class SimuladorEmprestimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o valor do empréstimo: R$ ");
        double valorEmprestimo = scanner.nextDouble();
        
        int parcelas;
        do {
            System.out.print("Digite o número de parcelas (6 a 48): ");
            parcelas = scanner.nextInt();
            
            if (parcelas < 6 || parcelas > 48) {
                System.out.println("Número de parcelas inválido. Digite um valor entre 6 e 48.");
            }
        } while (parcelas < 6 || parcelas > 48);
        
        double taxaJuros = 0.03; // 3% ao mês
        double valorParcela = calcularParcela(valorEmprestimo, taxaJuros, parcelas);
        double valorTotal = valorParcela * parcelas;
        
        System.out.println("\nSimulação de Empréstimo para " + nome + ":");
        System.out.printf("Valor do Empréstimo: R$ %.2f%n", valorEmprestimo);
        System.out.printf("Número de Parcelas: %d%n", parcelas);
        System.out.printf("Taxa de Juros Mensal: %.1f%%%n", taxaJuros * 100);
        System.out.printf("Valor da Parcela Mensal: R$ %.2f%n", valorParcela);
        System.out.printf("Valor Total a Pagar: R$ %.2f%n", valorTotal);
        System.out.printf("Juros Totais: R$ %.2f%n", valorTotal - valorEmprestimo);
        
        scanner.close();
    }
    
    private static double calcularParcela(double principal, double taxaJuros, int parcelas) {
        // Fórmula: P = PV * (i * (1 + i)^n) / ((1 + i)^n - 1)
        // Onde: P = valor da parcela, PV = valor presente, i = taxa de juros, n = número de parcelas
        return principal * (taxaJuros * Math.pow(1 + taxaJuros, parcelas)) / (Math.pow(1 + taxaJuros, parcelas) - 1);
    }
} 