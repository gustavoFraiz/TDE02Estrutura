//Nao tem nada demais aqui nesse codigo além do ja feito em outros TDES.

public class Node {
    private Integer informação;
    public Node proximo;
    public Node(){
        informação = null;
        proximo = null;
    }

    public Integer getInformação() {
        return informação;
    }

    public void setInformação(Integer informação) {
        this.informação = informação;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
