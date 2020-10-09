package sjf;

import file.File;
import pcb.*;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Sjf {
  private String Line;

  /**
   * Método meramente ilustrativa para simular a chamada do processador.
   */
  private void performProcessing() {
  }

  /**
   * Construtor da classe Pcb 
   * Pré-condição: nenhuma. 
   * Pós-condição: Nenhuma.
   */
  public Sjf() {
    this.Line = "";
  }

  /**
   * Método que ordena o arrayList de pcb. 
   * Pré-condição: nenhuma. 
   * Pós-condição: Retorna um arrayList ordenado.
   */
  public ArrayList<Pcb> sort(ArrayList<Pcb> other) {
    ArrayList<Pcb> sortArray = new ArrayList<Pcb>();
    Pcb TemporaryPcb;
    int size = other.size();
    for (int i = 0; i < size; i++) {
      TemporaryPcb = other.get(0);
      for (Pcb data : other) {
        if (data.getEstimatedTime() < TemporaryPcb.getEstimatedTime()) {
          TemporaryPcb = data;
        }
      }
      other.remove(TemporaryPcb);
      sortArray.add(TemporaryPcb);
      TemporaryPcb = null;
    }
    return sortArray;
  }

  /**
   * Método que simula o algoritmo Sjf. 
   * Pré-condição: Arquivo valido.
   * Pós-condição: Nenhuma.
   */
  public void run(String filePath) throws Exception {
    ArrayList<Pcb> process;
    File file = new File();
    try {
      Pcb pcb;
      BufferedWriter writeToFile = file.openFile("saidaSjf.txt");
      int size = 0;
      int averageResponseTime = 0;
      int contextSwitch = 0;
      process = file.loadSjfFile(filePath);
      process = this.sort(process);
      int processTime = 0;
      size = process.size();
      writeToFile.append("Processando                      Lista de processos\n");
      for (int i = 0; i < size; i++) {
        contextSwitch++;
        pcb = process.get(0);
        pcb.setstate("em execução");
        Line += "    Id[" + pcb.toString() + "]";
        Line += "                   ";
        process.set(0, pcb);
        processTime += pcb.getEstimatedTime();
        averageResponseTime += processTime;
        Line += process;
        Line += "\n";
        this.performProcessing();
        process.remove(pcb);
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