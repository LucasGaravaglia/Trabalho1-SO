package pcb;

//Classe q simula um Pcb. 
public class Pcb {

    private Integer Id;
    private Integer EstimatedTime;
    private Integer quantum;
    private String state;

    /**
     * Construtor da classe Pcb 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public Pcb() {
        this.Id = 0;
        this.EstimatedTime = 0;
        this.quantum = 0;
        this.state = "";
    }

    /**
     * Construtor da classe sobrecarregado. 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public Pcb(Integer Id, Integer EstimatedTime, Integer quantum, String state) {
        this.Id = Id;
        this.EstimatedTime = EstimatedTime;
        this.quantum = quantum;
        this.state = state;
    }

    /**
     * Setter da propriedade Id da classe 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * Setter da propriedade EstimatedTime da classe. 
     * Pré-condição: nenhuma.
     * Pós-condição: Nenhuma.
     */
    public void setEstimatedTime(Integer EstimatedTime) {
        this.EstimatedTime = EstimatedTime;
    }

    /**
     * Setter da propriedade quantum da classe. 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    /**
     * Getter da propriedade Id da classe. 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public Integer getId() {
        return this.Id;
    }

    /**
     * Getter da propriedade EstimatedTime da classe Pré-condição: nenhuma.
     * Pós-condição: Nenhuma.
     */
    public Integer getEstimatedTime() {
        return this.EstimatedTime;
    }

    /**
     * Getter da propriedade Quantum da classe 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public Integer getQuantum() {
        return this.quantum;
    }

    /**
     * Setter da propriedade state da classe 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public void setstate(String state) {
        this.state = state;
    }

    /**
     * Getter da propriedade state da classe 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public String getstate() {
        return this.state;
    }

    /**
     * método toString da classe 
     * Pré-condição: nenhuma. 
     * Pós-condição: Nenhuma.
     */
    public String toString() {
        return this.Id.toString();

    }

}