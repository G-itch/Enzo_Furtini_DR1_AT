public class ProgramaCGI {
    public static void main(String[] args) {
        // Imprime os headers HTTP
        System.out.println("Content-Type: text/html");
        System.out.println(); // Linha em branco entre headers e conteúdo
        
        // Imprime o conteúdo HTML
        System.out.println("<html>");
        System.out.println("<head><title>Saudação CGI</title></head>");
        System.out.println("<body>");
        System.out.println("<h1>Olá, Terráqueos!</h1>");
        System.out.println("</body>");
        System.out.println("</html>");
    }
} 