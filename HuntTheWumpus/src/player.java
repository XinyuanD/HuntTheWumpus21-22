import java.util.Random;
import java.util.stream.IntStream;
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
  }
  
  //moves player from room to room
  public void moveAbove(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[0])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[0]-1];
    } else {
      System.out.println("You can't go there!");
    }
  }

  public void moveBellow(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[1])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[1]-1];
    } else {
      System.out.println("You can't go there!");
    }
  }

  public void moveTopLeft(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[2])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[2]-1];
    } else {
      System.out.println("You can't go there!");
    }
  }

  public void moveTopRight(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[3])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[3]-1];
    } else {
      System.out.println("You can't go there!");
    }
  }

  public void moveBottomLeft(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[4])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[4]-1];
    } else {
      System.out.println("You can't go there!");
    }
  }

  public void moveBottomRight(){
    if (IntStream.of(currentRoom.getConnected()).anyMatch(n -> n == currentRoom.getAjacent()[5])){
      currentRoom = game.getCave()[currentRoom.getAjacent()[5]-1];
    } else {
      System.out.println("You can't go there!");
    }
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

