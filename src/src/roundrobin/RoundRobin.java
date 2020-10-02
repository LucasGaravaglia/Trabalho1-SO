package sjf;

import file.File;
import lista.*;
import pcb.*;

public class RoundRobin{

  public void main(String path){
    CircularList process;
    File f = new File();
    Pcb pcb;
    process = f.loadFile(path);
    int timeProcess = 0;

    for(int i=0;i<process.length();i++){
      pcb = process.getLowPcb();
      timeProcess += pcb.getEstimatedTime();
      system.out.println("Processo do Id " + pcb.getId() + "Executado em " + timeProcess);
      process.remove(pcb);
    }
    system.out.println("Processos executados em "+ timeProcess);
  }

  public void recursiveRobin(){
    
  }
}