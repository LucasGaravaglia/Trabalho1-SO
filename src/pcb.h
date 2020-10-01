#ifndef PCB_H
#define PCB_H

class Pcb{

  private:
    int id;
    int estimatedTime;

  public:
    Pcb();
    ~Pcb();
    int getId();
    int getEstimatedTime();
    void setId(int other);
    void setEstimatedTime(int other);

}
#endif