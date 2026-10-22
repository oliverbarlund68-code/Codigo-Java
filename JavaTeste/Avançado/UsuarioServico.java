package Avançado;
import java.time.LocalDateTime;

// Classe padrão de resposta de erro no mercado
class ErroResposta API {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String erro;
    private final String mensagem;

    public ErroResposta(int status, String erro, String mensagem) {
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
    }
    // Getters omitidos para brevidade
}

// Simulação de uma classe de serviço capturando um erro comum de mercado
public class UsuarioServico {
    public UsuarioDTO buscarPorId(Long id) {
        try {
            // Simula uma busca no banco que não encontrou nada
            throw new RuntimeException("Registro não encontrado no banco de dados.");
        } catch (Exception ex) {
            // No mercado, usamos frameworks como Logback ou Log4j aqui
            System.err.println("LOG [ERROR]: Falha ao buscar usuário " + id + ". Motivo: " + ex.getMessage());
            
            // Lança uma exceção customizada que a API vai capturar e formatar
            throw new EntidadeNaoEncontradaException(ex.getMessage());
        }
    }
}

class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String msg) { super(msg); }
}
