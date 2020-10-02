package lista;

public class CircularList{
    private No no;
    private int contador;

    public CircularList() {
        this.no = null;
        this.contador = 0;
    }

    public int quantDeNo() {
        return this.contador;
    }

    public No getNo() {
        return this.no;
    }

    public void proximoNo() {
        this.no = this.no.getProximo();
    }

    public void add (No node){
        if(this.no == null){
            node.setProximo(node)
            this.no = node;

        }
    }

    public void add(No node) {
        if (this.no == null) {
            node.setProximo(node);
            this.no = node;
        } else {
            node.setProximo(this.no.getProximo());
            this.no.setProximo(node);
        }
        this.contador++;
    }

    public No getLowPcb(){
        if(this.no == null ) return null;
        Unsigned int low = -1;
        No temp;
        int contador = 0;
        return this.getLow(low,temp,contador)
        
    }
    public No getLow(Unsigned int low, No temp,int contador){
        if(contador <= this.contador){
            if(low != null){
                low = this.temp.EstimatedTime;
                temp = this.no;
                return this.getLow(low,temp,contador+1)
            }
            if(this.no.EstimatedTime < low.EstimatedTime){
                low = this.temp.EstimatedTime;
                temp = this.no;
            }
            return this.getLow(low,temp,contador+1)
        }else{
            return temp;
        }
    }
}

