package AppSobrecarga;

public class Circulo {
    private double raio;
    private double xcentro;
    private double ycentro;

    // Construtor com 3 parâmetros
    public Circulo(double raio, double xcentro, double ycentro) {
        this.raio = raio;
        this.xcentro = xcentro;
        this.ycentro = ycentro;
    }

    // Construtor com 2 parâmetros (zera o atributo raio)
    public Circulo(double xcentro, double ycentro) {
        this.raio = 0;
        this.xcentro = xcentro;
        this.ycentro = ycentro;
    }

    // Método area() usando o raio do atributo
    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    // Sobrecarga do método area() recebendo raio como parâmetro
    public double area(double raio) {
        return Math.PI * Math.pow(raio, 2);
    }

    // Método exibe() usando os atributos da classe
    public void exibe() {
        System.out.println("A área do círculo de centro (" + xcentro + " , " + ycentro + ") e de raio = " + raio + " vale " + area());
    }

    // Sobrecarga do método exibe() recebendo raio como parâmetro
    public void exibe(double raio) {
        System.out.println("A área do círculo de centro (" + xcentro + " , " + ycentro + ") e de raio = " + raio + " vale " + area(raio));
    }
}