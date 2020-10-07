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
  private void processar() {
  }

  /**
   * Construtor da classe Pcb Pré-condição: nenhuma. Pós-condição: Nenhuma.
   */
  public Sjf() {
    this.Line = "";
  }

  /**
   * Método que ordena o arrayList de pcb Pré-condição: nenhuma. Pós-condição:
   * Retorna um arrayList ordenado.
   */
  public ArrayList<Pcb> sort(ArrayList<Pcb> other) {
    ArrayList<Pcb> sortArray = new ArrayList<Pcb>();
    Pcb temp;
    int size = other.size();
    for (int i = 0; i < size; i++) {
      temp = other.get(0);
      for (Pcb data : other) {
        if (data.getEstimatedTime() < temp.getEstimatedTime()) {
          temp = data;
        }
      }
      other.remove(temp);
      sortArray.add(temp);
      temp = null;
    }
    return sortArray;
  }

  /**
   * Método que simula o algoritmo Sjf. Pré-condição: Arquivo valido.
   * Pós-condição: Nenhuma.
   */
  public void executar(String filePath) throws Exception {
    ArrayList<Pcb> process;
    File f = new File();
    Pcb pcb;
    int size = 0;
    int tr = 0;
    int trocaContexto = 0;
    try {
      BufferedWriter escritor = f.openFile("saidaSjf.txt");
      process = f.loadSjfFile(filePath);
      process = this.sort(process);
      int timeProcess = 0;
      size = process.size();
      escritor.append("Processando                      Lista de processos\n");
      for (int i = 0; i < size; i++) {
        trocaContexto++;
        pcb = process.get(0);
        pcb.setEstado("em execução");
        Line += "    Id[" + pcb.toString() + "]";
        Line += "                   ";
        process.set(0, pcb);
        timeProcess += pcb.getEstimatedTime();
        tr += timeProcess;
        Line += process;
        Line += "\n";
        this.processar();
        process.remove(pcb);
      }
      tr = tr / size;
      escritor.append(Line);
      escritor.append("Tempo médio de resposta: " + tr + "\n");
      escritor.append("Ocorreu " + trocaContexto + " trocas de contexto");
      escritor.close();

    } catch (Exception e) {
      System.out.println("Erro ao ler o arquivo.");
    }

  }
}