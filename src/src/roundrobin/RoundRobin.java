package roundrobin;

import file.File;
import pcb.*;
import queue.Queue;
//import java.util.ArrayList;

public class RoundRobin {
  public void main(String filePath) throws Exception {
    Queue<Pcb> process;
    File f = new File();
    Pcb pcb;
    process = f.loadRRFile(filePath);
    Integer timeProcess = 0;
    boolean loop = true;
    int size = 0;
    int novoTempo = 0;
    while (loop) {
      if (process.ehVazia())
        loop = false;
      size = process.size();
      for (int i = 0; i < size; i++) {
        pcb = process.remove();
        if (pcb == null)
          break;
        timeProcess += pcb.getQuantum();
        novoTempo = pcb.getEstimatedTime() - pcb.getQuantum();
        if (novoTempo < 0) {
          pcb.setEstimatedTime(0);
          System.out
              .println("processo " + pcb.getId().toString() + " Terminou de executar em " + timeProcess.toString());
        } else {
          pcb.setEstimatedTime(novoTempo);
          process.add(pcb);
          System.out.println("processo " + pcb.getId().toString() + "executou " + pcb.getQuantum().toString());
        }
      }
    }
  }
}