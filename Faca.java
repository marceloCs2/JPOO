import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Faca extends Armas
{   
    int bullets = 0;
    
    @Override
    public void usarArma()
    {
         if (Greenfoot.mousePressed(null)){
           MouseInfo mouse = Greenfoot.getMouseInfo();
           if (mouse != null) {
               int mouseX = mouse.getX();
               int mouseY = mouse.getY();
               Corte corte = new Corte(mouseX, mouseY);
               getWorld().addObject(corte, getX(), getY());
               corte.turnTowards(mouseX, mouseY);
           }
        }
    }
    
    public void act()
    {
      super.act();
    }}
