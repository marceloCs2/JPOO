import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ShotgunProjetil extends Actor
{
     private int direction;
    private int contadorVida = 20;
    private GreenfootSound somTiro;
    public ShotgunProjetil(int mouseX, int mouseY) {
        direction = getRotation();
        turnTowards(mouseX, mouseY);
        direction = getRotation();
    }

    public void act() {
        move(20); 
        checkCollision();
        tempoDeVida();
        
}

 private void checkCollision() {
         if (isTouching(Inimigos.class)) {
            Inimigos inimigo = (Inimigos) getOneIntersectingObject(Inimigos.class);
            if (inimigo != null) {
                inimigo.TakeDamage(100); 
                inimigo.move(-40);
                getWorld().removeObject(this);  
            }
            else if (isAtEdge()) {
            World world = getWorld();
            world.removeObject(this);
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
