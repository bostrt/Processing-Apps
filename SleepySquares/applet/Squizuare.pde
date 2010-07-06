public class Squizuare{
  private int x; 
  private int y;
  private int big;
  private int alive;

  /** Constructor **/
  public Squizuare(int x, int y, int s){
    this.x = x;
    this.y = y;
    big = s;
    alive = 0;
  }

  /** Wake up a square **/
  public void wakeUp(){
    alive = 255;
  }

  /** Square dozes off **/
  public void doze(){
    alive -= 12; 
    /** Correct if you go negative **/
    if(alive < 0)
      alive = 0;
  }
  
  /** Draw the square **/
  public void drawSq(){
   if(alive > 0){
     doze();
   }
   fill(alive);
   rect(x,y,big,big); 
  }
  
  public int getX(){
   return x; 
  }
  
  public int getY(){
   return y; 
  }
  
  public int getAlive(){
   return alive; 
  }
}

