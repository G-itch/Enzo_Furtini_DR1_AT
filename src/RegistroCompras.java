import java.io.*;
import java.util.Scanner;

public class RegistroCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try (FileWriter writer = new FileWriter("compras.txt")) {
            // Registrando 3 compras
            for (int i = 1; i <= 3; i++) {
                System.out.println("\nRegistro da Compra " + i);
                System.out.print("Digite o nome do produto: ");
                String produto = scanner.nextLine();
                
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                
                System.out.print("Digite o preço unitário: R$ ");
                double precoUnitario = scanner.nextDouble();
                
                // Calcula o total da compra
                double total = quantidade * precoUnitario;
                
                // Escreve no arquivo
                writer.write(String.format("Compra %d:%n", i));
                writer.write("Produto: " + produto + "\n");
                writer.write("Quantidade: " + quantidade + "\n");
                writer.write(String.format("Preço Unitário: R$ %.2f%n", precoUnitario));
                writer.write(String.format("Total: R$ %.2f%n", total));
                writer.write("------------------------\n");
                
                // Limpa o buffer do scanner
                scanner.nextLine();
            }
            
            System.out.println("\nCompras registradas com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        
        // Lê e exibe as compras registradas
        System.out.println("\nLendo as compras registradas:");
        try (BufferedReader reader = new BufferedReader(new FileReader("compras.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        scanner.close();
    }
} 