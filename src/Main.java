import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TorreDeHanoi jogo = new TorreDeHanoi(3);
        Scanner scanner = new Scanner(System.in);
        boolean fina = false;

        jogo.Comecar();
        System.out.println("Jogo de torre de Hanoi");
        System.out.println("Pilha inicial:");
        jogo.p1.imprime();
        System.out.println("Opcao 1 = Iniciar jogo normal");
        System.out.println("Opcao 2 = Solucao Automatica");
        int start = scanner.nextInt();

        switch(start){
            case 1:
                while(!fina){
                 System.out.println("Opcao 1 = Trocar");
                 System.out.println("Opcao 2 = Sair");
                 int escolha = scanner.nextInt();
                 switch(escolha){
                     case 1:
                         System.out.println("Pilha 1: ");
                         jogo.p1.imprime();
                         System.out.println("-------------");
                         System.out.println("Pilha 2: ");
                         jogo.p2.imprime();
                         System.out.println("-------------");
                         System.out.println("Pilha 3: ");
                         jogo.p3.imprime();
                         System.out.println("-------------");
                         System.out.println("Escolha a pilha de origem: 1, 2 ou 3");
                         int escolha1 = scanner.nextInt();
                         System.out.println("Escolha a pilha final: 1, 2 ou 3");
                         int escolha2 = scanner.nextInt();
                         jogo.Trocar(escolha1, escolha2);
                         if(jogo.AcabouCheck()){
                             System.out.println("Voce acabou o jogo com sucesso");
                             fina = true;
                         }
                         break;
                         case 2:
                            fina = true;
                            break;
                    }
                }
                break;
            case 2:
                jogo.Automatico(3, 1, 2 ,3);
        }
    }
}