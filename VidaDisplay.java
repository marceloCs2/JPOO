import greenfoot.*;  // Importando as classes do Greenfoot

public class VidaDisplay extends Actor {
    private Personagem player;
    private String prefix;
    public VidaDisplay(Personagem player) {
        this.player = player;
        prefix = "Vida: ";
    }

    
     private void updateImage() {
        setImage(new GreenfootImage(prefix + player.life, 24, Color.WHITE, Color.BLACK));
    }

    public void act() {
        updateImage();
    }
}

