package file;

import java.io.BufferedReader;
import java.io.FileReader;
import pcb.*;
java.util.ArrayList


public class File {
    /* 
     * Método que lê um arquivo e retorna um arrayList de pcb
     * pré-condição: Nenhum
     * pós-condição: Retorna um ArrayList de pcb
     */
    public ArrayList<Pcb> loadFile(String filePath) throws Exception {
        ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
        Pcb pcb = new Pcb();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Integer NumPcb = bufferedReader.readLine();
        Integer Quantum = bufferedReader.readLine();
        int i;
        String[] temp;
        String line = "";
        line = bufferedReader.readLine();
        for(i = 1; i < NumPcb && line != null; i++){
            temp = line.split(";");
            pcb.Id = Integer.parseInt(temp[0]);
            pcb.EstimatedTime = Integer.parseInt(temp[1]);
            pcb.quantum = Quantum;
            pcbList.add(pcb);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return pcbList;
    }
}
