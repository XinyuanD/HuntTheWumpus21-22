using System;
using System.Collections;
namespace Wumpus{
public class game {
    private int rBound;
    private int bBound;
    private int roomCount;
    private int map = 1;

    private room[] cave;
    private player player;


    private int[][] tunnels1 = {
      
      new int[]{25, 2}, //room 1
      new int[]{1, 3, 8}, //room 2
      new int[]{2, 26}, //room 3
      new int[]{28, 11}, //room 4
      new int[]{29, 6},//room 5
      new int[]{5},//room 6
      new int[]{12, 13}, //room 7
      new int[]{2, 15},//room 8
      new int[]{10},//room 9
      new int[]{9, 15, 11},//room 10
      new int[]{4, 10 , 17},////room 11
      new int[]{7, 13},//room 12
      new int[]{12, 7, 19},//room 13
      new int[]{19, 21},//room 14
      new int[]{8, 10},//room 15
      new int[]{22, 17},//room 16
      new int[]{16, 11, 18},//room 17
      new int[]{17, 24},//room 18
      new int[]{13, 14, 20},//room 19
      new int[]{19, 27},//room 20
      new int[]{14, 22, 27},//room 21
      new int[]{22, 16, 23},//room 22
      new int[]{22, 24},//room 23
      new int[]{18, 23, 30},//room 24
      new int[]{1, 26},//room 25
      new int[]{25, 3},//room 26
      new int[]{20, 21},//room 27
      new int[]{4, 29},//room 28
      new int[]{28, 5, 30},//room 29
      new int[]{29, 24},//room 30
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
        
        for (int i = 0; i < cave.Length; i++){
            cave[i] = new room(i+1, this);
        }
        this.player = new player(this);
        wumpus wumpus = new wumpus(this);
    }

    public game(){
      this.rBound = 5;
      this.bBound = 9;
      this.cave = new room[30];
      for (int i = 0; i < cave.Length; i++){
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
        string[,] roomDisplay = new string[bBound+1, rBound+1];
        for(int i = 0; i<rBound+1; i++){
          for(int j = 0; j<bBound+1; j++){
            roomDisplay[j, i] = " ";
          }
        }
        for(int i = 0; i < cave.Length; i++){
          if(cave[i].getVal() < 10){
            roomDisplay[cave[i].getRow(), cave[i].getCollum()] = cave[i].getVal() + " ";
          } else {
            roomDisplay[cave[i].getRow(), cave[i].getCollum()] = cave[i].getVal() + "";
          }
        }
    
        for(int i = 0; i<bBound+1; i++){
          Console.WriteLine();
          for(int j = 0; j<rBound+1; j++){
            Console.Write(roomDisplay[i, j]);
          }
        }
        Console.WriteLine();
      }

}
}
