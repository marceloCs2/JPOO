import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Revolver extends Armas
{
    private int bullets = 1000;
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
               Projeteis projetil = new Projeteis(mouseX, mouseY);
               somTiro = new GreenfootSound("somPistola2.mp3");
               somTiro.setVolume(40);
               somTiro.play();
               getWorld().addObject(projetil, getX(), getY());
               projetil.turnTowards(mouseX, mouseY);
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
