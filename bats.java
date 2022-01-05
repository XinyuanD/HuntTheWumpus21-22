
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class bats {

    // two rooms
    private room currentRoom;
    private game game;
    private static ArrayList<bats> allBats = new ArrayList<bats>();
    private static ArrayList<room> batRooms = new ArrayList<room>();
    private int batNumber = 0;

    public bats(game game) {
        // spawn a bat in a random room
        Random rand = new Random();
        allBats.add(this);
        batNumber = allBats.size();

        this.game = game;
        this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
        }
        batRooms.add(this.currentRoom);
    }


    // find a new room not equal to the current room
    public void changeRoom() {
        Random rand = new Random();
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
        }
        game.getPlayer().moveRoom(currentRoom);
        batRooms.set(batNumber, currentRoom);
        while (this.currentRoom == game.getPlayer().getRoom() || batRooms.contains(currentRoom)){
            this.currentRoom = game.getCave()[rand.nextInt(game.getCave().length-1)];
        }
        batRooms.set(batNumber, currentRoom);
    }

    public room getRoom(){
        return currentRoom;
    }

    public game getGame(){
        return game;
    }
    public static ArrayList<bats> getBats(){
        return allBats;
    }
    public static ArrayList<room> getBatRooms(){
        return batRooms;
    }
}
