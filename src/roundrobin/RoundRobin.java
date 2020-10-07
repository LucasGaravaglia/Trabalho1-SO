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
  private void processar() {
  }

  /**
   * Método que avança a lista de pcb e elimina pcb que terminaram de
   * processar.Pré-condição: Pcb e arrayList de pcb validos. Pós-condição: Avança
   * na lista ou remove o pcb da lista.
   */
  private ArrayList<Pcb> proximo(Pcb pcb, ArrayList<Pcb> array) {
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
  public void executar(String filePath) throws Exception {

    ArrayList<Pcb> process;
    File f = new File();
    Pcb pcb;
    try {
      BufferedWriter escritor = f.openFile("saidaRr.txt");
      process = f.loadRRFile(filePath);
      Integer timeProcess = 0;
      int novoTempo = 0;
      int tr = 0;
      int trocaContexto = 0;
      int size = process.size();
      escritor.append("Processando                   Lista de processos");
      Line += "\n";
      while (process.size() > 0) {
        pcb = process.get(0);
        pcb.setEstado("em execução");
        Line += "    Id[" + pcb.getId().toString() + "]";
        Line += "              ";
        Line += process;
        novoTempo = pcb.getEstimatedTime() - pcb.getQuantum();
        if (novoTempo < 0) {
          novoTempo = 0;
        }
        timeProcess += pcb.getEstimatedTime() - novoTempo;
        tr += timeProcess;
        pcb.setEstimatedTime(novoTempo);
        this.processar();
        pcb.setEstado("pronto");
        process = this.proximo(pcb, process);
        Line += "\n";
        trocaContexto++;
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