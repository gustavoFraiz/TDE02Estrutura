import java.util.Random;

public class TorreDeHanoi {
    int tamanho;
    Pilha p1;
    Pilha p2;
    Pilha p3;
    int count;

    //starta o objeto, precisa passar o tamanho que o jogador quer das pilhas.
    public TorreDeHanoi(int tamanho){
        this.tamanho = tamanho;
        this.p1 = new Pilha(tamanho);
        this.p2 = new Pilha(tamanho);
        this.p3 = new Pilha(tamanho);
        this.count = 0;
    }

    //Funcao para comecar o jogo, insere valores randomicos na pilha p1.
    public void Comecar(){

        Random random = new Random();
        for(int i = 0; i < tamanho; i++){
            p1.Inserir(random.nextInt(101));
        }
//        p1.imprime();
    }

    //Funcao principal, trocar os valores entre pilhas, recebe o ID das pilhas(1, 2 ou 3). comeco é a pilha que vai ser feito remove e fim é onde vai ser inserido. Novamente,
    // ta bem porco podia ter trocado esses IFs por um switchCase mas agora deixa assim.
    public void Trocar(int comeco, int fim){

        if(comeco == fim){
            System.out.println("Operacao Invalida, nenhum movimento computado");
        }
        if(comeco == 1){
            if(fim == 2){
                if(Check(p1.getTopo(), fim) || p2.topo == null){
                    p2.Inserir(p1.getTopo());
                    p1.remove();
//                    p1.imprime();
//                    p2.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
            if(fim == 3){
                if(Check(p1.getTopo(), fim) || p3.topo == null){
                    p3.Inserir(p1.getTopo());
                    p1.remove();
//                    p1.imprime();
//                    p3.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
        }
        if(comeco == 2){
            if(fim == 1){
                if(Check(p2.getTopo(), fim) || p1.topo == null){
                    p1.Inserir(p2.getTopo());
                    p2.remove();
//                    p2.imprime();
//                    p1.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
            if(fim == 3){
                if(Check(p2.getTopo(), fim) || p3.topo == null){
                    p3.Inserir(p2.getTopo());
                    p2.remove();
//                    p2.imprime();
//                    p3.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
        }
        if(comeco == 3){
            if(fim == 2){
                    if(Check(p3.getTopo(), fim) || p2.topo == null){
                    p2.Inserir(p3.getTopo());
                    p3.remove();
//                    p3.imprime();
//                    p2.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
            if(fim == 1){
                if(Check(p3.getTopo(), fim) || p1.topo == null){
                    p1.Inserir(p3.getTopo());
                    p3.remove();
//                    p3.imprime();
//                    p1.imprime();
                    count++;
                }
                else{
                    System.out.println("Operacao Invalida");
                }
            }
        }
    }

 //Codigo para checar se a troca de valores está de acordo com a regra do jogo, ta feito porcamente podia ter trocado esse monte de IFs, por um swichCase.
    public boolean Check(int valor, int fim){
        if(fim == 2){
            if(p2.topo == null){
                return true;
            }
            else{
                if(valor < p2.getTopo()){
                    return true;
                }
            }
        }

        if(fim == 1){
            if(p1.topo == null){
                return true;
            }
            else{
                if(valor < p1.getTopo()){
                    return true;
                }
            }
        }

        if(fim == 3){
            if(p3.topo == null){
                return true;
            }
            else{
                if(valor < p3.getTopo()){
                    return true;
                }
            }
        }

        return false;
    }

    //Codigo para checar se acabou utilizando as funcoes Cheia e OrdemCrescente implementadas na Pilha.java, não ta funcionando.
    public boolean AcabouCheck(){
        if(p1.cheia() && p1.ordemCrescente()){
            return true;
        }
        if(p2.cheia() && p2.ordemCrescente()){
            return true;
        }
        if(p3.cheia() && p3.ordemCrescente()){
            return true;
        }

        return false;
    }


}
