package videogame;

import java.awt.Color;
import java.awt.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esthephany Ayala Yañez 
 */
public class Fortaleza extends Item{

    private Game game;
    private int tipo;
    private int vidas;

    public Fortaleza(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.tipo = 0;//0 significa Normal..... 1 = bueno ... 2 = malo
        vidas = 18;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        switch (tipo) {
            case 0:
                
                if(vidas == 18){
                    g.drawImage(Assets.cetec0 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 17){
                    g.drawImage(Assets.cetec1 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 16){
                    g.drawImage(Assets.cetec2 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 15){
                    g.drawImage(Assets.cetec3 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 14){
                    g.drawImage(Assets.cetec4 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 13){
                    g.drawImage(Assets.cetec5 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 12){
                    g.drawImage(Assets.cetec6 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 11){
                    g.drawImage(Assets.cetec7 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 10){
                    g.drawImage(Assets.cetec8 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 9){
                    g.drawImage(Assets.cetec9 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 8){
                    g.drawImage(Assets.cetec10 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 7){
                    g.drawImage(Assets.cetec11 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 6){
                    g.drawImage(Assets.cetec12 , getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 5){
                    g.drawImage(Assets.cetec13, getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 4){
                    g.drawImage(Assets.cetec14, getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 3){
                    g.drawImage(Assets.cetec15, getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 2){
                    g.drawImage(Assets.cetec16, getX(), getY(), getWidth(), getHeight(), null);
                }else if(vidas == 1){
                    g.drawImage(Assets.cetec17, getX(), getY(), getWidth(), getHeight(), null);
                }
               
                break;
                
                
            case 1:
                g.drawImage(Assets.rectoria, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 2:
                g.drawImage(Assets.biblioteca, getX(), getY(), getWidth(), getHeight(), null);
                break;
            default:
                break;
        }
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    
    
    
     public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
    