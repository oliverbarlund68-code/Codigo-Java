public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTES DA CLASSE VALIDADOR ===\n");

        // 1. Validação de Texto / Nome
        String nomeValido = "Maria Silva";
        String nomeInvalido = "   ";
        System.out.println("Texto '" + nomeValido + "' é válido? " + Validador.ehTextoValido(nomeValido));
        System.out.println("Texto '" + nomeInvalido + "' é válido? " + Validador.ehTextoValido(nomeInvalido));

        // 2. Validação de Idade (intervalo de 18 a 100 anos)
        int idade1 = 25;
        int idade2 = 15;
        System.out.println("\nIdade " + idade1 + " é válida (18-100)? " + Validador.ehIdadeValida(idade1, 18, 100));
        System.out.println("Idade " + idade2 + " é válida (18-100)? " + Validador.ehIdadeValida(idade2, 18, 100));

        // 3. Validação de E-mail
        String emailOk = "contato@empresa.com";
        String emailErrado = "contato.empresa.com";
        System.out.println("\nE-mail '" + emailOk + "' é válido? " + Validador.ehEmailValido(emailOk));
        System.out.println("E-mail '" + emailErrado + "' é válido? " + Validador.ehEmailValido(emailErrado));

        // 4. Validação de CPF
        String cpfOk = "123.456.789-00";
        String cpfSequencia = "111.111.111-11";
        System.out.println("\nCPF '" + cpfOk + "' é válido? " + Validador.ehCpfValido(cpfOk));
        System.out.println("CPF '" + cpfSequencia + "' é válido? " + Validador.ehCpfValido(cpfSequencia));
    }
}