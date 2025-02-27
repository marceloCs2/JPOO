import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Personagem extends Actor
{
    private int speed = 5;         
    private int ySpeed = 0; 
    private boolean onGround;
    private boolean isRuning = false;
    public boolean estaMorto = false;
    protected Armas arma;
    protected int life = 100;

    public void act()
    {
        checkKeys(); 
        updateArmaPosition();
        Arma();
        die();
        trocarArma();
        checkCollision();
        checkKeyParaAlterarDirecao();
    }
    
    protected void checkKeyParaAlterarDirecao(){};

    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("a")) 
        {
            moveLeft();
        }
        if (Greenfoot.isKeyDown("d")) 
        {
            moveRight();
        }
        
        if (Greenfoot.isKeyDown("w")) 
        {
            moveUp();
        }
        
        if ( Greenfoot.isKeyDown("s")) 
        {
            moveDown();
        }
        
        if ( Greenfoot.isKeyDown("shift")) 
        {
           correr();
        }
        
        if (Greenfoot.isKeyDown("v"))
        getWorld().removeObject(this.arma);
        
    }
    
    private void correr()
    {
        if(canRun()){
          speed += 2;
        }
    }
    
    private void moveUp()
    {
        setLocation(getX(), getY() - speed);
    }
    
    private void moveDown()
    {
        setLocation(getX(), getY() + speed);
    }
    
    private void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }

    private void moveRight()
    {
        setLocation(getX() + speed, getY());
    }

    protected boolean canRun() {
        return false; 
    }
    
    protected boolean canHandleGuns(){
        return true; 
    }
    
    protected boolean canTalk(){
       return true;
    }
    
     private void updateArmaPosition() {
        if (arma != null) {
            arma.setLocation(getX() + 40, getY());
        }
    }
    

    public void die() {
        life = 0;
    }
    
    
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    public Armas SetArma(Armas arma){
      return this.arma = arma;
    }
    
    
    public Armas GetArma() {
        return arma;
    }

    public void RemoveGun(Armas arma) {
        getWorld().removeObject(arma);
    }
    
    public void Arma() {
        if (canHandleGuns()== true){
        arma.usarArma();
    }
}

public void Falar() {
}


 private void trocarArma(){
    Armas arma = (Armas) getOneIntersectingObject(Armas.class);
        if(canHandleGuns()== true && Greenfoot.isKeyDown("f")){
         SetArma(arma);
        }
}

public void checkCollision() {
   
    Inimigos inimigo = (Inimigos) getOneIntersectingObject(Inimigos.class);
    if(inimigo != null && inimigo.podeDarDano == true){
        estaMorto = true;
        return;
    }

}

public boolean estaMorto() {
        return estaMorto;
    }
}



    
    

    
    




