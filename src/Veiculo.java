public class Veiculo {
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double quilometragem;
    
    public Veiculo(String placa, String modelo, int anoFabricacao, double quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.quilometragem = quilometragem;
    }
    
    public void exibirDetalhes() {
        System.out.println("\nDetalhes do Veículo:");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabricação: " + anoFabricacao);
        System.out.printf("Quilometragem: %.2f km%n", quilometragem);
    }
    
    public void registrarViagem(double km) {
        quilometragem += km;
        System.out.printf("Viagem registrada! Nova quilometragem: %.2f km%n", quilometragem);
    }
    
    public static void main(String[] args) {
        // Criando dois veículos
        Veiculo carro1 = new Veiculo("ABC1234", "Fusca", 1970, 150000.0);
        Veiculo carro2 = new Veiculo("XYZ5678", "Gol", 2020, 50000.0);
        
        // Exibindo detalhes iniciais
        carro1.exibirDetalhes();
        carro2.exibirDetalhes();
        
        // Registrando viagens
        carro1.registrarViagem(100.5);
        carro2.registrarViagem(50.0);
        
        // Exibindo detalhes após as viagens
        carro1.exibirDetalhes();
        carro2.exibirDetalhes();
    }
} 