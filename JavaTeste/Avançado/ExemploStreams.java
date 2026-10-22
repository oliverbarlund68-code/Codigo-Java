package Avançado;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pedido {
    private String id;
    private double valor;
    private String categoria;

    public Pedido(String id, double valor, String categoria) {
        this.id = id;
        this.valor = valor;
        this.categoria = categoria;
    }

    public double getValor() { return valor; }
    public String getCategoria() { return categoria; }
    @Override
    public String toString() { return id + " (R$" + valor + ")"; }
}

public class ExemploStreams Avançado {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("P1", 150.0, "Eletrônicos"),
            new Pedido("P2", 45.0, "Livros"),
            new Pedido("P3", 1200.0, "Eletrônicos"),
            new Pedido("P4", 89.90, "Livros"),
            new Pedido("P5", 350.0, "Moda")
        );

        // 1. Filtrar pedidos caros (> R$100) de Eletrônicos e obter apenas os IDs/valores
        System.out.println("--- Eletrônicos Premium ---");
        pedidos.stream()
            .filter(p -> p.getCategoria().equals("Eletrônicos"))
            .filter(p -> p.getValor() > 200.0)
            .forEach(System.out.println);

        // 2. Agrupar os pedidos por categoria e calcular o faturamento total de cada uma
        Map<String, Double> faturamentoPorCategoria = pedidos.stream()
            .collect(Collectors.groupingBy(
                Pedido::getCategoria,
                Collectors.summingDouble(Pedido::getValor)
            ));

        System.out.println("\n--- Faturamento por Categoria ---");
        faturamentoPorCategoria.forEach((categoria, total) -> 
            System.out.printf("%s: R$ %.2f%n", categoria, total)
        );
    }
}
