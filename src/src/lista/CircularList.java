package lista;


import pcb.*;

public class CircularList{
    private No no;
    private int contador;

    public CircularList() {
        this.no = null;
        this.contador = 0;
    }

    public int length() {
        return this.contador;
    }

    public No getNo() {
        return this.no;
    }

    public void proximoNo() {
        this.no = this.no.getProximo();
    }

    public boolean remove(Pcb data){
        if(this.no != null){
            int contador = 1;
            this.removeRecursive(data,contador)
            return true;
        }
        return false;

    }
    public No search(Pcb data,No first = this.no){
        if(this.no.getId().compareTo(data)) return this.no.getId();
        if(this.no.getProximo().getId().compareTo(first.getId())) return null;
        return this.no.getProximo().search(data,first);
    }
    private void removeRecursive(Pcb data,int contador){
        if(contador <= this.contador){
            if(this.no.getId().compareTo(data)){
                this.no.getId().setId(null)
            }else{
                this.proximoNo.removeRecursive(data,contador+1)
            }
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

    public void add(Pcb data){
        No node;
        node.setId(data);
        if (this.no == null) {
            node.setProximo(node);
            this.no = node;
        } else {
            node.setProximo(this.no.getProximo());
            this.no.setProximo(node);
        }
        this.contador++;
    }

    public Pcb getLowPcb(){
        if(this.no == null ) return null;
        Unsigned int low = -1;
        No temp;
        int contador = 0;
        return this.getLow(low,temp,contador,this).getId();
        
    }
    public No getLow(Unsigned int low, No temp,int contador,CircularList list){
        if(contador <= this.contador){
            if(this.no.getId() != null && this.no.getId().getEstimatedTime() < low.getEstimatedTime()){
                low = this.no.getId().getEstimatedTime();
                temp = this.no;
            }
            return this.getLow(low,temp,contador+1,this.proximoNo)
        }else{
            return temp;
        }
    }
}

