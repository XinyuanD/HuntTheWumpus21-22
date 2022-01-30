using System;
using System.Collections;
//wumpus, we can use a lot of stuff from player here
//we just need random spawn, which we can take from wumpus
//and a static boolean isalive for our game play to see if its alive then continue or else if false then game over
namespace Wumpus
{
public class wumpus {
   
  //probably just a static boolean to reference in the game play or even in player
   //we could have a script just for specific game play, our main, where it starts, launches, has player take move as long as isAlive == true
    private bool alive;
    private room currentRoom;
    private game game;
  
  //spawns
  public wumpus(game game) {
     Random rand = new Random();
     while (this.currentRoom != game.getPlayer().getRoom()){
      this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
     }
     this.game = game;
     //picks random room
     //says its alive
     alive = true; 
   
  }
  
   //sets room
  public wumpus(room currentRoom, game game) {
     this.currentRoom = currentRoom;
     this.game = game;
     
  }

  public void move2to4RandomRoom(){
    Random rand = new Random();
    int moves = rand.Next(3) + 2;
    bool[] visited = new bool[game.getRoomCount()];
    visited[currentRoom.getVal()-1] = true;
    int numVisited = 0;
    while (numVisited <= moves){
      int nextRoom = rand.Next(currentRoom.getConnected().Length);
      if(!visited[currentRoom.getConnected()[nextRoom]]){
        currentRoom = game.getCave()[nextRoom];
        visited[nextRoom] = true;
        numVisited++;
      }
    }
  }

  public void moveRandomRoom(){
    Random rand = new Random();
    currentRoom = game.getCave()[currentRoom.getConnected()[rand.Next(currentRoom.getConnected().Length)]-1];
  }

  public bool isAlive(){
      return alive;
  }

  public room getRoom(){
      return currentRoom;
  }

  public game getGame(){
    return game;
  }
  
}
}
