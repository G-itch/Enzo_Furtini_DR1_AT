import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SimuladorLoteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("=== SIMULADOR DE LOTERIA ===");
        System.out.println("Bem-vindo ao jogo de números da sorte!");
        
        // Gera 6 números aleatórios
        List<Integer> numerosSorteados = new ArrayList<>();
        while (numerosSorteados.size() < 6) {
            int numero = random.nextInt(60) + 1;
            if (!numerosSorteados.contains(numero)) {
                numerosSorteados.add(numero);
            }
        }
        Collections.sort(numerosSorteados);
        
        // Solicita os números do usuário
        List<Integer> numerosApostados = new ArrayList<>();
        System.out.println("\nDigite 6 números diferentes entre 1 e 60:");
        
        while (numerosApostados.size() < 6) {
            System.out.printf("Digite o %dº número: ", numerosApostados.size() + 1);
            int numero = scanner.nextInt();
            
            if (numero < 1 || numero > 60) {
                System.out.println("Número inválido! Digite um número entre 1 e 60.");
                continue;
            }
            
            if (numerosApostados.contains(numero)) {
                System.out.println("Número já escolhido! Digite um número diferente.");
                continue;
            }
            
            numerosApostados.add(numero);
        }
        Collections.sort(numerosApostados);
        
        // Conta os acertos
        List<Integer> acertos = new ArrayList<>();
        for (int numero : numerosApostados) {
            if (numerosSorteados.contains(numero)) {
                acertos.add(numero);
            }
        }
        
        // Exibe os resultados
        System.out.println("\n=== RESULTADO DO SORTEIO ===");
        System.out.println("Números sorteados: " + numerosSorteados);
        System.out.println("Seus números: " + numerosApostados);
        System.out.println("Números acertados: " + acertos);
        System.out.println("Total de acertos: " + acertos.size());
        
        // Exibe mensagem baseada no número de acertos
        switch (acertos.size()) {
            case 6:
                System.out.println("\nPARABÉNS! Você acertou todos os números!");
                System.out.println("Você é um verdadeiro sortudo!");
                break;
            case 5:
                System.out.println("\nExcelente! Você acertou 5 números!");
                System.out.println("Foi muito próximo de ganhar!");
                break;
            case 4:
                System.out.println("\nMuito bom! Você acertou 4 números!");
                System.out.println("Continue tentando!");
                break;
            case 3:
                System.out.println("\nBom! Você acertou 3 números!");
                System.out.println("Ainda tem chance!");
                break;
            case 2:
                System.out.println("\nVocê acertou 2 números.");
                System.out.println("Não desista, tente novamente!");
                break;
            case 1:
                System.out.println("\nVocê acertou apenas 1 número.");
                System.out.println("A sorte está próxima!");
                break;
            default:
                System.out.println("\nNenhum número acertado.");
                System.out.println("Não foi dessa vez, mas continue tentando!");
        }
        
        scanner.close();
    }
} 