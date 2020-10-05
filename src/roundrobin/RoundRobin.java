package roundrobin;

import file.File;
import pcb.*;
import java.util.ArrayList;

public class RoundRobin {
  private void processar() {
  }

  private ArrayList<Pcb> proximo(Pcb pcb,ArrayList<Pcb> array){
    if(pcb.getEstimatedTime() > 0){
      array.add(pcb);
    }
    return array;
  }

  public void executar(String filePath) throws Exception {
    ArrayList<Pcb> process;
    File f = new File();
    Pcb pcb;
    try{
    process = f.loadRRFile(filePath);
    Integer timeProcess = 0;
    int novoTempo = 0;
    String Line = "";
    int tr=0;
    int size = process.size();
    System.out.println("Processando           Lista de processos");
    while (process.size() > 0) {
      pcb = process.get(0);
      pcb.setEstado("em execução");
      Line = "    Id["+pcb.getId().toString()+"]";
      Line+= "                 ";
      Line += process;
      System.out.println(Line);
      process.remove(0);
      novoTempo = pcb.getEstimatedTime() - pcb.getQuantum();
      if (novoTempo < 0) {
        novoTempo = 0;
      }
      timeProcess += pcb.getEstimatedTime() - novoTempo;
      tr +=timeProcess;
      pcb.setEstimatedTime(novoTempo);
      this.processar();
      pcb.setEstado("pronto");
      process = this.proximo(pcb,process);

    }
    tr = tr/size;
    System.out.println("Tempo médio de resposta: " + tr);
    }catch(Exception e){
      System.out.println("Erro ao ler o arquivo.")
    }
  }
}