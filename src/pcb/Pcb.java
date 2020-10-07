package pcb;

//Classe q simula um Pcb. 
public class Pcb {

    private Integer Id;
    private Integer EstimatedTime;
    private Integer quantum;
    private String estado;

    /**
     * Construtor da classe Pcb Pré-condição: nenhuma. Pós-condição: Nenhuma.
     */
    public Pcb() {
        this.Id = 0;
        this.EstimatedTime = 0;
        this.quantum = 0;
        this.estado = "";
    }

    /**
     * Construtor da classe sobrecarregado. Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public Pcb(Integer Id, Integer EstimatedTime, Integer quantum, String estado) {
        this.Id = Id;
        this.EstimatedTime = EstimatedTime;
        this.quantum = quantum;
        this.estado = estado;
    }

    /**
     * Setter da propriedade Id da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * Setter da propriedade EstimatedTime da classe Pré-condição: nenhuma.
     * Pós-condição: Nenhuma.
     */
    public void setEstimatedTime(Integer EstimatedTime) {
        this.EstimatedTime = EstimatedTime;
    }

    /**
     * Setter da propriedade quantum da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    /**
     * Getter da propriedade Id da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
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
     * Getter da propriedade Quantum da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public Integer getQuantum() {
        return this.quantum;
    }

    /**
     * Setter da propriedade Estado da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Getter da propriedade Estado da classe Pré-condição: nenhuma. Pós-condição:
     * Nenhuma.
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * método toString da classe Pré-condição: nenhuma. Pós-condição: Nenhuma.
     */
    public String toString() {
        return this.Id.toString();

    }

}