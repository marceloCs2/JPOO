import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TelaVitoria extends Actor
{
    private Tempo tempo;
    private String prefix;
    
    public TelaVitoria() {
        prefix = "Você sobreviveu! ";
        setImage(new GreenfootImage(prefix , 24, Color.WHITE, Color.BLACK));
    }
}