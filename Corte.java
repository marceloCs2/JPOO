import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corte extends Actor
{
    private int direction;
    private int contadorVida = 20;
    private GreenfootSound somCorte;
    private GreenfootSound somFaca;
    public Corte(int mouseX, int mouseY) {
        direction = getRotation();
        turnTowards(mouseX, mouseY);
        direction = getRotation();
        somFaca = new GreenfootSound("knife.mp3");
        somFaca.setVolume(40);
        somFaca.play();
    }

    public void act() {
        move(10); 
        checkCollision();
        tempoDeVida();
}

 private void checkCollision() {
         if (isTouching(Inimigos.class)) {
            Inimigos inimigo = (Inimigos) getOneIntersectingObject(Inimigos.class);
          somCorte = new GreenfootSound("somFaca.mp3");
          somCorte.setVolume(40);
          somCorte.play();
            if (inimigo != null) {
                inimigo.TakeDamage(20);
                inimigo.move(-50);
                getWorld().removeObject(this);  
            }
             else if (isAtEdge()){
            getWorld().removeObject(this); 
            }
        }
    }

    private void tempoDeVida(){
         contadorVida--;
         if(contadorVida <= 0){
            getWorld().removeObject(this);
            }
    }
    
}
