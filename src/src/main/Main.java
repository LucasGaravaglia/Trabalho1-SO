package main;

import java.util.Scanner;

import roundrobin.RoundRobin;
import sjf.*;

public class Main {

    private void clear() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        boolean loop = true;
        int entrada;
        String path = "";
        Sjf sjf = new Sjf();
        RoundRobin rr = new RoundRobin();

        while (loop) {
            System.out.println("[1] Processo não preemptivo");
            System.out.println("[2] Processo preemptivo");
            System.out.println("[3] Sair");
            entrada = ler.nextInt();
            this.clear();
            if (entrada == 1) {
                System.out.println("Digite o nome do arquivo para o algoritmo sjf.");
                path = ler.nextLine();
                this.clear();
                try {
                    sjf.executar(path);
                } catch (Exception e) {
                    System.out.println("Erro ao processar o arquivo.");
                }
                System.out.println("Aperte enter para continuar.");
                path = ler.nextLine();
            } else if (entrada == 2) {
                System.out.println("Digite o nome do arquivo para o algoritmo RoundRobin.");
                path = ler.nextLine();
                this.clear();
                try {
                    rr.executar(path);
                } catch (Exception e) {
                    System.out.println("Erro ao processar o arquivo.");
                }
                System.out.println("Aperte enter para continuar.");
                path = ler.nextLine();
            } else {
                loop = false;
            }

        }

        ler.close();
    }
}
