import java.util.Scanner;

public class ValidadorSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String senha;
        boolean senhaValida = false;

        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();

        while (!senhaValida) {
            System.out.print("Digite uma senha (mínimo 8 caracteres, uma letra maiúscula, um número e um caractere especial): ");
            senha = scanner.nextLine();

            if (senha.length() < 8) {
                System.out.println("Erro: A senha deve ter no mínimo 8 caracteres.");
                continue;
            }

            boolean temMaiuscula = false;
            boolean temNumero = false;
            boolean temEspecial = false;

            for (char c : senha.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    temMaiuscula = true;
                } else if (Character.isDigit(c)) {
                    temNumero = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    temEspecial = true;
                }
            }

            if (!temMaiuscula) {
                System.out.println("Erro: A senha deve conter pelo menos uma letra maiúscula.");
                continue;
            }
            if (!temNumero) {
                System.out.println("Erro: A senha deve conter pelo menos um número.");
                continue;
            }
            if (!temEspecial) {
                System.out.println("Erro: A senha deve conter pelo menos um caractere especial.");
                continue;
            }

            senhaValida = true;
            System.out.println("Senha válida! Bem-vindo, " + nome + "!");
        }

        scanner.close();
    }
} 