package sjf;

import file.File;
import pcb.*;
import java.util.ArrayList;

public class Sjf {
    private void processar() {
    }

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

    public void executar(String filePath) throws Exception {
        ArrayList<Pcb> process;
        File f = new File();
        Pcb pcb;
        int size=0;
        int tr = 0;
        try{
        process = f.loadSjfFile(filePath);
        process = this.sort(process);
        int timeProcess = 0;
        String Line = "";
        size = process.size();
        System.out.println("Processando           Lista de processos");
        for (int i = 0; i < size; i++) {
            pcb = process.get(0);
            pcb.setEstado("em execução");
            Line = pcb.toString();
            process.set(0, pcb);
            Line +="                   ";
            timeProcess += pcb.getEstimatedTime();
            tr +=timeProcess;
                Line+=process;
            this.processar();
            process.remove(pcb);
            System.out.println(Line);
        }
        tr = tr/size;
        System.out.println("Tempo médio de resposta: " + tr);
        }catch(Exception e){
            System.out.println("Erro ao ler o arquivo.");
        }
        
    }
}