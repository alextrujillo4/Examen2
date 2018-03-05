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
public class Enemy extends Item{

    private Game game;
    private int tipo;
    private int vel;

    public Enemy(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.tipo = 0;//0 significa Normal..... 1 = bueno ... 2 = malo
        vel = 2;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        switch (tipo) {
            case 0:
                g.drawImage(Assets.colegiatura , getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 1:
                g.drawImage(Assets.examen, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 2:
                g.drawImage(Assets.profesor, getX(), getY(), getWidth(), getHeight(), null);
                break;
            default:
                break;
        }
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
    