package sjf;

import file.File;
import pcb.*;
import java.util.ArrayList;

public class Sjf {
    private Pcb processar(Pcb processo) {
        processo.setEstado("finalizado");
        return processo;
    }

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

    public void executar(String filePath) throws Exception {
        ArrayList<Pcb> process;
        File f = new File();
        Pcb pcb;
        process = f.loadSjfFile(filePath);
        process = this.sort(process);
        int timeProcess = 0;
        for (int i = 0; i < process.size(); i++) {
            pcb = process.get(i);
            pcb.setEstado("em execução");
            process.set(i, pcb);
            timeProcess += pcb.getEstimatedTime();
            for (Pcb temp : process) {
                System.out.println(temp.toString());
            }
            pcb = this.processar(pcb);
            process.set(i, pcb);
        }
        System.out.println("Tempo médio de resposta: " + timeProcess);
    }
}