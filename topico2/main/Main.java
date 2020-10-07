package main;

import java.util.Scanner;

import roundrobin.RoundRobin;
import sjf.Sjf;

public class Main {
  /**
   * Método principal, que roda todo o programa. Pré-condição: nenhuma.
   * Pós-condição: Nenhuma.
   */
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    int entrada;
    Sjf sjf = new Sjf();
    RoundRobin rr = new RoundRobin();

    System.out.println("[1] Processo não preemptivo");
    System.out.println("[2] Processo preemptivo");
    entrada = ler.nextInt();
    if (entrada == 1) {
      try {
        sjf.run("entradaSjf.txt");
        System.out.println("Algoritmo não preemptivo finalizado.\nA saída dele está no arquivo saidaSjf.txt.\n");
      } catch (Exception e) {
        System.out.println("Erro ao rodas o algoritmo.");
      }
    } else if (entrada == 2) {
      try {
        rr.run("entradaRr.txt");
        System.out.println("Algoritmo preemptivo finalizado.\nA saída dele está no arquivo saidaRr.txt.\n");
      } catch (Exception e) {
        System.out.println("Erro ao rodas o algoritmo.");
      }
    }
    ler.close();
  }
}
