import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String titular;
    private double saldo;
    private List<String> historico;
    private DateTimeFormatter formatter;
    
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            String operacao = String.format("[%s] Depósito: R$ %.2f - Saldo: R$ %.2f",
                LocalDateTime.now().format(formatter), valor, saldo);
            historico.add(operacao);
            System.out.println(operacao);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }
    
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo) {
                saldo -= valor;
                String operacao = String.format("[%s] Saque: R$ %.2f - Saldo: R$ %.2f",
                    LocalDateTime.now().format(formatter), valor, saldo);
                historico.add(operacao);
                System.out.println(operacao);
            } else {
                System.out.println("Erro: Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
        }
    }
    
    public void exibirSaldo() {
        System.out.printf("\n=== EXTRATO BANCÁRIO ===%n");
        System.out.printf("Titular: %s%n", titular);
        System.out.printf("Data/Hora: %s%n", LocalDateTime.now().format(formatter));
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("------------------------");
    }
    
    public void exibirHistorico() {
        System.out.println("\n=== HISTÓRICO DE OPERAÇÕES ===");
        for (String operacao : historico) {
            System.out.println(operacao);
        }
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA BANCÁRIO ===");
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();
        
        System.out.print("Digite o saldo inicial: R$ ");
        double saldoInicial = scanner.nextDouble();
        
        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);
        
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir Saldo");
            System.out.println("4 - Exibir Histórico");
            System.out.println("5 - Sair");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 5) {
                break;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor do saque: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                    
                case 3:
                    conta.exibirSaldo();
                    break;
                    
                case 4:
                    conta.exibirHistorico();
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        System.out.println("\nObrigado por utilizar nossos serviços!");
        scanner.close();
    }
} 