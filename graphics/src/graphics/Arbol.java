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
public class Arbol {

    Nodo Raiz;

    public Arbol() {
    }

    public void insertar_nodo(Graphics G, Nodo g, int info, int x, int y) {
        if (Raiz == null) {
            Raiz = new Nodo(info, x, y);
        } else {
            if (g.getDer() == null) {
                g.setDer(new Nodo(info, x + 80, y + 100));
                g.pintar(G);
            } else {
                if (g.getIzq() != null) {
                    g.setIzq(new Nodo(info, x - 80, y + 100));
                    g.pintar(G);
                } else {
                    System.out.println("No se pueden agregar más");
                }
            }
        }
    }

    public void insertar_nodo(Graphics G, Nodo g, Nodo n, int info, int x, int y) {
        if (Raiz == null) {
            n.setInfo(info);
            n.setX(x);
            n.setY(y);
            Raiz = n;
        } else {
            if (g.getDer() == null) {
                n.setInfo(info);
                n.setX(x + 80);
                n.setY(y + 100);
                g.setDer(n);
            } else {
                if (g.getIzq() == null) {
                    n.setInfo(info);
                    n.setX(x - 80);
                    n.setY(y + 100);
                    g.setIzq(n);
                } else {
                    System.out.println("No se pueden agregar más");
                }
            }
        }
    }

    public Nodo buscar(Nodo nd, Point p) {
        if (nd != null) {
            if (nd.getX() + 30 > p.getX() && nd.getX() - 30 < p.getX() && nd.getY() - 30 < p.getY() && nd.getY() + 30 > p.getY()) {
                return nd;
            } else {
                if (nd.getDer() != null) {
                    return buscar(nd.getDer(), p);
                } else {
                    return buscar(nd.getIzq(), p);
                }
            }
        }
        return null;
    }
}
