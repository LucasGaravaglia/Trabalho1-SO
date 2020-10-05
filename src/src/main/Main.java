package main;

import java.util.Scanner;

import roundrobin.RoundRobin;
import sjf.*;

public class Main {


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        boolean loop = true;
        int entrada;
        String path = "";
        Sjf sjf = new Sjf();
        RoundRobin rr = new RoundRobin();

        System.out.println("[1] Processo não preemptivo");
        System.out.println("[2] Processo preemptivo");
        System.out.println("[3] Sair");
        entrada = ler.nextInt();
        if (entrada == 1) {
            try {
                sjf.executar("entrada.txt");
            } catch (Exception e) {
                System.out.println("Erro ao processar o arquivo.");
            }
        } else if (entrada == 2) {
            try {
                rr.executar("entrada.txt");
            } catch (Exception e) {
                System.out.println("Erro ao processar o arquivo.");
            }
        }
        ler.close();
    }
}
