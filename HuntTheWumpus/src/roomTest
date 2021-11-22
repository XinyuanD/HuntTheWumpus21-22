import java.util.Random;
class room {
  public int val;
  public int above;
  public int bellow;
  public int leftTop;
  public int leftBot;
  public int rightTop;
  public int rightBot;
  public int[] ajacentRooms = {above, bellow, leftTop, rightTop, leftBot, rightBot};
  public int collum;
  public int row;
  public boolean even;
  public static int tBound=0;
  public static int bBound=9;
  public static int lBound=0;
  public static int rBound=5;

  public room[] door = new room[3];

  public room(int val){
    this.val = val;
    if (val % 2 == 0){
      even = true;
    }
    collum = (val % (rBound+1)) - 1;

    if(collum == -1){
      collum = rBound;
    }

    int rowDuo = (val-1)/(rBound+1);
    row = rowDuo*2;
    if(even){
      row++;
    }

    aboveCalc();
    bellowCalc();
    topLeft();
    topRight();
    botLeft();
    botRight();
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

  public void roomData(){
    System.out.println("Room Number: " + val);
    System.out.println("Above: " + above);
    System.out.println("Bellow: " + bellow);
    System.out.println("Top Left: " + leftTop);
    System.out.println("Top right: " + rightTop);
    System.out.println("Bottom Left: " + leftBot);
    System.out.println("Bottom Right: " + rightBot);
  }

  public static int roomCount(){
    return ((bBound/2)*(rBound+1)) + 1 + rBound;
  }
}
