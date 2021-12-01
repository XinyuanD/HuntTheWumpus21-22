//put some player pseudocode in here

//what methods we want, etc.

public class Player { 
  
  //DATA
 int roomNum;
 int numArrows;
 //int score 
  //we can either put score as a property of this object or make it something else entirely
  
  
  //created object
  public Player(int roomNum, int numArrows) {
    this.roomNum = roomNum;
    this.numArrows = numArrows;
  }
  
  
  //classice getters. we can put the setters later. this will be important for updating the player's stage
  //weumpus will have similar structure
  public getRoom() {
    return roomNum;
  }
  
  public getNumArrows() {
    return numArrows;
  }
  
  //next will be a spawn method to put in a random room
  
  
}
