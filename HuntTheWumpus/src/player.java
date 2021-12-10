import java.util.Random;
public class player {
    //put some player pseudocode in here
  
  //DATA
 public int numArrows = 3;
 public game game;
 public room currentRoom;
 
 //int score 
  //we can either put score as a property of this object or make it something else entirely
  
  
  //created object
  public player(room room, game game) {
    this.currentRoom = room;
    this.game = game;
    currentRoom = game.getCave()[0];
  }
  //if no spawning room provided, spawns in a random room
  public player(game game) {
    Random rand = new Random();
    //picks random room
    this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
    this.game = game;
    currentRoom = game.getCave()[0];
  }
  
  //moves player from room to room
  public void moveAbove(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[0]-1];
  }

  public void moveBellow(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[1]-1];
  }

  public void moveTopLeft(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[2]-1];
  }

  public void moveTopRight(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[3]-1];
  }

  public void moveBottomLeft(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[4]-1];
  }

  public void moveBottomRight(){
    currentRoom = game.getCave()[currentRoom.getAjacent()[5]-1];
  }

  //classice getters. we can put the setters later. this will be important for updating the player's stage
  //weumpus will have similar structure
  public room getRoom() {
    return currentRoom;
  }
  
  public int getNumArrows() {
    return numArrows;
  }

  public void printCurrentRoom(){
    System.out.println("The player is now in room: " + currentRoom.getVal());
  }
  
  //next will be a spawn method to put in a random room
  
  
}

