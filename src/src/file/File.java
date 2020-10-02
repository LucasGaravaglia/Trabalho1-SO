package file;

import java.io.BufferedReader;
import java.io.FileReader;

import pcb.*;
import java.util.*;

public class File {
    public ArrayList<Pcb> loadSjfFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int NumPcb = Integer.parseInt(bufferedReader.readLine());
        String[] temp;
        String line = "";
        Pcb pcb = new Pcb();
        ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
        line = bufferedReader.readLine();
        for (int i = 1; i < NumPcb && line != null; i++) {
            temp = line.split(";");
            pcb.setId(Integer.parseInt(temp[0]));
            pcb.setEstimatedTime(Integer.parseInt(temp[1]));
            pcbList.add(pcb);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return pcbList;
    }

    public Queue<Pcb> loadFile(String filePath) throws Exception {
        Queue<Pcb> pcbList = new LinkedList<Pcb>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int NumPcb = Integer.parseInt(bufferedReader.readLine());
        Integer Quantum = Integer.parseInt(bufferedReader.readLine());
        String[] temp;
        String line = "";
        Pcb pcb = new Pcb();
        pcbList.add(pcb);
        line = bufferedReader.readLine();
        for (int i = 1; i < NumPcb && line != null; i++) {
            temp = line.split(";");
            pcb.setId(Integer.parseInt(temp[0]));
            pcb.setEstimatedTime(Integer.parseInt(temp[1]));
            pcb.setQuantum(Quantum);
            pcbList.add(pcb);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return pcbList;
    }
}
