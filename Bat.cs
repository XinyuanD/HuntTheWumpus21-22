using System;
using System.Collections;

namespace Wumpus{
public class bats {

    // two rooms
    private room currentRoom;
    private game game;
    private static ArrayList allBats;
    private static ArrayList batRooms;
    private int batNumber = 0;

    public bats(game game) {
        allBats = new ArrayList();
        batRooms = new ArrayList();
        // spawn a bat in a random room
        Random rand = new Random();
        allBats.Add(this);
        batNumber = allBats.Count;

        this.game = game;
        this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.Contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
        }
        batRooms.Add(this.currentRoom);
    }


    // find a new room not equal to the current room
    public void changeRoom() {
        Random rand = new Random();
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.Contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
        }
        game.getPlayer().moveRoom(currentRoom);
        batRooms.Insert(batNumber, currentRoom);
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.Contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.Next(game.getCave().Length)];
        }
        batRooms.Insert(batNumber, currentRoom);
    }

    public room getRoom(){
        return currentRoom;
    }

    public game getGame(){
        return game;
    }
    public static ArrayList getBats(){
        return allBats;
    }
    public static ArrayList getBatRooms(){
        return batRooms;
    }
}
}
