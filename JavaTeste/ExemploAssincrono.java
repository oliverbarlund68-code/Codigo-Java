import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ExemploAssincrono {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando processamento no Thread: " + Thread.currentThread().getName());

        // Tarefa 1: Buscar dados do usuário (Assíncrono)
        CompletableFuture<String> buscarUsuario = CompletableFuture.supplyAsync(() -> {
            simularTempoPreenchimento(2); // Simula delay de 2 segundos
            return "João Silva";
        });

        // Tarefa 2: Buscar histórico de compras (Assíncrono)
        CompletableFuture<Integer> buscarCompras = CompletableFuture.supplyAsync(() -> {
            simularTempoPreenchimento(1); // Simula delay de 1 segundo
            return 15;
        });

        // Combinar os resultados de ambas as tarefas quando terminarem
        CompletableFuture<String> resultadoFinal = buscarUsuario
            .thenCombine(buscarCompras, (usuario, compras) -> 
                "O usuário " + usuario + " possui " + compras + " compras no histórico."
            );

        // Aguarda e exibe o resultado final
        System.out.println("Processando outras coisas enquanto as tarefas rodam...");
        System.out.println("\nResultado final recebido: " + resultadoFinal.get());
    }

    private static void simularTempoPreenchimento(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
