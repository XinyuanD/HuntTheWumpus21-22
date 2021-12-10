public class game {
    private int rBound = 5;
    private int bBound = 9;
    private int roomCount = ((bBound/2)*(rBound+1)) + 1 + rBound;

    private room[] cave = new room[roomCount];
    private player player;

    public game(int rBound, int bBound){
        //Make sure cave size is not buggy
        if(bBound % 2 == 0 || rBound % 2 == 0){
            throw new ArithmeticException("rBound or bBound is even!");
        }

        //Calculates room count
        this.roomCount = ((bBound/2)*(rBound+1)) + 1 + rBound;

        //cave is the array of rooms
        this.cave = new room[roomCount]; 

        this.bBound = bBound;
        this.rBound = rBound;
        
        for (int i = 0; i < cave.length; i++){
            cave[i] = new room(i+1, this);
        }
        player player = new player(this);
    }

    public game(){
        for (int i = 0; i < cave.length; i++){
            cave[i] = new room(i+1, this);
        }
        player player = new player(this);
    }

    public void createHazards(){

    }

    public int getRoomCount(){
        return roomCount;
    }

    public room[] getCave(){
        return cave;
    }

    public player getPlayer(){
        return player;
    }

    public int getRBound(){
        return rBound;
    }
    
    public int getBBound(){
        return bBound;
    }

    public void caveToString(){
        String[][] roomDisplay = new String[rBound+1][bBound+1];
        for(int i = 0; i<rBound+1; i++){
          for(int j = 0; j<bBound+1; j++){
            roomDisplay[i][j] = " ";
          }
        }
        for(int i = 0; i < cave.length; i++){
          if(cave[i].getVal() < 10){
            roomDisplay[cave[i].getCollum()][cave[i].getRow()] = cave[i].getVal() + " ";
          } else {
            roomDisplay[cave[i].getCollum()][cave[i].getRow()] = cave[i].getVal() + "";
          }
        }
    
        for(int i = 0; i<bBound+1l; i++){
          System.out.println();
          for(int j = 0; j<rBound+1; j++){
            System.out.print(roomDisplay[j][i]);
          }
        }
        System.out.println();
      }

}
