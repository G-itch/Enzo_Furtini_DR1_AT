import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SistemaChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mensagens = new String[10];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        System.out.println("=== CHAT TERMINAL ===");
        System.out.println("Digite 'sair' para encerrar a conversa a qualquer momento");
        
        System.out.print("\nDigite o nome do primeiro usuário: ");
        String usuario1 = scanner.nextLine();
        
        System.out.print("Digite o nome do segundo usuário: ");
        String usuario2 = scanner.nextLine();
        
        System.out.println("\nIniciando chat...");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < 10; i++) {
            String usuarioAtual = (i % 2 == 0) ? usuario1 : usuario2;
            String horaAtual = LocalTime.now().format(formatter);
            
            System.out.printf("[%s] %s: ", horaAtual, usuarioAtual);
            String mensagem = scanner.nextLine();
            
            if (mensagem.equalsIgnoreCase("sair")) {
                System.out.println("\nChat encerrado por " + usuarioAtual);
                break;
            }
            
            mensagens[i] = String.format("[%s] %s: %s", horaAtual, usuarioAtual, mensagem);
        }
        
        System.out.println("\n=== HISTÓRICO DA CONVERSA ===");
        for (String mensagem : mensagens) {
            if (mensagem != null) {
                System.out.println(mensagem);
            }
        }
        
        System.out.println("\nChat finalizado. Até a próxima!");
        scanner.close();
    }
} 