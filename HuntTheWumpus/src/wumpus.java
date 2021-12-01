
//wumpus, we can use a lot of stuff from player here
//we just need random spawn, which we can take from wumpus
//and a static boolean isalive for our game play to see if its alive then continue or else if false then game over
import java.util.Random;
public class Wumpus {
   
  //probably just a static boolean to reference in the game play or even in player
   //we could have a script just for specific game play, our main, where it starts, launches, has player take move as long as isAlive == true
  public static boolean isAlive;
   public room currentRoom; 
  
  //spawns
  public Wumpus() {
     Random rand = new Random();
     //picks random room
     this.currentRoom = Main.rooms[rand.nextInt(Main.rooms.length-1)];
     //says its alive
     isAlive = true; 
   
  }
  
   //sets room
  public wumpus(room currentRoom) {
     this.currentRoom = currentRoom;
     
  }
   
  
  
}
