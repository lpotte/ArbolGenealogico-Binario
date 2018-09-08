/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Font;
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
    int nivel;

    public Nodo(int info, int x, int y, int nivel) {
        this.info = info;
        this.x = x;
        this.y = y;
        this.nivel = nivel;
    }

    public Nodo() {
    }
    

    public void pintar(Graphics G) {
        G.setColor(Color.ORANGE);
        G.fillOval(this.x - r, this.y - r, d, d);
        G.setColor(Color.BLACK);
        G.setFont( new Font( "Tahoma", Font.CENTER_BASELINE, 14 ) );
        int posString = this.x;
        for (int i = 0; i < String.valueOf(info).length(); i++) {
            posString-=4;
        }
        G.drawString(String.valueOf(info),posString, this.y+3);
        //G.drawString(String.valueOf(info),this.x, this.y);
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
