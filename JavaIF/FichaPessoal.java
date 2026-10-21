// Classe FichaPessoal: demonstra atributos de instância e um atributo/método static
public class FichaPessoal {
    // Atributos de instância (únicos para cada objeto criado)
    private String nome;
    private int idade;
    private String cpf;

    // Atributo estático (compartilhado por TODAS as instâncias da classe)
    private static int totalFichasCriadas = 0;

    // Construtor
    public FichaPessoal(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        // Incrementa o contador global de fichas toda vez que o construtor é chamado
        totalFichasCriadas++;
    }

    // Método de instância: acessa os dados específicos do objeto atual
    public void exibirFicha() {
        System.out.println("-------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
        System.out.println("CPF: " + this.cpf);
    }

    // Método estático: pode ser chamado direto pela Classe, sem precisar de instância
    public static int getTotalFichasCriadas() {
        return totalFichasCriadas;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}