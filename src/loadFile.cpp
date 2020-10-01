#include <fstream>
#include <string>

void LoadFile(string way){
  ifstream file;
  string line;
  file.open(way);
  if(file.is_open()){
    getline(file,line);
    int NumLines = stoi(line)
    for(int i=0;i<NumLines;i++){
      
    }

  }
  
}

