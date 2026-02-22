import java.sql.SQLOutput;
import java.util.*;

public class Pilha_INT {

//definição do NO

    private static class NO{

        public  int dado;

        public  NO prox;

    }



//definição do retornos dos métodos POP e TOP

    private static class Retorno{

        public  int item;

        public  boolean ok;

    }

//definição do ponteiro topo da pilha

    private static NO topo;



    public void INIT() {

        topo = null;

    }



    public boolean IsEmpty() {

        return topo == null;

    }



    public Retorno POP() {

        Retorno saida = new Retorno();

        if(!IsEmpty()) {

            saida.item = topo.dado;

            topo = topo.prox;

            saida.ok = true;

        }

        else

            saida.ok = false;

        return saida;

    }


//Função main que exemplifica a utilização das operações sobre pilha

    public static void main(String[] args) {
        Pilha_INT pilha = new Pilha_INT();
        Scanner scanner = new Scanner(System.in);
        Retorno ret = new Retorno();
        boolean quer = true;
        while (quer) {

            System.out.println("Digite o número em decimal: ");
            int numInit = scanner.nextInt();
            int numBin = numInit;
            int num = numInit;

            do {
                numBin = num % 2;
                NO novo = new NO();

                novo.dado = numBin;
                novo.prox = topo;
                topo = novo;
                num = num / 2;

            } while (num != 0);
            System.out.println("Você digitou " + numInit);
            System.out.println("Esse número em binário é: ");

            do {
                ret = pilha.POP();
                if (ret.ok) {
                    System.out.print(ret.item + " ");
                }
            } while (ret.ok);
            System.out.println(" ");
            System.out.println("Você quer converter mais um número? [S/N]");
            String convert = scanner.next();
            if (convert.equals("N") || convert.equals("n")) {
                quer = false;
                System.out.println("Obrigado por usar meu conversor S2");
            }
        }
    }

}