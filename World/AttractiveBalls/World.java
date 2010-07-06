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

public class World extends PApplet {


ArrayList balls;
int x1;
int y1;
static int ballSize = 10;
boolean stems = false;
boolean REPAINT = true;
static int padding = 10;
boolean kelly = true;

public void setup(){
  size(600,600);
  balls = new ArrayList();
}

/**
 *  Add a ball to the ArrayList at current mouse position
 */
public void addBall(){

  // Store current mouse position
  x1 = mouseX;
  y1 = mouseY;
  // Get a random offset for the ball 
  int xDiff = (int)random(-10,10);
  int yDiff = (int)random(-10,10);
  // Add the mouse's (x,y) and the random offset
  int x = mouseX+xDiff;
  int y = mouseY+yDiff;
  // Create new ball
  Ball b = new Ball(x,y,ballSize);
  b.STEM = stems;
  b.attract = kelly;
  balls.add(b);
}

public void draw(){

  if(REPAINT)
    background(46);
  smooth();
  update();
}

/**
 *  If a key is pressed perform the respective actions
 */
public void keyPressed(){

  // Add 'stems' to the balls
  if(keyCode == SHIFT){
    stems = !stems;
    for(int i = 0; i < balls.size(); i++){
      Ball b = (Ball) balls.get(i);
      b.STEM = stems;
    }
  }
  // toggle repaint background
  else if(key == 'b')
    REPAINT = !REPAINT;
  // Empty the ArrayList of Balls
  else if(key == 'x')
    balls.clear();
  // Add a ball
  else if(key == 'f')
    addBall();
}

/**
  *  If mouse pressed then toggle ball attraction to mouse
  */
public void mousePressed(){
   if(mouseButton == LEFT) 
      kelly = !kelly; 
}

/** 
 * Update all of the Ball's and draw them
 */
public void update(){

  if(balls.size() != 0){
    
    for(int i = 0; i < balls.size(); i ++){
      Ball b = (Ball) balls.get(i);
      b.update();
      b.attract = kelly;
      b.drawBall();
    }
  }
}




class Ball{

  public float x;
  public float y;
  private float diameter;
  public float dx;
  public float dy;
  private int[] chroma;
  public boolean STEM = false;
  public boolean attract = true;

  /**
    *  Constructor for Ball
    *  Takes position (x,y), diameter, 
    */
  public Ball(float x, float y, float diam){
    this.x = x;
    this.y = y;
    diameter = diam;
    dx = 0;
    dy = 0;

    // Get some colour
    chroma = new int[3];
    chroma[0] = (int) random(255);
    chroma[1] = (int) random(255);
    chroma[2] = (int) random(255);
  }

  /** Update ball's position **/
  public void update(){

    // Attract the balls toward mouse
    if(attract){
      dx += (mouseX-x)/dist(mouseX,mouseY,x,y);
      dy += (mouseY-y)/dist(mouseX,mouseY,x,y);
    }
    // Balls run away from mouse
    else if(!attract){
      dx -= (mouseX-x)/dist(mouseX,mouseY,x,y);
      dy -= (mouseY-y)/dist(mouseX,mouseY,x,y);
    }

    // Update ball's (x,y)
    x += dx;
    y += dy;

    /** If collision with top or bottom **/
    if(y + dy >= height-World.padding || y + dy <= World.padding)
      bounce();

    /** If collision with wall **/
    if(x + dx >= width-World.padding || x + dx <= World.padding)
      bounceWall();
  }

  public void bounce(){
    /** reflect ball with a little friction **/
    dy = -dy/1.25f; 
  }

  public void bounceWall(){
    /** reflect ball and include a little friction **/
    dx = -dx/1.25f; 
  }

  public void drawBall(){
    fill(chroma[0], chroma[1], chroma[2]);
    ellipse(x, y, diameter, diameter);
    if(STEM){
      strokeWeight(1);
      line(x,y,mouseX,mouseY);
    }
  }

}







  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "World" });
  }
}
