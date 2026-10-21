public class Validador {

    // Construtor privado para evitar a instanciação da classe utilitária
    private Validador() {}

    // Valida se a String não é nula nem composta apenas por espaços
    public static boolean ehTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    // Valida se a idade está dentro de um intervalo (mínimo e máximo inclusive)
    public static boolean ehIdadeValida(int idade, int min, int max) {
        return idade >= min && idade <= max;
    }

    // Valida se o e-mail possui um formato básico aceitável usando Expressão Regular (Regex)
    public static boolean ehEmailValido(String email) {
        if (!ehTextoValido(email)) return false;
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }

    // Valida se o CPF possui 11 dígitos numéricos e não é uma sequência repetida
    public static boolean ehCpfValido(String cpf) {
        if (!ehTextoValido(cpf)) return false;
        
        // Remove caracteres não numéricos (pontos e traços)
        String cpfLimpo = cpf.replaceAll("\\D", "");

        // Verifica se possui 11 dígitos e se não é uma sequência idêntica (ex: 111.111.111-11)
        return cpfLimpo.length() == 11 && !cpfLimpo.matches("(\\d)\\1{10}");
    }
}