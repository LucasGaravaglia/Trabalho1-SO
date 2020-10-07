package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

import pcb.*;
import java.util.ArrayList;

public class File {
    /**
     * método que abre um arquivo vazio e retorna a instancia do arquivo.
     * Pré-condição: nenhuma. Pós-condição: Retorna a instancia do arquivo aberto.
     */
    public BufferedWriter openFile(String filePath) throws Exception {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        return bufferedWriter;
    }

    /**
     * método que o caminho de um arquivo, processa ele e retorna um arrayList de
     * pcb. Pré-condição: Ser um caminho de arquivo para uma entrada valida do
     * algoritmo Sjf. Pós-condição: Retorna um arrayList de pcb, e fecha o arquivo.
     */
    public ArrayList<Pcb> loadSjfFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int NumPcb = Integer.parseInt(bufferedReader.readLine());
        String[] stringVector;
        String line = "";
        Pcb pcb;
        ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
        line = bufferedReader.readLine();
        for (int i = 0; i < NumPcb && line != null; i++) {
            stringVector = line.split(";");
            pcb = new Pcb(Integer.parseInt(stringVector[0]), Integer.parseInt(stringVector[1]), 0, "pronto");
            pcbList.add(pcb);
            line = bufferedReader.readLine();
            pcb = null;
        }
        bufferedReader.close();
        return pcbList;
    }

    /**
     * método que o caminho de um arquivo, processa ele e retorna um arrayList de
     * pcb. Pré-condição: Ser um caminho de arquivo para uma entrada valida do
     * algoritmo RoundRobin. Pós-condição: Retorna um arrayList de pcb, e fecha o
     * arquivo.
     */
    public ArrayList<Pcb> loadRRFile(String filePath) throws Exception {
        ArrayList<Pcb> pcbList = new ArrayList<Pcb>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int NumPcb = Integer.parseInt(bufferedReader.readLine());
        Integer Quantum = Integer.parseInt(bufferedReader.readLine());
        String[] stringVector;
        String line = "";
        Pcb pcb = new Pcb();
        line = bufferedReader.readLine();
        for (int i = 0; i < NumPcb && line != null; i++) {
            stringVector = line.split(";");
            pcb = new Pcb(Integer.parseInt(stringVector[0]), Integer.parseInt(stringVector[1]), Quantum, "pronto");
            pcbList.add(pcb);
            line = bufferedReader.readLine();
            pcb = null;
        }
        bufferedReader.close();
        return pcbList;
    }
}
