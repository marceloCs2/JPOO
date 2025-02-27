import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Shotgun extends Armas
{
    private int bullets = 50;
    private GreenfootSound emptyGun;
    private GreenfootSound somTiro;
    
    @Override
    public void usarArma()
    {
         if (Greenfoot.mousePressed(null)){
           MouseInfo mouse = Greenfoot.getMouseInfo();
           if (mouse != null && bullets >0) {
               bullets -= 1;
               int mouseX = mouse.getX();
               int mouseY = mouse.getY();
               ShotgunProjetil shotgunProjetil = new ShotgunProjetil(mouseX, mouseY);
               somTiro = new GreenfootSound("12.mp3");
               somTiro.setVolume(20);
               somTiro.play();
               getWorld().addObject(shotgunProjetil, getX(), getY());
               shotgunProjetil.turnTowards(mouseX, mouseY);
           }
           
           else
           {
            emptyGun = new GreenfootSound("emptyGun.mp3");
            emptyGun.setVolume(25);
            emptyGun.play();
            }
        }
    }
    
    public void act()
    {
        super.act();
    }
}
