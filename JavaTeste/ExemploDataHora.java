import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ExemploDataHora {
    public static void main(String[] args) {
        
        // 1. Captura a data e hora atual do sistema local
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("1. Data/Hora bruta (padrão ISO): " + agora);

        // 2. Formata a data e hora no padrão brasileiro
        DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = agora.format(formatadorBR);
        System.out.println("2. Data/Hora formatada (BR): " + dataFormatada);

        // 3. Captura com Fuso Horário específico (Ex: São Paulo)
        ZonedDateTime agoraComFuso = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatadorComFuso = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss zzzz");
        System.out.println("3. Com Fuso Horário: " + agoraComFuso.format(formatadorComFuso));

        // 4. Manipulação de datas: Adicionando tempo ao momento atual
        LocalDateTime futuro = agora.plusDays(7).plusHours(3);
        System.out.println("4. Daqui a 7 dias e 3 horas será: " + futuro.format(formatadorBR));

        // 5. Comparação de datas (Se o momento atual é antes ou depois do futuro criado)
        if (agora.isBefore(futuro)) {
            System.out.println("5. Verificação: O momento 'agora' vem antes da data futura.");
        }
    }
}
