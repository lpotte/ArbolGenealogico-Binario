/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author lpotte
 */
public class Link {
    int x1;
    int x2;
    int y1;
    int y2;

    public Link(Point x, Point x2) {
        this.x1 = (int) x.getX();
        this.x2 = (int) x2.getX();
        this.y1 = (int) x.getY();
        this.y2 = (int) x2.getY();
    }
    
    public void enlazar(Nodo G1, Nodo G2, Graphics G){
        G.drawLine(G1.getX(), G1.getY(), G2.getX(), G2.getY());
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    
}
