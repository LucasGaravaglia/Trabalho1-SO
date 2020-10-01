package pcb;

import java.util.ArrayList;
import file.File;


public class PcbList{

  private ArrayList<Pcb> data;
  private File file;

  public PcbList(){
    this.file = new File()
  }

  public void loadList(String pathFile){
    this.data = this.file.loadFile(String pathFile);
  }

  public Pcb getLowPcb(){
    if(this.data == null) return null;
    Integer low = 10000;
    Pcb tempPcb;
    for(Pcb temp : this.data){
      if(temp.EstimatedTime < low){
        low = temp.EstimatedTime;
        tempPcb = temp;
      }
    }
    return tempPcb;
  }

  public boolean removePcb(Pcb pcb){
    return this.data.remove(this.data.indexOf(pcb))
  }

  public void setPcb(ArrayList<Pcb> data){
    this.data = data;
  }

  public ArrayList<Pcb> getPcb(){
    return this.data;
  }
}
