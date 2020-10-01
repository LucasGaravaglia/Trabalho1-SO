#include "pcb.h"


Pcb::Pcb(){
  this->id = 0;
  this->estimatedTime = 0;
  return 0;
}

Pcb::~Pcb(){
  return 0;
}

int Pcb::getId(){
  return this->id;
}

int Pcb::getEstimatedTime(){
  return this->estimatedTime;
}

void Pcb::setEstimatedTime(int other){
  this->estimatedTime = other;
}

void Pcb::setId(int other){
  this->id = other;
}
