import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tempo extends Actor {
    private int startTime;  
    private String prefix;
    public int segundos = 0;

   
    public Tempo() {
        startTime = 0;  
        prefix = "Tempo: ";  
        updateImage(0);  
    }

  
    public void act() {
        startTime++;
         if (startTime == 100) {
            segundos++;
            startTime = 0;
        }
        updateImage(segundos);  
    }
    
    public int getSeconds(){
     return this.segundos;
    }

    
    private void updateImage(int segundos) {
        setImage(new GreenfootImage(prefix + segundos, 24, Color.WHITE, Color.BLACK));
    }
}
