package lista;

//import java.util.ArrayList;
//import file.File;
import pcb.*;

public class No {
private No proximo;
    private Pcb data;

    public void setId(Pcb data) {
        this.data = data;
    }

    public Integer getId() {
        return this.data;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo(No node) {
        this.proximo = node;
    }

}

//public class PcbList{
//
//  private ArrayList<Pcb> data;
//  private File file;
//
//  public PcbList(){
//    this.file = new File()
//  }
//  public Pcb getLowPcb(){
//    if(this.data == null) return null;
//    Integer low = 10000;
//    Pcb tempPcb;
//    for(Pcb temp : this.data){
//      if(temp.EstimatedTime < low){
//        low = temp.EstimatedTime;
//        tempPcb = temp;
//      }
//    }
//    return tempPcb;
//  }
//
//  public void loadList(String pathFile){
//    this.data = this.file.loadFile(String pathFile);
//  }
//
//  public Pcb getLowPcb(){
//    if(this.data == null) return null;
//    Integer low = 10000;
//    Pcb tempPcb;
//    for(Pcb temp : this.data){
//      if(temp.EstimatedTime < low){
//        low = temp.EstimatedTime;
//        tempPcb = temp;
//      }
//    }
//    return tempPcb;
//  }
//
//  public boolean removePcb(Pcb pcb){
//    return this.data.remove(this.data.indexOf(pcb))
//  }
//
//  public void setPcb(ArrayList<Pcb> data){
//    this.data = data;
//  }
//
//  public ArrayList<Pcb> getPcb(){
//    return this.data;
//  }
//}
