package Avançado;
public import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ClienteViaCep {
    // HttpClient reutilizável (padrão de projeto recomendado no mercado)
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5)) // Timeout para não travar a aplicação
            .build();

    public static void main(String[] args) {
        String cep = "01001000"; // Exemplo: CEP da Praça da Sé - SP
        String url = "https://viacep.com.br" + cep + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // Método HTTP
                .header("Accept", "application/json")
                .build();

        // Envio assíncrono (não bloqueia a aplicação enquanto espera a internet)
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(jsonResposta -> {
                    System.out.println("--- Resposta da API de CEP recebida ---");
                    System.out.println(jsonResposta);
                })
                .join(); // Aguarda a conclusão apenas para exibição no console
    }
}
