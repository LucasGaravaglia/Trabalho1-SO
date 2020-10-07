package roundrobin;

import file.File;
import pcb.*;
import java.util.ArrayList;
import java.io.BufferedWriter;

//Classe que simula o algoritmo roundRobin
public class RoundRobin {
  private String Line;

  /**
   * Construtor da classe Pcb Pré-condição: nenhuma. Pós-condição: Nenhuma.
   */
  public RoundRobin() {
    this.Line = "";
  }

  /**
   * Método meramente ilustrativa para simular a chamada do processador.
   */
  private void performProcessing() {
  }

  /**
   * Método que avança a lista de pcb e elimina pcb que terminaram de
   * processar.Pré-condição: Pcb e arrayList de pcb validos. Pós-condição: Avança
   * na lista ou remove o pcb da lista.
   */
  private ArrayList<Pcb> next(Pcb pcb, ArrayList<Pcb> array) {
    array.remove(0);
    if (pcb.getEstimatedTime() > 0) {
      array.add(pcb);
    } else {
      Line += " pcb do Id[" + pcb.getId().toString() + "] será removida.";
    }
    return array;
  }

  /**
   * Método que simula o algoritmo do RoundRobin. Pré-condição: Arquivo valido.
   * Pós-condição: Nenhuma.
   */
  public void run(String filePath) throws Exception {
    ArrayList<Pcb> process;
    File file = new File();
    try {
      Pcb pcb;
      BufferedWriter writeToFile = file.openFile("saidaRr.txt");
      process = file.loadRRFile(filePath);
      Integer processTime = 0;
      int newEstimatedTime = 0;
      int averageResponseTime = 0;
      int contextSwitch = 0;
      int size = process.size();
      writeToFile.append("Processando                   Lista de processos");
      Line += "\n";
      while (process.size() > 0) {
        pcb = process.get(0);
        pcb.setstate("em execução");
        Line += "    Id[" + pcb.getId().toString() + "]";
        Line += "              ";
        Line += process;
        newEstimatedTime = pcb.getEstimatedTime() - pcb.getQuantum();
        if (newEstimatedTime < 0) {
          newEstimatedTime = 0;
        }
        processTime += pcb.getEstimatedTime() - newEstimatedTime;
        averageResponseTime += processTime;
        pcb.setEstimatedTime(newEstimatedTime);
        this.performProcessing();
        pcb.setstate("pronto");
        process = this.next(pcb, process);
        Line += "\n";
        contextSwitch++;
      }
      averageResponseTime = averageResponseTime / size;
      writeToFile.append(Line);
      writeToFile.append("Tempo médio de resposta: " + averageResponseTime + "\n");
      writeToFile.append("Ocorreu " + contextSwitch + " trocas de contexto");
      writeToFile.close();
    } catch (Exception e) {
      System.out.println("Erro ao ler o arquivo.");
    }
  }
}