import java.util.Scanner;

public class MenuExercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n=== MENU DE EXERCÍCIOS JAVA ===");
            System.out.println("1.  OlaMundo - Primeiro Programa");
            System.out.println("2.  ValidadorSenha - Sistema de Validação");
            System.out.println("3.  CalculadoraImpostos - Cálculo de IR");
            System.out.println("4.  SimuladorEmprestimo - Simulação Financeira");
            System.out.println("5.  ProgramaCGI - Simulador Web");
            System.out.println("6.  Veiculo - Gestão de Frota");
            System.out.println("7.  Aluno - Sistema Acadêmico");
            System.out.println("8.  Funcionario - Gestão de RH");
            System.out.println("9.  ContaBancaria - Sistema Bancário");
            System.out.println("10. RegistroCompras - Controle de Vendas");
            System.out.println("11. SimuladorLoteria - Jogo de Números");
            System.out.println("12. SistemaChat - Chat Terminal");
            System.out.println("0.  Sair");
            
            System.out.print("\nEscolha um exercício para executar: ");
            opcao = scanner.nextInt();
            
            if (opcao == 0) {
                System.out.println("\nPrograma finalizado. Até logo!");
                break;
            }
            
            System.out.println("\nExecutando exercício " + opcao + "...\n");
            
            switch (opcao) {
                case 1:
                    OlaMundo.main(args);
                    break;
                case 2:
                    ValidadorSenha.main(args);
                    break;
                case 3:
                    CalculadoraImpostos.main(args);
                    break;
                case 4:
                    SimuladorEmprestimo.main(args);
                    break;
                case 5:
                    ProgramaCGI.main(args);
                    break;
                case 6:
                    Veiculo.main(args);
                    break;
                case 7:
                    Aluno.main(args);
                    break;
                case 8:
                    TesteFuncionarios.main(args);
                    break;
                case 9:
                    ContaBancaria.main(args);
                    break;
                case 10:
                    RegistroCompras.main(args);
                    break;
                case 11:
                    SimuladorLoteria.main(args);
                    break;
                case 12:
                    SistemaChat.main(args);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine(); // Limpa o buffer
            scanner.nextLine();
            
        } while (opcao != 0);
        
        scanner.close();
    }
} 