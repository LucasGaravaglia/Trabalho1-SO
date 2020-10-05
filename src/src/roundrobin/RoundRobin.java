package roundrobin;

import file.File;
import pcb.*;
import queue.Queue;
//import java.util.ArrayList;

public class RoundRobin {
  private void processar(Pcb processo) {
  }

  public void executar(String filePath) throws Exception {
    Queue<Pcb> process;
    File f = new File();
    Pcb pcb;
    process = f.loadRRFile(filePath);
    Integer timeProcess = 0;
    int novoTempo = 0;
    String Line = "";
    System.out.println("Processando           Lista de processos");
    while (!process.ehVazia()) {
      pcb = process.top();
      Line = pcb.System.out.println(process.imprimirPilha());

      timeProcess += pcb.getQuantum();
      novoTempo = pcb.getEstimatedTime() - pcb.getQuantum();
      if (novoTempo < 0) {
        novoTempo = 0;
      }
      this.processar(pcb);

    }
  }
}