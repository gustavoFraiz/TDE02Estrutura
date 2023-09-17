public class Pilha {
    private Node pilha;
    private Node atual;
    public Node topo;
    private int tamanho;

    private int tamanhoMax;

    public Pilha(int max){
        this.pilha = null;
        this.atual = null;
        this.topo = null;
        this.tamanho = 0;
        this.tamanhoMax = max;
    }

    //Funcao para checar se esta vazio:

    public Boolean vazio(){
        if(tamanho == 0){
            return true;
        }
        else return false;
    }

    // Funcao de inserir na pilha, recebe a informacao a ser repassada, se o tamanho da pilha ultrapassar o tamanho maximo setado pelo usuario, a pilha comecara a remover o topo.
    public void Inserir(int valor){
        Node no = new Node();
        no.setInformação(valor);
        if(vazio()){
            pilha = no;
            tamanho++;
            topo = no;
        }
        else{
            if(tamanho <= tamanhoMax){
                atual = topo;
                atual.setProximo(no);
                topo = atual.getProximo();
                tamanho++;
            }
            else{
                topo.setInformação(valor);
            }

        }
    }

    // funcao pra imprimir a pilha.
    public void imprime(){

        atual = pilha;
        while (atual != null) {
            System.out.print(atual.getInformação()+ " -> ");
            atual= atual.getProximo();
        }
        System.out.println("Acabou");


    }

    //funcao remove para remover o topo e setar um novo topo.
    public int remove(){
        if (vazio()) {
            throw new IllegalStateException("A pilha está vazia");
        }

        int valor = topo.getInformação();

        if (topo == pilha) {
            pilha = null; // Se for o último elemento, a pilha fica vazia
            topo = null;
        } else {
            Node aux = pilha;
            while (aux.getProximo() != topo) {
                aux = aux.getProximo();
            }
            topo = aux;
            topo.setProximo(null);
        }

        tamanho--;

        return valor;

    }

//Ve qual valor esta no topo da fila, serve na hora da gente trocar os valores entre as pilhas.
    public int getTopo(){
        return topo.getInformação();
    }

    //Checa se a pilha ta cheia, definitivamente nao ta funcionando.
    public boolean cheia(){
        if(getTamanho() == tamanhoMax){
            return true;
        }
        return false;
    }

    //Checa se a pilha ta em ordemCrescente, nao sei se ta funcionando.
    public boolean ordemCrescente(){
        Node atual = pilha;

        while (atual != null && atual.getProximo() != null) {
            if (atual.getInformação() <= atual.getProximo().getInformação()) {
                return false;
            }
            atual = atual.getProximo();
        }
        return true;
    }

    public boolean ordemDecrescente(){
        Node atual = pilha;

        while (atual != null && atual.getProximo() != null) {
            if (atual.getInformação() >= atual.getProximo().getInformação()) {
                return false;
            }
            atual = atual.getProximo();
        }
        return true;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void organizaDecrescente() {
        if (vazio() || tamanho == 1) {

            return;
        }

        Pilha pilhaTemporaria = new Pilha(tamanhoMax);

        while (!vazio()) {
            int elemento = remove();
            while (!pilhaTemporaria.vazio() && pilhaTemporaria.getTopo() > elemento) {
                int temp = pilhaTemporaria.remove();
                Inserir(temp);
            }
            pilhaTemporaria.Inserir(elemento);
        }

        while (!pilhaTemporaria.vazio()) {
            Inserir(pilhaTemporaria.remove());
        }
    }


}

