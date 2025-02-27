import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Inimigos extends Actor
{
   boolean podeDarDano = false;
   protected int life = 50;
   private long spawnTime;
   private GreenfootImage[] movimentando = new GreenfootImage[4];
    private int animationCounter = 0;
    private int animationSpeed = 10; 
    private int currentFrame = 0;

    public Inimigos(){
        spawnTime = System.currentTimeMillis();
        setOpacity(100);
    }
    
    public void act() {
        seguirPlayer();
        checkCollision();
        updateOpacity();
        initializeMovientacao();
        animateMovimentacao();
    }

   protected void seguirPlayer() {
        Personagem player = (Personagem) getWorld().getObjects(Personagem.class).get(0);
        if (player != null) {
            int playerX = player.getX();
            int playerY = player.getY();
            turnTowards(playerX, playerY);
            move(2);
        }
        else{
          move(0);
        }
    }
   
    protected void initializeMovientacao() {
        movimentando[0] = new GreenfootImage("enemy1.png");
        movimentando[1] = new GreenfootImage("enemy2.png");
        movimentando[2] = new GreenfootImage("enemy3.png");
        movimentando[3] = new GreenfootImage("enemy4.png");
    }
    
     protected void animateMovimentacao() {
        animationCounter++;
        if (animationCounter % animationSpeed == 0) {
            setImage(movimentando[currentFrame]);
            currentFrame = (currentFrame + 1) % movimentando.length;
        }
    }

   
   public void checkCollision()
    {
        if (isTouching(Personagem.class) && noColisionTime()) {
            Personagem personagem = (Personagem) getOneIntersectingObject(Personagem.class);
            personagem.Falar();
            personagem.die();   
        }
       
    }
    
    public void TakeDamage(int damage){
        life -= damage;
        if (life <= 0 && noColisionTime()) {
            die();
        }
    }
    
    public void setOpacity(int opacity) {
        GreenfootImage image = getImage();
        image.setTransparency(opacity);
    }
    
    public void die(){
        getWorld().removeObject(this);
    }
    
    public boolean noColisionTime() {
        long currentTime = System.currentTimeMillis();  
        if (currentTime - spawnTime >= 1000) {
            podeDarDano = true;
        }
        return podeDarDano;
    }
    
       private void updateOpacity() {
         long currentTime = System.currentTimeMillis();  
        if (currentTime - spawnTime >= 1000) {
            setOpacity(255);
        }
        }
    }

