/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import static java.lang.Integer.max;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Esthephany Ayala Yañez 
 */
public class Game implements Runnable {
    private BufferStrategy bs;      // to have several buffers when displaying
    private Graphics g;             // to paint objects
    private Display display;        // to display in the game
    String title;                   // title of the window
    private int width;              // width of the window
    private int height;             // height of the window
    private Thread thread;          // thread to create the game
    private boolean running;        // to set the game
    private boolean started;        // to start the game
    private boolean gameover;
    private Player player;          // to use a player
    private Rayo rayo; 
    private int vidas ;
    private boolean pause;
    private boolean lost;
    private ArrayList<Enemy> enemies; // Enemies (Aliens)
    private ArrayList<Fortaleza> fortalezas; // Fortalezas
    private KeyManager keyManager;  // to manage the keyboard
    private int score;
    private boolean win;
    private int cont;
    SoundClipTest sound;
  //  private int direction=-1;
    
    /**
     * to create title, width and height and set the game is still not running
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height  to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        started = false;
        gameover = false;
        pause = false;
        keyManager = new KeyManager();
        score = 0;
        lost = false;
        vidas = 3;
        win= false;
        cont=0;
    }
    

    
    /**
     * initializing the display window of the game
     */
    private void init() {
         display = new Display(title, getWidth(), getHeight());  
         Assets.init();
         player = new Player(getWidth() / 2 - 50, getHeight() - 50, 100, 30, this);
         rayo = new Rayo(getWidth() / 2 - 10, player.y - player.height , 10, 30, 0, 0, this);
         generateEnemies();
         generateFortalezas();
         display.getJframe().addKeyListener(keyManager);
    }
    
    @Override
    public void run() {
        init();
        // frames per second
        int fps = 30;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;
            
            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta --;
            }
        }
      
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    private void tick() {
        keyManager.tick();
       if(!win){
        if(!gameover){
            if(!lost){
                //To pause the game
                pause = this.getKeyManager().p;
                if(!(pause)){ //IF IS NOT PAUSED
                    
                    // if space and game has not started
                    if (this.getKeyManager().space && !this.isStarted()) {
                        this.setStarted(true);
                        rayo.setSpeedX(3);
                        rayo.setSpeedY(-3);
                    } 
                    // moving player
                    player.tick();
                    // if game has started
                    if (this.isStarted()) {
                        // moving the rayo
                        rayo.tick();
                        
                    } else {
                        // moving the rayo based on the plaver
                        rayo.setX(player.getX() + player.getWidth() / 2 - rayo.getWidth() / 2);
                    }
                    
                    
                    //enemigos se muevan
                    
                    Iterator itr= enemies.iterator();
                            while(itr.hasNext()){
                                ((Enemy)itr.next()).tick();
                                for(Enemy enemy: enemies){
                                    //int x=enemy.getX();
                                    //System.out.println("ANTES DEL IF");
                                  if (enemy.getX()+enemy.getWidth() >=this.getWidth()){
                                     for(Enemy enemy2: enemies){
                                         enemy2.y= enemy2.y+1;
                                         enemy2.setDireccion(-1);
                                         
                                     }
                                     
                                    
                                      // System.out.println("Despues del if");
                                     
                                }
                                  
                                  else  if(enemy.getX()<=0){
                                         //System.out.println("Despues del if");
                                         for(Enemy enemy3: enemies){
                                            enemy3.setDireccion(1);
                                            enemy3.y=enemy3.y+1;
                                         }
                                     }
                                
                            }
                    
                    
                    
                    
                   //for (Enemy alien: enemies){
                       // alien.tick();
                       /*int x= alien.getX();
                        if(x>=this.getWidth()- 30 && direction != -1){
                            direction=-1;
                            Iterator it = enemies.iterator();
                            while(it.hasNext()){
                                Enemy e2= (Enemy) it.next();
                                e2.setY(e2.getY()+ 15);
                            }
                        }
                        
                        if(x <= 5 && direction != 1){
                            direction = 1;
                            Iterator it2=enemies.iterator();
                            while(it2.hasNext()){
                                Enemy e= (Enemy) it2.next();
                                e.setY(e.getY()+15);
                            }
                        }
                       */
                    }
                    
                   
                  

                    // check collision bricks versus rayo
                    for (int i = 0; i < enemies.size(); i++) {
                        Enemy brick = (Enemy) enemies.get(i);
                        if (brick != null ){
                         
                            if (rayo.intersects(brick)) {
                                 if(brick.getTipo()==0){
                                rayo.setSpeedY((rayo.getSpeedY() *  - 1));
                                 sound = new SoundClipTest("correct");
                                }
                                 else if(brick.getTipo() == 1){
                                    player.setWidth(player.getWidth() + player.getWidth()/4 );
                                    rayo.setSpeedY((rayo.getSpeedY() *  - 1));
                                    score += 10;
                                    sound = new SoundClipTest("correct");
                                }
                                else if(brick.getTipo()==2){
                                    player.setWidth(100);
                                    score -= 10;
                                    rayo.setSpeedY((rayo.getSpeedY() *  - 1));
                                    sound = new SoundClipTest("boom");
                                }                      
                                enemies.remove(brick);
                                i--;
                                score += 5;
                                //cont+=1;
                            }
                        }
                    }

                    if(player.intersects(rayo)){
                         if(rayo.getX() > player.getX() && rayo.getX() + 
                                 rayo.getWidth() <= player.getX() + player.getWidth()/4){
                            if(rayo.getSpeedX() > 0){
                                rayo.setSpeedX(rayo.getSpeedX() *-1);
                            }else{
                               rayo.setSpeedX(rayo.getSpeedX() *1); 
                            }
                         }else if(rayo.getX() > player.getX() + player.getWidth()/4
                                &&   rayo.getX() + rayo.getWidth() <=  player.getX()
                                 + player.getWidth()){
                            if(rayo.getSpeedX() > 0){
                                rayo.setSpeedX(rayo.getSpeedX() *1);
                            }else{
                               rayo.setSpeedX(rayo.getSpeedX() *-1); 
                            }
                        }
                        rayo.setY(rayo.getY()- rayo.getSpeedY());
                        rayo.setSpeedY(rayo.getSpeedY() * -1);
                    }
                    
                    


                    // collision with walls Y
                    if(rayo.getY() >= getHeight()){
                       // game.setGameover(true);
                       sound = new SoundClipTest("boom");
                       setVidas(getVidas() - 1);
                       //****GAMEOVER IF
                       if(getVidas() == 0)
                           gameover = true;
                       else if(getVidas()>=1)
                       setLost(true);
                       
                       //**** END GAMEOVER IF
                       rayo.setSpeedY(0);
                       rayo.setSpeedX(0);
                       rayo.setY(getHeight() - 1);
                    } 
                    //when there's no brick , the Player will win 
                    if(enemies.size() == 0)
                         win=true;
                }

            }else{
               //When game is LOST (live - 1), keymanager keeps listening for "J" ro init again
                if(this.getKeyManager().isJ()){
                    lost = false;
                    started = false;
                    resetRayo();
                    resetPlayer();
                } 
            }//END LOST********
        } 
         else{
            //When GAMEOVER & WIN  keeps listening for "R" to reinit game
            if(this.getKeyManager().isR()){
                gameover = false;
                started = false;
                win = false;
                vidas = 3;
                score = 0;
                resetRayo();
                resetPlayer();
                generateEnemies();
            }
        }   
        
       }
       else{
            //When GAMEOVER & WIN  keeps listening for "R" to reinit game
            if(this.getKeyManager().isR()){
                gameover = false;
                started = false;
                win = false;
                vidas = 3;
                score = 0;
                resetRayo();
                resetPlayer();
                generateEnemies();
            }
        }
    }
//END TICK();********
    
    private void drawWin(Graphics g){
        //show Win
        g.drawImage(Assets.win,(this.width / 2) - 200, (this.height / 2) - 200, 400 , 400, null);
    }
    
    private void drawGameOver(Graphics g){
       // Show Game Over
        g.drawImage(Assets.gameOver,(this.width / 2) - 200, (this.height / 2) - 200, 400 , 400, null);
    }
    
    private void drawLost(Graphics g){
       // Show LOST!!
        g.drawImage(Assets.lost, (this.width / 2) - 200, (this.height / 2) - 200, 400 , 400, null);
    }
    
     private void drawPause(Graphics g){
       // Show LOST!!
        g.drawImage(Assets.pause, (this.width / 2) - 200, (this.height / 2) - 200, 400 , 400, null);
    }
    
    private void drawLives(Graphics g, int lnumber){
        if( lnumber == 3)
            g.drawImage(Assets.lives3, this.width - 240 , 15 , 150, 40, null);
        else if ( lnumber == 2)
            g.drawImage(Assets.lives2, this.width - 240 , 15 , 150, 40, null);
        else if ( lnumber == 1)
            g.drawImage(Assets.lives1, this.width - 240 , 15 , 150, 40, null);
        else if ( lnumber <= 0)
            g.drawImage(Assets.livesNone, this.width - 240 , 15 , 150, 40, null);
    }

    
    private void drawScore(Graphics g){
        String a = Integer.toString(score);
        g.setColor(Color.BLACK);
        g.setFont(new Font ("arial",Font.PLAIN, 24));
 
        g.drawString("Unidades: " + a ,15, 25 + 15);
        
    }
    
    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
        */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        }else{
            g = bs.getDrawGraphics();
            g.drawImage(Assets.background, 0, 0, width, height, null);
            
            
            if(!gameover){
                player.render(g);
                //player2.render(g);
                rayo.render(g);
                for (Enemy brick : enemies) {
                    brick.render(g);
                }
                
                for (Fortaleza fortaleza : fortalezas) {
                    fortaleza.render(g);
                }
                
                drawScore(g);
                drawLives(g,vidas);
            }else if(gameover){
            drawGameOver(g);
            }
          

            if (lost && !gameover){
                drawLost(g);
            }
            if (pause && !lost && !gameover){
                drawPause(g);
            }
            if(win && !lost && !pause && !lost &&!gameover){
                
                drawWin(g);
            }
            
            bs.show();
            g.dispose();
        }
    }
    
    
    /**
     * setting the thead for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }           
        }
    }


    private void sleep() {
        try        
            {
                Thread.sleep(150);
            } 
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
    }

    private void generateEnemies() {
        //Generate New Enemies
        enemies = new ArrayList<Enemy>();
        int width_enemy = 40;
        int height_enemy = 40;
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 5; j++) {
                //double randomNum = Math.random() * ( 3 );
                Enemy enemy = new Enemy(i * (width_enemy + 15) , j * (height_enemy + 15) , width_enemy , height_enemy, this);
                if(j == 2 || j == 3 ) 
                    enemy.setTipo(1);
                if(j == 4 || j == 5 )
                    enemy.setTipo(2);
                enemies.add(enemy);
            }
        }
    }
    
    
    private void generateFortalezas() {
        //Generate New Fortalezas
        fortalezas = new ArrayList<Fortaleza>();
        int width_fortaleza = 120;
        int height_fortaleza = 90;
        for (int i = 1; i <= 3; i++) {
                //double randomNum = Math.random() * ( 3 );
                Fortaleza fortaleza = new Fortaleza(i * ((getWidth() / 3)/2  + width_fortaleza/3  ) , (getHeight() - height_fortaleza - 120) , width_fortaleza , height_fortaleza, this);
                if(i == 2) 
                    fortaleza.setTipo(1);
                if(i == 3  )
                fortaleza.setTipo(2);
                fortalezas.add(fortaleza);
        }
    }
 

    private void resetPlayer() {
        player.setX(getWidth() / 2 - 50);
        player.setY(getHeight() - 100);
        player.setWidth(100);
    }

    private void resetRayo() {
        //Reset posicion og rayo and player
        rayo.setX(getWidth() / 2 - 10);
        rayo.setY(getHeight() - 120);
    }
    
    
    
    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Rayo getRayo() {
        return rayo;
    }

    public void setRayo(Rayo rayo) {
        this.rayo = rayo;
    }

    public ArrayList<Enemy> getBricks() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

     /**
     * To get the width of the game window
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
