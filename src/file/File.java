package file;

import java.io.BufferedReader;
import java.io.FileReader;

import pcb.*;
import java.util.ArrayList;

public class File {
  public ArrayList<Pcb> loadSjfFile(String filePath) throws Exception {
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    int NumPcb = Integer.parseInt(bufferedReader.readLine());
    String[] temp;
    String line = "";
    Pcb pcb;
    Pcb tempPcb;
    ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
    line = bufferedReader.readLine();
    for (int i = 0; i < NumPcb && line != null; i++) {
      temp = line.split(";");
      pcb = new Pcb(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 0, "pronto");
      tempPcb = pcb;
      pcbList.add(tempPcb);
      line = bufferedReader.readLine();
      pcb = null;
    }
    bufferedReader.close();
    return pcbList;
  }

  public ArrayList<Pcb> loadRRFile(String filePath) throws Exception {
    ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    int NumPcb = Integer.parseInt(bufferedReader.readLine());
    Integer Quantum = Integer.parseInt(bufferedReader.readLine());
    String[] temp;
    String line = "";
    Pcb pcb = new Pcb();
    Pcb TempPcb;
    line = bufferedReader.readLine();
    for (int i = 0; i < NumPcb && line != null; i++) {
      temp = line.split(";");
      pcb = new Pcb(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Quantum, "pronto");
      TempPcb = pcb;
      pcbList.add(TempPcb);
      line = bufferedReader.readLine();
      pcb = null;
    }
    bufferedReader.close();
    System.out.println("saiu");
    return pcbList;
  }
}
