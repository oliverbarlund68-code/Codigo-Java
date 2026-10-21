package aplicacao;

import academia.Academia;
import academia.utilitaria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // Lista pré-definida contendo usuário e senha dos 3 funcionários
    private static final String[][] FUNCIONARIOS = {
        {"admin1", "123"},
        {"admin2", "456"},
        {"admin3", "789"}
    };

    private static List<Aluno> listaAlunos = new ArrayList<>();
    private static Academia academia = new Academia();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao = 0;
        do {
            System.out.println("\nMENU");
            System.out.println("1- ACADEMIA");
            System.out.println("2- PERSONAL");
            System.out.println("3- SAIR");
            System.out.print("DIGITE A OPÇÃO: ");
           
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    if (autenticaFuncionario()) {
                        subMenuAcademia();
                    }
                    break;
                case 2:
                    if (autenticaFuncionario()) {
                        opcaoPersonal();
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private static boolean autenticaFuncionario() {
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("\nUsuário: ");
            String user = scanner.nextLine();
            System.out.print("Senha: ");
            String pass = scanner.nextLine();

            for (String[] f : FUNCIONARIOS) {
                if (f[0].equals(user) && f[1].equals(pass)) {
                    return true;
                }
            }
            System.out.println("Usuário ou senha incorretos. Tentativa " + tentativa + " de 3.");
        }
        System.out.println("Número de tentativas esgotou!");
        System.exit(0);
        return false;
    }

    private static void subMenuAcademia() {
        int opcao = 0;
        do {
            System.out.println("\nSubMENU");
            System.out.println("1- CADASTRO");
            System.out.println("2- RELATÓRIO");
            System.out.println("3- VOLTAR");
            System.out.print("DIGITE A OPÇÃO: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    exibirRelatorio();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private static void cadastrarAluno() {
        String nome = "";
        boolean nomeValido = false;

        while (!nomeValido) {
            System.out.print("Informe o nome do aluno: ");
            nome = scanner.nextLine().trim();

            boolean duplicado = false;
            for (Aluno a : listaAlunos) {
                if (a.getNome().equalsIgnoreCase(nome)) {
                    duplicado = true;
                    break;
                }
            }

            if (duplicado) {
                System.out.println("Erro: Nome já cadastrado. Repita a leitura.");
            } else {
                nomeValido = true;
            }
        }

        System.out.print("Informe o telefone no formato (xx) xxxxx-xxxx: ");
        String telefone = scanner.nextLine().trim();

        if (!utilitaria.validaTel(telefone)) {
            System.out.println("Violação: Telefone inválido!");
            return;
        }

        System.out.print("Informe a categoria (1, 2 ou 3): ");
        int categoria = 0;
        if (scanner.hasNextInt()) {
            categoria = scanner.nextInt();
            scanner.nextLine();
        } else {
            scanner.nextLine();
            System.out.println("Violação: Categoria inválida!");
            return;
        }

        if (categoria < 1 || categoria > 3) {
            System.out.println("Violação: Categoria deve ser 1, 2 ou 3!");
            return;
        }

        String codigo = utilitaria.geraCodigo();
        Aluno novoAluno;

        if (categoria == 1) {
            novoAluno = new Aluno(codigo, nome, telefone, categoria);
        } else {
            novoAluno = new Aluno(codigo, nome, telefone, categoria, 0);
        }

        listaAlunos.add(novoAluno);
        academia.atualiza(1);
        System.out.println("Aluno cadastrado com sucesso! Código gerado: " + codigo);
    }

    private static void exibirRelatorio() {
        System.out.println("\nRELATÓRIO");
        for (Aluno a : listaAlunos) {
            if (a.getCategoria() == 1) {
                System.out.println(a.exibe());
            } else {
                System.out.println(a.exibe(1));
            }
            System.out.println();
        }
        System.out.println("TOTAL DE ALUNOS = " + academia.getAlunos());
        System.out.println("ACESSOS = " + academia.getAcessos());
    }

    private static void opcaoPersonal(Scanner scanner, List<Aluno> listaAlunos, Academia academia) {
        if (academia.getAcessos() >= 5) {
            System.out.println("Impossibilidade da aula: número máximo de aulas com personal atingido no mês.");
            return;
        }
    
        System.out.print("Digite o código do aluno: ");
        String codigo = scanner.nextLine().trim();
        

        Aluno alunoEncontrado = null;
        for (Aluno a : listaAlunos) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                alunoEncontrado = a;
                break;
            }
        }

        if (alunoEncontrado == null) {
            System.out.println("Aluno não foi cadastrado ainda.");
            return;
        }

        int cat = alunoEncontrado.getCategoria();
        int acessosAluno = alunoEncontrado.getAcessos();

        if (cat == 1) {
            System.out.println("Ele não poderá ter mais aula gratuita com o personal.");
            return;
        } else if (cat == 2 && acessosAluno >= 1) {
            System.out.println("Ele não poderá ter mais aula gratuita com o personal.");
            return;
        } else if (cat == 3 && acessosAluno >= 2) {
            System.out.println("Ele não poderá ter mais aula gratuita com o personal.");
            return;
        }

        alunoEncontrado.setAcessos(acessosAluno + 1);
        Academia.acessos++;
        System.out.println("Acesso ao personal contabilizado com sucesso!");
    }
}