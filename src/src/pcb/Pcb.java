package pcb;

public class Pcb{

  private Integer Id;
  private Integer EstimatedTime;
  private Integer quantum;

	public Pcb(){
		this.Id = 0;
    	this.EstimatedTime = 0;
    	this.quantum = 0;
  	}


  	public void setId(Integer Id){
    	this.Id = Id;
  	}  

  	public void setEstimatedTime(Integer EstimatedTime){
    	this.EstimatedTime = EstimatedTime;
  	}

  	public void setQuantum(Integer quantum){
    	this.quantum = quantum;
  	}

  	public Integer getId(){
    	return this.Id;
  	}

  	public Integer getEstimatedTime(){
	    return this.EstimatedTime;
	}

	public Integer getQuantum(){
		return this.quantum;
	}


}