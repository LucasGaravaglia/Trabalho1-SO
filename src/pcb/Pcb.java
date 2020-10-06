package pcb;

public class Pcb implements Comparable<Pcb> {

  private Integer Id;
  private Integer EstimatedTime;
  private Integer quantum;
  private String estado;

  public Pcb() {
    this.Id = 0;
    this.EstimatedTime = 0;
    this.quantum = 0;
    this.estado = "";
  }

  // public Pcb(Integer Id=0,Integer EstimatedTime=0, Integer quantum,String
  // estado) {
  public Pcb(Integer Id, Integer EstimatedTime, Integer quantum, String estado) {
    this.Id = Id;
    this.EstimatedTime = EstimatedTime;
    this.quantum = quantum;
    this.estado = estado;
  }

  public int compareTo(Pcb other) {
    if (other.Id == this.Id && other.EstimatedTime == other.EstimatedTime)
      return 1;
    return 0;
  }

  public void setId(Integer Id) {
    this.Id = Id;
  }

  public void setEstimatedTime(Integer EstimatedTime) {
    this.EstimatedTime = EstimatedTime;
  }

  public void setQuantum(Integer quantum) {
    this.quantum = quantum;
  }

  public Integer getId() {
    return this.Id;
  }

  public Integer getEstimatedTime() {
    return this.EstimatedTime;
  }

  public Integer getQuantum() {
    return this.quantum;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getEstado() {
    return this.estado;
  }

  public String toString() {
    return this.Id.toString();

  }

}