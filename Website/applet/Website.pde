

PImage img;
PFont text;
/** The following arrays contain the X, Y, width, and height
    of the link boxes. They go like this:
    {x, y, width, height} **/
int[] links = {10, 116, 88, 73};
int[] javaApps = {228, 9, 102, 61};
int[] contact = {371, 96, 73, 39};
int[] me = {433, 164, 52, 42};
int[] playground = {530, 276, 55, 88};

int[] oldSite = {20,20, 100, 50};

void setup(){
 size(600,570);
 background(70);
 
 text = createFont("Arial", 10);
 textFont(text);
 
 img = loadImage("drawing.png");
 img.resize(img.width/2, img.height/2);
 image(img,0,0);
 
 //
 // REMOVE WHEN FINISHED
 //
 fill(150);
 rect(oldSite[0], oldSite[1], oldSite[2], oldSite[3]);
 fill(255);
 text("CLICK HERE \nFOR OLD SITE",oldSite[0]+15, oldSite[1]+15);
}

void draw(){
  /** Save some power **/
  delay(10);
}

void mouseClicked(){
  checkMouse(); 
}

void checkMouse(){
  if(mouseX >= links[0] && mouseY >= links[1] 
      && mouseX <= links[0]+links[2] && mouseY <= links[1]+links[3])
      openLinks();
      
  else if(mouseX >= javaApps[0] && mouseY >= javaApps[1] 
      && mouseX <= javaApps[0]+javaApps[2] && mouseY <= javaApps[1]+javaApps[3])
      openJavaApps();
      
  else if(mouseX >= contact[0] && mouseY >= contact[1] 
      && mouseX <= contact[0]+contact[2] && mouseY <= contact[1]+contact[3]) 
      openContact();
      
  else if(mouseX >= me[0] && mouseY >= me[1] 
      && mouseX <= me[0]+me[2] && mouseY <= me[1]+me[3])
      openMe();
      
  else if(mouseX >= playground[0] && mouseY >= playground[1] 
      && mouseX <= playground[0]+playground[2] && mouseY <= playground[1]+playground[3])
      openPlayground();
  //
  // REMOVE WHEN FINISHED
  //
  else if(mouseX >= oldSite[0] && mouseY >= oldSite[1] 
      && mouseX <= oldSite[0]+oldSite[2] && mouseY <= oldSite[1]+oldSite[3])
      oldSite();
}

void oldSite(){
  link("http://student.cs.appstate.edu/bostrt/oldWebsite.php"); 
}

void openLinks(){
  text("WORK IN PROGRESS!!", 20, 20);

}

void openJavaApps(){
  text("WORK IN PROGRESS!!", 20, 20);

}

void openPlayground(){
  text("WORK IN PROGRESS!!", 20, 20);


}

void openMe(){
  text("WORK IN PROGRESS!!", 20, 20);

}

void openContact(){
  text("WORK IN PROGRESS!!", 20, 20);

}

void openProcessingApps(){
  
}
