import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World {
    private GreenfootSound music = new GreenfootSound("Doom Eternal OST - The Only Thing They Fear Is You (Mick Gordon) [Doom Eternal Theme].mp3");
    private int count = 0;
    private int velocidadeRespawn = 20;
    private int timer = 0;
    private Tempo tempo;
    private Soldado soldado;
    private Esquilo esquilo;
    private TelaMenu menu; 

    public MyWorld() {
        // Create a new world with 900x700 cells with a cell size of 1x1 pixels.
        super(900, 700, 1);
        GreenfootImage bg = new GreenfootImage("BackgroundStreet.png");
        setBackground(bg);
        prepare();
        music.setVolume(0);
        music.play();
        tempo = new Tempo();
        showTelaMenu();
        
    }

    public void act() {
        if (Greenfoot.isKeyDown("1") && menu != null) {
            soldado = new Soldado();
            addObject(soldado, 500, 500);
            removeTelaMenu();
            Greenfoot.start();
             addObject(tempo, getWidth() / 2, 30);
        }
        if (Greenfoot.isKeyDown("2") && menu != null) {
            esquilo = new Esquilo();
            addObject(esquilo, 500, 500);
            removeTelaMenu();
            Greenfoot.start();
            addObject(tempo, getWidth() / 2, 30);
        }

        respawnInimigos();
        timer++;
        if (timer >= 1000) {
            addObject(new Revolver(), 800, 500);
            respawnInimigos();
        }

        if (timer >= 2000) {
            addObject(new Rifle(), 500, 200);
            respawnInimigos();
        }

        if (timer >= 3000) {
             addObject(new Shotgun(), 200, 300);
            respawnInimigos();
            respawnInimigos();
        }

        if (timer >= 3600) {
            respawnInimigos();
            respawnInimigos();
            respawnInimigos();
            
        }

        if (timer >= 4000) {
            showSurvivedScreen();
        }

        if (soldado != null && soldado.estaMorto()) {
            showDiedScreen();
        }

        if (esquilo != null && esquilo.estaMorto()) {
            showDiedScreen();
        }
    }

    private void prepare() {
       
    }

    public void respawnInimigos() {
        count++;
        if (count >= velocidadeRespawn) {
            int numeroAleatorioX = Greenfoot.getRandomNumber(900);
            int numeroAleatorioY = Greenfoot.getRandomNumber(700); 
            addObject(new Inimigos(), numeroAleatorioX, numeroAleatorioY);
            count = 0;
            velocidadeRespawn += 5;
        }
    }

    private void showSurvivedScreen() {
        addObject(new TelaVitoria(), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    private void showDiedScreen() {
        addObject(new TelaDerrota(), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
    
    private void showTelaMenu() {
        menu = new TelaMenu();
        addObject(menu, getWidth() / 2, getHeight() / 2); 
    }
    
    private void removeTelaMenu() {
        if (menu != null) {
            removeObject(menu);
            menu = null;
        }
    }
}