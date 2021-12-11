class room {
    private game game;
    private int val;
    private int above;
    private int bellow;
    private int leftTop;
    private int leftBot;
    private int rightTop;
    private int rightBot;
    private int[] ajacentRooms = {above, bellow, leftTop, rightTop, leftBot, rightBot};
    private int[] connectedRooms;
    private int collum;
    private int row;
    private int tBound;
    private int bBound;
    private int lBound;
    private int rBound;

  public room[] door = new room[3];

  public room(int val, game game){

    bBound = game.getBBound();
    rBound = game.getRBound();

      this.game = game;
    this.val = val;
    collum = (val % (rBound+1)) - 1;

    if(collum == -1){
      collum = rBound;
    }

    int rowDuo = (val-1)/(rBound+1);
    row = rowDuo*2;
    if(val % 2 == 0){
      row++;
    }

    aboveCalc();
    bellowCalc();
    topLeft();
    topRight();
    botLeft();
    botRight();
    int[] aRooms ={above, bellow, leftTop, rightTop, leftBot, rightBot};
    this.ajacentRooms = aRooms;
    this.connectedRooms = game.getTunnels()[val-1];
  }


  public int cRToVal(int collum, int row){
    return ((row/2)*(rBound+1)) + 1 + collum;
  }

  public void aboveCalc(){
    if((row - 2) < tBound){
      above = cRToVal(collum, row + bBound-1);
    } else{
      above = cRToVal(collum, row - 2);
    }
  }

  public void bellowCalc(){
    if((row + 2) > bBound){
      bellow = cRToVal(collum, row - bBound+1);
    } else{
      bellow = cRToVal(collum, row + 2);
    }
  }

  public void topLeft(){
    int x, y;
    if(row - 1 < tBound){
      y = row + bBound;
    } else{
      y = row - 1;
    }

    if(collum - 1 < lBound){
      x = collum + rBound;
    } else {
      x = collum - 1;
    }
    leftTop = cRToVal(x, y);
  }

  public void topRight(){
    int x, y;
    if(row - 1 < tBound){
      y = row + bBound;
    } else{
      y = row - 1;
    }
    
    if(collum + 1 > rBound){
      x = collum - rBound;
    } else {
      x = collum + 1;
    }
    rightTop = cRToVal(x, y);
  }

  public void botLeft(){
    int x, y;
    if(row + 1 > bBound){
      y = row - bBound;
    } else{
      y = row + 1;
    }

    if(collum - 1 < lBound){
      x = collum + rBound;
    } else {
      x = collum - 1;
    }
    
    leftBot = cRToVal(x, y);
 }

  public void botRight(){
    int x, y;
    if(row + 1 > bBound){
      y = row - bBound;
    } else{
      y = row + 1;
    }

    if(collum + 1 > rBound){
      x = collum - rBound;
    } else {
      x = collum + 1;
    }
    
    rightBot = cRToVal(x, y);
  }

  public int getVal(){
      return val;
  }

  public int[] getAjacent(){
      return ajacentRooms;
  }

  public int getCollum(){
      return collum;
  }

  public int getRow(){
    return row;
  }

  public game getGame(){
      return game;
  }

  public int[] getConnected(){
    return connectedRooms;
  }

  public void roomData(){
    System.out.println("Room Number: " + val);
    System.out.println("Above: " + above);
    System.out.println("Bellow: " + bellow);
    System.out.println("Top Left: " + leftTop);
    System.out.println("Top right: " + rightTop);
    System.out.println("Bottom Left: " + leftBot);
    System.out.println("Bottom Right: " + rightBot);
    System.out.println("  " + above);
    System.out.println(leftTop + "   " + rightTop);
    System.out.println("  " + val);
    System.out.println(leftBot + "   " + rightBot);
    System.out.println("  " + bellow);

  }

}
