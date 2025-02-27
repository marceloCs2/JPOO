import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaDerrota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaDerrota extends Actor
{
    private Tempo tempo;
    private String prefix;
    
    public TelaDerrota() {
        prefix = "Você morreu! ";
        setImage(new GreenfootImage(prefix , 24, Color.WHITE, Color.BLACK));
    }
}
