package AppSobrecarga;

public class Triangulo {
    private double base;
    private double altura;

    // Construtor com 2 parâmetros
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Cálculo da área: (base * altura) / 2
    public double area() {
        return (base * altura) / 2.0;
    }

    // Exibição dos dados do triângulo
    public void exibe() {
        System.out.println("A área do triângulo de base = " + base + " e de altura = " + altura + " vale " + area());
    }
}