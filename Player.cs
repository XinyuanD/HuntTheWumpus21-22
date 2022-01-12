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
    this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
    this.game = game;
  }

  // position is which room relative to room you want to check
  // example: position should be 0 if you want to check the room above
  // {above, bellow, leftTop, rightTop, leftBot, rightBot};
  public bool isConnected(room room, int position){
    bool connected = false;
    for (int i=0; i < room.getConnected().Length; i++){
      if (room.getAjacent()[position] == room.getConnected()[i]){
        connected = true;
      }
    }
    return connected;
  }
  
  //moves player from room to room
  public void moveAbove(){

    if (isConnected(currentRoom, 0)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[0]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveBellow(){
    if (isConnected(currentRoom, 1)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[1]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveTopLeft(){
    if (isConnected(currentRoom, 2)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[2]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveTopRight(){
    if (isConnected(currentRoom, 3)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[3]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveBottomLeft(){
    if (isConnected(currentRoom, 4)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[4]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveBottomRight(){
    if (isConnected(currentRoom, 5)){
      currentRoom = game.getCave()[currentRoom.getAjacent()[5]-1];
    } else {
      Console.WriteLine("You can't go there!");
    }
  }

  public void moveRoom(room room){
    this.currentRoom = room;
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
    Console.WriteLine("The player is now in room: " + currentRoom.getVal());
  }
  
  //next will be a spawn method to put in a random room
  
  
}