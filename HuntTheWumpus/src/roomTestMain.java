class Main {
  public static room[] rooms = new room[room.roomCount()];

  public static void roomsToString(){
    room lastRoom = rooms[rooms.length-1];
    String[][] roomDisplay = new String[lastRoom.rBound+1][lastRoom.bBound+1];
    for(int i = 0; i<lastRoom.rBound+1; i++){
      for(int j = 0; j<lastRoom.bBound+1; j++){
        roomDisplay[i][j] = " ";
      }
    }
    for(int i = 0; i < rooms.length; i++){
      if(rooms[i].val < 10){
        roomDisplay[rooms[i].collum][rooms[i].row] = rooms[i].val + " ";
      } else {
        roomDisplay[rooms[i].collum][rooms[i].row] = rooms[i].val + "";
      }
    }

    for(int i = 0; i<lastRoom.bBound+1l; i++){
      System.out.println();
      for(int j = 0; j<lastRoom.rBound+1; j++){
        System.out.print(roomDisplay[j][i]);
      }
    }

  }

  public static void main(String[] args) {
    for (int i = 0; i < rooms.length; i++){
      rooms[i] = new room(i+1);
    }
    rooms[2].roomData();
    System.out.println(room.roomCount() + " rooms");  
    roomsToString();  
  }

}
