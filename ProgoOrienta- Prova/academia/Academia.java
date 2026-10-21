package academia;

public class Academia {
    private int alunos;
    static int acessos;
    public class academia {
        private static int acessos;
    
        public static int getAcessos() {
            return acessos;
        }
    
        public static void incrementarAcessos() {
            acessos++;
        }
    }

    public Academia() {
        this.alunos = 0;
    }

    public void atualiza(int quantidade) {
        this.alunos += quantidade;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }
}