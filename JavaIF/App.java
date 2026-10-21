import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static double leCoordenada(String nome) {
        System.out.print("Digite o valor de " + nome + ": ");
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        char opcao;

        do {
            System.out.println("\n--- Cadastro de Reta (1º Quadrante) ---");
            double x1 = leCoordenada("x1");
            double y1 = leCoordenada("y1");
            double x2 = leCoordenada("x2");
            double y2 = leCoordenada("y2");

            if (Retas.valida(x1, y1, x2, y2)) {
                Retas reta = new Retas(x1, y1, x2, y2);
                System.out.println("\n" + reta.exibe());
                System.out.println("Total de retas registradas: " + Retas.getCont());
            } else {
                System.out.println("\n[ERRO] Coordenadas inválidas. Valores precisam ser maiores ou iguais a zero.");
            }

            System.out.print("\nDeseja inserir outra reta? (S/N): ");
            opcao = scanner.next().toUpperCase().charAt(0);

        } while (opcao == 'S');

        System.out.println("\nPrograma encerrado. Total acumulado: " + Retas.getCont());
    }
}