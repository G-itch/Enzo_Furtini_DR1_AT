public class Funcionario {
    protected String nome;
    protected double salarioBase;
    
    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
    
    public double calcularSalario() {
        return salarioBase;
    }
    
    public void exibirDados() {
        System.out.println("\nDados do Funcionário:");
        System.out.println("Nome: " + nome);
        System.out.printf("Salário Base: R$ %.2f%n", salarioBase);
        System.out.printf("Salário Final: R$ %.2f%n", calcularSalario());
    }
}

class Gerente extends Funcionario {
    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase * 1.20; // 20% de bônus
    }
}

class Estagiario extends Funcionario {
    public Estagiario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase * 0.90; // 10% de desconto
    }
}

class TesteFuncionarios {
    public static void main(String[] args) {
        // Criando um gerente e um estagiário
        Gerente gerente = new Gerente("João Silva", 5000.0);
        Estagiario estagiario = new Estagiario("Maria Santos", 2000.0);
        
        // Exibindo os dados
        gerente.exibirDados();
        estagiario.exibirDados();
    }
} 