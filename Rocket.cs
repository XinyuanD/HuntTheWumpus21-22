public class rocket {
    private game game;
    public rocket(game game){
        this.game = game;
    }

    public void travel(player player, room destination){
        player.setFuel(player.getNumFuel()-1);
        player.moveRoom(destination);
    }
}