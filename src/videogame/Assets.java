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
     
     public static BufferedImage rectoria; 
     public static BufferedImage biblioteca;
       
    public static BufferedImage gameOver;
    public static BufferedImage pause;
    public static BufferedImage win;
    
    public static BufferedImage rayo;
    public static BufferedImage lives6;
    public static BufferedImage lives5;
    public static BufferedImage lives4;
    public static BufferedImage lives3;
    public static BufferedImage lives2;
    public static BufferedImage lives1;
    public static BufferedImage livesNone;
    public static BufferedImage rayoEnemigo;
    public static BufferedImage lamb;

    public static BufferedImage lost;
    
    public static BufferedImage cetec0; 
    public static BufferedImage cetec1; 
    public static BufferedImage cetec2; 
    public static BufferedImage cetec3; 
    public static BufferedImage cetec4; 
    public static BufferedImage cetec5; 
    public static BufferedImage cetec6; 
    public static BufferedImage cetec7; 
    public static BufferedImage cetec8; 
    public static BufferedImage cetec9; 
    public static BufferedImage cetec10; 
    public static BufferedImage cetec11; 
    public static BufferedImage cetec12; 
    public static BufferedImage cetec13; 
    public static BufferedImage cetec14; 
    public static BufferedImage cetec15; 
    public static BufferedImage cetec16; 
    public static BufferedImage cetec17; 
    
     public static BufferedImage rectoria1; 
    public static BufferedImage rectoria2; 
    public static BufferedImage rectoria3; 
    public static BufferedImage rectoria4; 
    public static BufferedImage rectoria5; 
    public static BufferedImage rectoria6; 
    public static BufferedImage rectoria7; 
    public static BufferedImage rectoria8; 
    public static BufferedImage rectoria9; 
    public static BufferedImage rectoria10; 
    public static BufferedImage rectoria11; 
    public static BufferedImage rectoria12; 
    public static BufferedImage rectoria13; 
    public static BufferedImage rectoria14; 
    public static BufferedImage rectoria15; 
    public static BufferedImage rectoria16; 
    public static BufferedImage rectoria17; 
    public static BufferedImage rectoria18; 
    
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.png");
        player = ImageLoader.loadImage("/images/player.png");
        
        colegiatura = ImageLoader.loadImage("/images/colegiatura.png");
        examen = ImageLoader.loadImage("/images/examen.png");
        profesor = ImageLoader.loadImage("/images/profesor.png");
        
        
        rectoria = ImageLoader.loadImage("/images/rectoria.png");
        biblioteca = ImageLoader.loadImage("/images/biblioteca.png");
        
        
        rayo = ImageLoader.loadImage("/images/rayo.png");
                
        gameOver= ImageLoader.loadImage("/images/GameOver.png");
        win = ImageLoader.loadImage("/images/ganar.png");
        
        lives6 = ImageLoader.loadImage("/images/vidas6.png");
        lives5 = ImageLoader.loadImage("/images/vidas5.png");
        lives4 = ImageLoader.loadImage("/images/vidas4.png");
        lives3 = ImageLoader.loadImage("/images/vidas3.png");
        lives2 = ImageLoader.loadImage("/images/vidas2.png");
        lives1= ImageLoader.loadImage("/images/vidas1.png");
        livesNone= ImageLoader.loadImage("/images/novidas.png");
        rayoEnemigo=ImageLoader.loadImage("/images/rayoEnemy.png");
        lamb=ImageLoader.loadImage("/images/lamb.png");
        
        lost= ImageLoader.loadImage("/images/Lost.png");
        pause= ImageLoader.loadImage("/images/pause.png");
        
        
        cetec0 = ImageLoader.loadImage("/images/cetec0.png");
        cetec1 = ImageLoader.loadImage("/images/cetec1.png");
        cetec2 = ImageLoader.loadImage("/images/cetec2.png");
        cetec3 = ImageLoader.loadImage("/images/cetec3.png");
        cetec4 = ImageLoader.loadImage("/images/cetec4.png");
        cetec5 = ImageLoader.loadImage("/images/cetec5.png");
        cetec6 = ImageLoader.loadImage("/images/cetec6.png");
        cetec7 = ImageLoader.loadImage("/images/cetec7.png");
        cetec8 = ImageLoader.loadImage("/images/cetec8.png");
        cetec9 = ImageLoader.loadImage("/images/cetec9.png");
        cetec10 = ImageLoader.loadImage("/images/cetec10.png");
        cetec11 = ImageLoader.loadImage("/images/cetec11.png");
        cetec12 = ImageLoader.loadImage("/images/cetec12.png");
        cetec13 = ImageLoader.loadImage("/images/cetec13.png");
        cetec14 = ImageLoader.loadImage("/images/cetec14.png");
        cetec15 = ImageLoader.loadImage("/images/cetec15.png");
        cetec16 = ImageLoader.loadImage("/images/cetec16.png");
        cetec17= ImageLoader.loadImage("/images/cetec17.png");
        
        
        rectoria1 = ImageLoader.loadImage("/images/rectoria1.png");
        rectoria2 = ImageLoader.loadImage("/images/rectoria2.png");
        rectoria3 = ImageLoader.loadImage("/images/rectoria3.png");
        rectoria4 = ImageLoader.loadImage("/images/rectoria4.png");
        rectoria5 = ImageLoader.loadImage("/images/rectoria5.png");
        rectoria6 = ImageLoader.loadImage("/images/rectoria6.png");
        rectoria7 = ImageLoader.loadImage("/images/rectoria7.png");
        rectoria8 = ImageLoader.loadImage("/images/rectoria8.png");
        rectoria9 = ImageLoader.loadImage("/images/rectoria9.png");
        rectoria10 = ImageLoader.loadImage("/images/rectoria10.png");
        rectoria11 = ImageLoader.loadImage("/images/rectoria11.png");
        rectoria12 = ImageLoader.loadImage("/images/rectoria12.png");
        rectoria13 = ImageLoader.loadImage("/images/rectoria13.png");
        rectoria14 = ImageLoader.loadImage("/images/rectoria14.png");
        rectoria15 = ImageLoader.loadImage("/images/rectoria15.png");
        rectoria16 = ImageLoader.loadImage("/images/rectoria16.png");
        rectoria17= ImageLoader.loadImage("/images/rectoria17.png");
        rectoria18 = ImageLoader.loadImage("/images/rectoria18.png");
        
        
    }
    
}
