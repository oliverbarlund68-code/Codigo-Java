// Classe Exemplo1Static: ponto de entrada para execução do programa
public class Exemplo1_Static{
    public static void main(String[] args) {
        // Consulta o membro estático antes de criar qualquer objeto
        System.out.println("Total inicial de fichas: " + FichaPessoal.getTotalFichasCriadas());

        // Criando o primeiro objeto
        FichaPessoal ficha1 = new FichaPessoal("Ana Souza", 28, "123.456.789-00");
        ficha1.exibirFicha();

        // O atributo estático agora refletirá 1 ficha criada
        System.out.println("Total de fichas até agora: " + FichaPessoal.getTotalFichasCriadas());

        // Criando o segundo objeto
        FichaPessoal ficha2 = new FichaPessoal("Carlos Eduardo", 35, "987.654.321-11");
        ficha2.exibirFicha();

        // O atributo estático é compartilhado e passa a valer 2
        System.out.println("Total final de fichas criadas: " + FichaPessoal.getTotalFichasCriadas());
    }
}