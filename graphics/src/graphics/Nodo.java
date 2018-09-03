/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Graphics;

/**
 *
 * @author lpotte
 */
public class Nodo {

    int info;
    Nodo Izq;
    Nodo Der;
    int x;
    int y;
    int d = 50;
    int r = d / 2;

    public Nodo(int info, int x, int y) {
        this.info = info;
        this.x = x;
        this.y = y;
    }

    public void pintar(Graphics G) {
        G.fillOval(this.x - r, this.y - r, d, d);
        
    }

    public Nodo getIzq() {
        return Izq;
    }

    public void setIzq(Nodo Izq) {
        this.Izq = Izq;
    }

    public Nodo getDer() {
        return Der;
    }

    public void setDer(Nodo Der) {
        this.Der = Der;
    }

    public int getInfo() {
        return info;
    }

}
