//wumpus, we can use a lot of stuff from player here
//we just need random spawn, which we can take from wumpus
//and a static boolean isalive for our game play to see if its alive then continue or else if false then game over
import java.util.Random;
import java.util.stream.IntStream;
public class wumpus {
   
  //probably just a static boolean to reference in the game play or even in player
   //we could have a script just for specific game play, our main, where it starts, launches, has player take move as long as isAlive == true
    private boolean isAlive;
    private room currentRoom;
    private game game;
  
  //spawns
  public wumpus(game game) {
     Random rand = new Random();
     while (this.currentRoom != game.getPlayer().getRoom()){
      this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
     }
     this.game = game;
     //picks random room
     System.out.print(game.getPlayer().getRoom());
     //says its alive
     isAlive = true; 
   
  }
  
   //sets room
  public wumpus(room currentRoom) {
     this.currentRoom = currentRoom;
     
  }

  public void move2to4RandomRoom(){
    room startroom = currentRoom;
    Random rand = new Random();
    int moves = rand.nextInt(2) + 2;
    int[] visted = new int[moves+1];
    visted[0] = currentRoom.getVal();
    for (int i = 0; i < moves; i++){
      int nextRoom = rand.nextInt(currentRoom.getConnected().length);
      if(IntStream.of(visted).anyMatch(n -> n == currentRoom.getConnected()[nextRoom])){
        currentRoom = startroom;
        move2to4RandomRoom();
      } else{
        currentRoom = game.getCave()[currentRoom.getConnected()[nextRoom]-1];
        visted[i+1] = currentRoom.getVal();
      }
    }
  }

  public void moveRandomRoom(){
    Random rand = new Random();
    currentRoom = game.getCave()[currentRoom.getConnected()[rand.nextInt(currentRoom.getConnected().length)]-1];
  }

  public boolean isAlive(){
      return isAlive;
  }

  public room getRoom(){
      return currentRoom;
  }

  public game getGame(){
    return game;
  }
  
}
