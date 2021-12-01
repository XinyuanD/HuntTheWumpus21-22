//put some player pseudocode in here

//what methods we want, etc.

public class player { 
  
  //DATA
 public room currentRoom;
 public int numArrows;
 //int score 
  //we can either put score as a property of this object or make it something else entirely
  
  
  //created object
  public player(room room, int numArrows) {
    this.currentRoom = room;
    this.numArrows = numArrows;
  }
  
  //moves player from room to room
  public void moveAbove(){
    currentRoom = Main.rooms[currentRoom.above-1];
  }

  public void moveBellow(){
    currentRoom = Main.rooms[currentRoom.bellow-1];
  }

  public void moveTopLeft(){
    currentRoom = Main.rooms[currentRoom.leftTop-1];
  }

  public void moveTopRight(){
    currentRoom = Main.rooms[currentRoom.rightTop-1];
  }

  public void moveBottomLeft(){
    currentRoom = Main.rooms[currentRoom.leftBot-1];
  }

  public void moveBottomRight(){
    currentRoom = Main.rooms[currentRoom.rightBot-1];
  }

  //classic getters. we can put the setters later. this will be important for updating the player's stage
  //wumpus will have similar structure
  public room getRoom() {
    return currentRoom;
  }
  
  public int getNumArrows() {
    return numArrows;
  }
  
  //next will be a spawn method to put in a random room
  
  
}
