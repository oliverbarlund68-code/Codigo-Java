package AppSobrecarga;

public class Quadrado {
    private double lado;

    // Construtor com 1 parâmetro
    public Quadrado(double lado) {
        this.lado = lado;
    }

    // Cálculo da área: lado * lado
    public double area() {
        return lado * lado;
    }

    // Exibição dos dados do quadrado
    public void exibe() {
        System.out.println("A área do quadrado de lado = " + lado + " vale " + area());
    }
}