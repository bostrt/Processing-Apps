import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class DiscoSquares extends PApplet {

int big = 8;
int numSquare;
Squizuare[ ] s;

public void setup(){  
  
  size(512, 512);
  
  /** initialize array **/
  numSquare = (int) sq(width/big);
  s = new Squizuare[numSquare];
  
  int i = 0;
  for(int x = 0; x < width; x+=big){
    for(int y = 0; y < height; y+=big){
      
       s[i] = new Squizuare(x,y,big);
       i++;
    } 
  } 
  
  background(0);
}


Squizuare square;
public void draw(){

  for(int i = 0; i < numSquare; i++){
    
    square = s[i];
    if(contains(square.getX(), square.getY(), big)){
      
       square.wakeUp(); 
    }
      square.drawSq();
  }
}

/** Check if mouse is inside a square **/
public boolean contains(int x, int y, int diff){
  
  if(mouseX >= x && mouseX <= x+diff)
   if(mouseY >= y && mouseY <= y+diff)
      return true;
      
  return false;
}
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



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "DiscoSquares" });
  }
}
