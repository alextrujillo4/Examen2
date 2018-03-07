/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Esthephany Ayala Yañez 
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    
     public static BufferedImage colegiatura; 
     public static BufferedImage examen; 
     public static BufferedImage profesor; 
     
      public static BufferedImage cetec; 
     public static BufferedImage rectoria; 
     public static BufferedImage biblioteca;
       
    public static BufferedImage gameOver;
    public static BufferedImage pause;
    public static BufferedImage win;
    
    public static BufferedImage rayo;
    public static BufferedImage lives3;
    public static BufferedImage lives2;
    public static BufferedImage lives1;
    public static BufferedImage livesNone;
    public static BufferedImage rayoEnemigo;
    
    
    public static BufferedImage lost;
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.png");
        player = ImageLoader.loadImage("/images/player.png");
        
        colegiatura = ImageLoader.loadImage("/images/colegiatura.png");
        examen = ImageLoader.loadImage("/images/examen.png");
        profesor = ImageLoader.loadImage("/images/profesor.png");
        
        cetec = ImageLoader.loadImage("/images/cetec.png");
        rectoria = ImageLoader.loadImage("/images/rectoria.png");
        biblioteca = ImageLoader.loadImage("/images/biblioteca.png");
        
        
        rayo = ImageLoader.loadImage("/images/rayo.png");
                
        gameOver= ImageLoader.loadImage("/images/GameOver.png");
        win = ImageLoader.loadImage("/images/ganar.png");
        
        lives3 = ImageLoader.loadImage("/images/vidas3.png");
        lives2 = ImageLoader.loadImage("/images/vidas2.png");
        lives1= ImageLoader.loadImage("/images/vidas1.png");
        livesNone= ImageLoader.loadImage("/images/novidas.png");
        rayoEnemigo=ImageLoader.loadImage("/images/rayoEnemy.png");
        
        lost= ImageLoader.loadImage("/images/Lost.png");
        pause= ImageLoader.loadImage("/images/pause.png");
    }
    
}
