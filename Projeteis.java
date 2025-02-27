import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projeteis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projeteis extends Actor
{
    private int direction;
    private int contadorVida = 80;
    
     public Projeteis(int mouseX, int mouseY) {
        direction = getRotation();
        turnTowards(mouseX, mouseY);
        direction = getRotation();
    }
    
    public void act() {
        move(10); 
        checkCollision();
        tempoDeVida();
}

private void checkCollision() {
         if (isTouching(Inimigos.class)) {
            Inimigos inimigo = (Inimigos) getOneIntersectingObject(Inimigos.class);
            if (inimigo != null && inimigo.noColisionTime()) {
                inimigo.TakeDamage(50);
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

