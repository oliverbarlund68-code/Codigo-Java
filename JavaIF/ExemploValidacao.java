import java.util.Scanner;

public class ExemploValidacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO COM VALIDAÇÃO DE DADOS ===");

        // 1. Validação de Nome
        String nome;
        do {
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();
            if (!Validador.ehTextoValido(nome)) {
                System.out.println("[ERRO] O nome não pode ser vazio.");
            }
        } while (!Validador.ehTextoValido(nome));

        // 2. Validação de Idade
        int idade = 0;
        boolean idadeValida = false;
        do {
            System.out.print("Digite a idade (18 a 100 anos): ");
            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner
                
                if (Validador.ehIdadeValida(idade, 18, 100)) {
                    idadeValida = true;
                } else {
                    System.out.println("[ERRO] A idade deve estar entre 18 e 100 anos.");
                }
            } else {
                System.out.println("[ERRO] Digite um número inteiro válido.");
                scanner.nextLine(); // Descarta a entrada inválida
            }
        } while (!idadeValida);

        // 3. Validação de E-mail
        String email;
        do {
            System.out.print("Digite o e-mail: ");
            email = scanner.nextLine();
            if (!Validador.ehEmailValido(email)) {
                System.out.println("[ERRO] Formato de e-mail inválido (Ex: usuario@dominio.com).");
            }
        } while (!Validador.ehEmailValido(email));

        // 4. Validação de CPF
        String cpf;
        do {
            System.out.print("Digite o CPF (11 dígitos): ");
            cpf = scanner.nextLine();
            if (!Validador.ehCpfValido(cpf)) {
                System.out.println("[ERRO] CPF inválido. Certifique-se de digitar 11 números válidos.");
            }
        } while (!Validador.ehCpfValido(cpf));

        // Exibição dos dados após validação
        System.out.println("\n----------------------------------");
        System.out.println("CADASTRO REALIZADO COM SUCESSO!");
        System.out.println("Nome:  " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Email: " + email);
        System.out.println("CPF:   " + cpf.replaceAll("\\D", ""));
        System.out.println("----------------------------------");

        scanner.close();
    }
}