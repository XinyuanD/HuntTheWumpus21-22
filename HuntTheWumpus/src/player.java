public class game {
    private int rBound = 5;
    private int bBound = 9;
    private int roomCount = ((bBound/2)*(rBound+1)) + 1 + rBound;
    private int map = 1;

    private room[] cave = new room[roomCount];
    private player player;


    private int[][] tunnels1 = {
      
      {25, 2}, //room 1
      {1, 3, 8}, //room 2
      {2, 26}, //room 3
      {28, 11}, //room 4
      {29, 6},//room 5
      {5},//room 6
      {12, 13}, //room 7
      {2, 15},//room 8
      {10},//room 9
      {9, 15, 11},//room 10
      {4, 10 , 17},////room 11
      {7, 13},//room 12
      {12, 7, 19},//room 13
      {19, 21},//room 14
      {8, 10},//room 15
      {22, 17},//room 16
      {16, 11, 18},//room 17
      {17, 24},//room 18
      {13, 14, 20},//room 19
      {19, 27},//room 20
      {14, 22, 27},//room 21
      {22, 16, 23},//room 22
      {22, 24},//room 23
      {18, 23, 30},//room 24
      {1, 26},//room 25
      {25, 3},//room 26
      {20, 21},//room 27
      {4, 29},//room 28
      {28, 5, 30},//room 29
      {29, 24},//room 30
     };

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
        this.player = new player(this);
        wumpus wumpus = new wumpus(this);
    }

    public game(){
        for (int i = 0; i < cave.length; i++){
            cave[i] = new room(i+1, this);
        }
        this.player = new player(this);
        wumpus wumpus = new wumpus(this);
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
        return this.player;
    }

    public int getRBound(){
        return rBound;
    }
    
    public int getBBound(){
        return bBound;
    }

    public int[][] getTunnels(){
      if(map == 1){
        return tunnels1;
      }
      return tunnels1;
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
