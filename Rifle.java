import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rifle extends Armas
{
    private int bullets = 100;
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
               somTiro = new GreenfootSound("somPistola2.mp3");
               somTiro.setVolume(30);
               somTiro.play();
               for (int i = -1; i <= 1; i++) {
                Projeteis projetil = new Projeteis(mouseX, mouseY);
                getWorld().addObject(projetil, getX(), getY());
                projetil.turnTowards(mouseX, mouseY);
                projetil.setRotation(projetil.getRotation() + (i * 5));
            }
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
