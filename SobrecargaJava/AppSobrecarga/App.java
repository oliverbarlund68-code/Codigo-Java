package AppSobrecarga;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\nFIGURAS GEOMÉTRICAS");
            System.out.println("1 – Círculo");
            System.out.println("2 – Triângulo");
            System.out.println("3 – Quadrado");
            System.out.println("4 – SAIR");
            System.out.print("DIGITE A OPÇÃO: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o centro X: ");
                    double x = scanner.nextDouble();
                    System.out.print("Digite o centro Y: ");
                    double y = scanner.nextDouble();
                    System.out.print("Digite o raio: ");
                    double r = scanner.nextDouble();

                    // Instanciação e chamada do método exibe()
                    Circulo circulo = new Circulo(r, x, y);
                    circulo.exibe();
                    break;

                case 2:
                    System.out.print("Digite a base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Digite a altura: ");
                    double altura = scanner.nextDouble();

                    Triangulo triangulo = new Triangulo(base, altura);
                    triangulo.exibe();
                    break;

                case 3:
                    System.out.print("Digite o lado: ");
                    double lado = scanner.nextDouble();

                    Quadrado quadrado = new Quadrado(lado);
                    quadrado.exibe();
                    break;

                case 4:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}