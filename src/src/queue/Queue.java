package queue;

//Classe que representa a pilha utilizada pelo autômato com pilha determinístico
public class Queue<T> {
    private Celula<T> celula; // Celula da fila

    // Construtor padrão
    public Queue() {
        this.celula = null;
    }

    // Construtor sobrecarregado
    public Queue(Celula<T> celula) {
        this.celula = celula;
    }

    // Setter da variável celula
    public void setCelula(Celula<T> celula) {
        this.celula = celula;
    }

    // Getter da variável celula
    public Celula<T> getCelula() {
        return this.celula;
    }

    /**
     * Método que verifica se a pilha é vazia Entrada: Nenhuma Retorno: True caso
     * seja vazia ou False caso contrário Pré-condição: Nenhuma Pós-condição:
     * Nenhuma
     */
    public boolean ehVazia() {
        return this.celula == null;
    }

    /**
     * Método que adiciona um elemento na pilha Entrada: Informação a ser adicionada
     * Retorno: True caso consiga inserir ou False caso contrário Pré-condição:
     * Nenhuma Pós-condição: O elemento é inserido na pilha
     */
    public void add(T info) {
        if (this.ehVazia()) { // Fila vazia
            this.celula = new Celula<T>(info);
        } else { // Adicionar no Final
            this.celula = new Celula<T>(info, this.size());
        }
    }

    /**
     * Método que retorna o topo da pilha Entrada: Nenhuma Retorno: Topo da pilha ou
     * null caso não exista Pré-condição: Nenhuma Pós-condição: O topo é
     * desempilhado
     */
    public T remove() {
        T aux;
        if (!this.ehVazia()) {
            aux = this.celula.getInfo();
            this.celula = this.celula.getProx();
            return aux;
        } // Fila vazia
        return null;
    }

    /**
     * Método que retorna o topo da pilha Entrada: Nenhuma Retorno: Topo da pilha ou
     * null caso não exista Pré-condição: Nenhuma Pós-condição: Nenhuma
     */
    public T top() {
        T aux;
        if (!this.ehVazia()) {
            aux = this.celula.getInfo();
            return aux;
        } // Pilha vazia
        return null;
    }

    /**
     * Método que imprime a pilha Entrada: Nenhuma Retorno: Nenhum Pré-condição:
     * Nenhuma Pós-condição: A pilha é impressa
     */
    public void imprimirPilha() {
        int count = 1;
        Celula<T> aux;
        aux = this.celula;
        System.out.println("╔═════════════════╗");
        System.out.print("+ Inicio da Pilha +");
        System.out.println("\n╚═════════════════╝");
        while (aux != null) {
            System.out.print(count + ": " + aux.getInfo() + "\n");
            aux = aux.getProx();
            count++;
        }
        System.out.println("╔══════════════╗");
        System.out.print("+ Fim da Pilha +");
        System.out.println("\n╚══════════════╝\n\n");
    }

    /**
     * Método que calcula o tamanho da pilha Entrada: Nenhuma Retorno: Tamanho da
     * pilha Pré-condição: Nenhuma Pós-condição: Nenhuma
     */
    public Integer size() {
        Celula<T> aux;
        Integer i = 0;
        aux = this.celula;
        while (aux != null) {
            i++;
            aux = aux.getProx();
        }
        return i;
    }

    /**
     * Método que limpa a pilha Entrada: Nenhuma Retorno: Nenhum Pré-condição:
     * Nenhuma Pós-condição: A pilha é zerada
     */
    public void limparPilha() {
        while (this.celula != null) {
            this.remove();
        }
    }

    /**
     * Método que retorna uma cópia da pilha atual Entrada: Nenhuma Retorno: Pilha
     * atual Pré-condição: Nenhuma Pós-condição: A pilha atual é retornada
     */
    public Queue<T> getPilha() {
        Queue<T> aux = new Queue<T>(this.celula);
        return aux;
    }

    /*
     * Método que retorna conteudo da classe em formato string Entrada: Nenhuma
     * Retorno: Nenhum Pré-condição: Nenhuma Pós-condição: A pilha é impressa
     */
    public String toString() {
        String text = "";
        Celula<T> aux;
        aux = this.celula;
        if (aux != null) {
            text += aux.getInfo();
            aux = aux.getProx();
        }

        while (aux != null) {
            text += (", " + aux.getInfo());
            aux = aux.getProx();
        }
        return text;
    }
}