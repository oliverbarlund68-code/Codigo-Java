package aplicacao;


public class Aluno {
    private String codigo;
    private String nome;
    private String telefone;
    private int categoria;
    int acessos;

    
    public Aluno(String codigo, String nome, String telefone, int categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = categoria;
        this.acessos = 0;
    }

   
    public Aluno(String codigo, String nome, String telefone, int categoria, int acessos) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = categoria;
        this.acessos = acessos;
    }

    public String exibe() {
        return "Código: " + codigo + "\n" +
               "Nome: " + nome + "\n" +
               "Telefone: " + telefone + "\n" +
               "Categoria: " + categoria;
    }

    public String exibe(int flag) {
        return "Código: " + codigo + "\n" +
               "Nome: " + nome + "\n" +
               "Telefone: " + telefone + " Categoria: " + categoria + "\n" +
               "Acessos: " + acessos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }
}
