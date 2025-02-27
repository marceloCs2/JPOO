import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Soldado extends Personagem
{ 
    public boolean estaMorto = false;
    private GreenfootImage normalImage;
    private GreenfootImage clickedImage;
    private GreenfootSound somFala;
    public Soldado() {
        normalImage = new GreenfootImage("SoldadoDireita.png");
        clickedImage = new GreenfootImage("SoldadoEsquerda.png");
        setImage(normalImage);
        arma = new Faca();
        estaMorto = false;
    }
    
    public void act()
    {
        super.act();
    }
    
    @Override
    protected void checkKeyParaAlterarDirecao()
    {
        if (Greenfoot.isKeyDown("d")) {
            setImage(normalImage);
        } else if (Greenfoot.isKeyDown("a")) {
            setImage(clickedImage);
        }
    }
    
     @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.addObject(arma, getX() + 30, getY() -15); 
    }
    
    @Override 
     public void Falar() {
    if (canTalk()) {
        somFala = new GreenfootSound("hurt.mp3");
        somFala.setVolume(40);
        somFala.play();
    }
}
}
