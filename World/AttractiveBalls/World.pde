
ArrayList balls;
int x1;
int y1;
static int ballSize = 10;
boolean stems = false;
boolean REPAINT = true;
static int padding = 10;
boolean kelly = true;

void setup(){
  size(600,600);
  balls = new ArrayList();
}

/**
 *  Add a ball to the ArrayList at current mouse position
 */
void addBall(){

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

void draw(){

  if(REPAINT)
    background(46);
  smooth();
  update();
}

/**
 *  If a key is pressed perform the respective actions
 */
void keyPressed(){

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
void mousePressed(){
   if(mouseButton == LEFT) 
      kelly = !kelly; 
}

/** 
 * Update all of the Ball's and draw them
 */
void update(){

  if(balls.size() != 0){
    
    for(int i = 0; i < balls.size(); i ++){
      Ball b = (Ball) balls.get(i);
      b.update();
      b.attract = kelly;
      b.drawBall();
    }
  }
}




