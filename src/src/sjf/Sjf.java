package sjf;

import file.File;
import pcb.*;
import java.util.ArrayList;

public class Sjf {

    public ArrayList<Pcb> sort(ArrayList<Pcb> other) {
        ArrayList<Pcb> sortArray = new ArrayList<Pcb>();
        Pcb temp;
        for (int i = 0; i < other.size(); i++) {
            temp = other.get(i);
            for (Pcb data : sortArray) {
                if (data.getEstimatedTime() < temp.getEstimatedTime()) {
                    temp = data;
                }
            }
            sortArray.add(temp);
        }
        return sortArray;
    }

    public void main(String filePath) throws Exception {
        ArrayList<Pcb> process;
        File f = new File();
        Pcb pcb;
        process = f.loadSjfFile(filePath);
        process = this.sort(process);
        int timeProcess = 0;
        for (int i = 0; i < process.size(); i++) {
            pcb = process.get(i);
            timeProcess += pcb.getEstimatedTime();
            System.out.println("Processo do Id " + pcb.getId() + "Executado em " + timeProcess);
        }
        System.out.println("Processos executados em " + timeProcess);
    }
}