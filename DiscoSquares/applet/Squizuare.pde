public class Squizuare{
  private int x; 
  private int y;
  private int big;
  private int alive;
  private int[] chroma;
  private int[] chromaOrig;

  /** Constructor **/
  public Squizuare(int x, int y, int s){
    this.x = x;
    this.y = y;
    big = s;
    alive = 0;
    chroma = new int[3];
    chromaOrig = new int[3];
    chroma[0] = (int)random(255);
    chroma[1] = (int)random(255);
    chroma[2] = (int)random(255);
    chromaOrig[0] = chroma[0];
    chromaOrig[1] = chroma[1];
    chromaOrig[2] = chroma[2];
  }

  /** Wake up a square **/
  public void wakeUp(){
    for(int i = 0; i < 3; i ++){
       chroma[i] = chromaOrig[i]; 
    }
  }

  /** Square dozes off **/
  public void doze(){

    for(int i = 0; i < 3; i++){
      chroma[i] -= 12; 
      /** Correct if you go negative **/
      if(chroma[i] < 0)
        chroma[i] = 0;
    }

  }

  /** Draw the square **/
  public void drawSq(){
    if(chroma[0] > 0 || chroma[1] > 0 || chroma[2] > 0){
      doze();
    }
    fill(chroma[0], chroma[1], chroma[2]);
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


