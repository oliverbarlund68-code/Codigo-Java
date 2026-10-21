package academia;



import java.util.Random;

public class utilitaria {

    public static String geraCodigo() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
       
        for (int i = 0; i < 3; i++) {
            char letra = (char) ('a' + random.nextInt(26));
            sb.append(letra);
        }
       
        for (int i = 0; i < 2; i++) {
            int digito = random.nextInt(10);
            sb.append(digito);
        }
       
        return sb.toString();
    }

    public static boolean validaTel(String telefone) {
        if (telefone == null) {
            return false;
        }

        if (!telefone.matches("^\\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            return false;
        }

        String digitos = telefone.replaceAll("\\D", "");
       
        if (digitos.length() != 11) {
            return false;
        }

        char d1 = digitos.charAt(2); 
        char d2 = digitos.charAt(3); 
        char d3 = digitos.charAt(4); 
        char d4 = digitos.charAt(5); 

        if (d1 != '3') {
            return false;
        }

        if (d2 < '1' || d2 > '9' || d2 == '6') {
            return false;
        }

        if (d3 != '9') {
            return false;
        }

        if (d4 != '8' && d4 != '9') {
            return false;
        }

        return true;
    }
}
