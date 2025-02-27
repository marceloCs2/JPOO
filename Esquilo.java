import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Esquilo extends Personagem {
    private GreenfootImage normalImage;
    private GreenfootImage clickedImage;
    private GreenfootImage[] andarDireita = new GreenfootImage[4];
    private GreenfootImage[] andarEsquerda = new GreenfootImage[4];
    private int animationCounter = 0;
    private int animationSpeed = 10; 
    private int currentFrame = 0;
    private GreenfootSound somEsquilo;

    public Esquilo() {
        normalImage = new GreenfootImage("squirrelt1.png");
        clickedImage = new GreenfootImage("squirrelt1.png");
        setImage(normalImage);
        arma = new Revolver();
        initializeAndarDireita();
        initializeAndarEsquerda();
    }

    public void act() {
        super.act();
        checkKeyParaAlterarDirecao();
    }
    
    @Override
    protected void checkKeyParaAlterarDirecao(){
        if (Greenfoot.isKeyDown("d")) {
            animateAndarDireita();
        } else if (Greenfoot.isKeyDown("a")) {
            animateAndarEsquerda();
        } else {
            setImage(normalImage);
        }
    }

    private void initializeAndarDireita() {
        andarDireita[0] = new GreenfootImage("squirrelt1.png");
        andarDireita[1] = new GreenfootImage("squirrelt2.png");
        andarDireita[2] = new GreenfootImage("squirrelt3.png");
        andarDireita[3] = new GreenfootImage("squirrelt4.png");
    }
    
    private void initializeAndarEsquerda() {
        andarEsquerda[0] = new GreenfootImage("esquiloEsquerda.png");
        andarEsquerda[1] = new GreenfootImage("esquiloEsquerda2.png");
        andarEsquerda[2] = new GreenfootImage("esquiloEsquerda3.png");
        andarEsquerda[3] = new GreenfootImage("esquiloEsquerda4.png");
    }

    private void animateAndarDireita() {
        animationCounter++;
        if (animationCounter % animationSpeed == 0) {
            setImage(andarDireita[currentFrame]);
            currentFrame = (currentFrame + 1) % andarDireita.length;
        }
    }
    
    private void animateAndarEsquerda() {
        animationCounter++;
        if (animationCounter % animationSpeed == 0) {
            setImage(andarEsquerda[currentFrame]);
            currentFrame = (currentFrame + 1) % andarEsquerda.length;
        }
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.addObject(arma, getX() + 200, getY() + 200);
    }

    @Override
    protected boolean canRun() {
        return true;
    }
    @Override
    public void Falar() {
    if (canTalk()) {
        somEsquilo = new GreenfootSound("esquilo.mp3");
        somEsquilo.setVolume(40);
        somEsquilo.play();
    }
}
}