/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author lpotte
 */
public class Arbol {

    Nodo Raiz;
    int bono1 = 1000;
    int bono2 = 60;
    int cant_nodos = 0;

    public Arbol() {
    }

    public void insertar_nodo(Graphics G, Nodo g, Nodo n, int info, int x, int y) {
        if (Raiz == null) {
            n.setInfo(info);
            n.setX(x);
            n.setY(y);
            n.setNivel(0);
            Raiz = n;
        } else {
            if (g.getDer() == null) {
                n.setInfo(info);
                n.setX(x + redox1(g.getNivel() + 1));
                n.setY(y + bono2);
                n.setNivel(g.getNivel() + 1);
                g.setDer(n);
            } else {
                if (g.getIzq() == null) {
                    n.setInfo(info);
                    n.setX(x - redox1(g.getNivel() + 1));
                    n.setY(y + bono2);
                    n.setNivel(g.getNivel() + 1);
                    g.setIzq(n);
                } else {
                    System.out.println("No se pueden agregar más");
                }
            }
        }
        //bono1+=10;
        //bono2+=10;
        cant_nodos++;
    }

    public boolean existe(Nodo nd, int elemento) {
        if (nd != null) {
            if (nd.info == elemento) {
                return true;
            } else {
                if (existe(nd.getDer(), elemento)) {
                    return existe(nd.getDer(), elemento);
                } else {
                    return existe(nd.getIzq(), elemento);
                }
            }
        }
        return false;
    }

    public Nodo buscar(Nodo nd, Point p) {
        if (nd != null) {
            if (nd.getX() + 30 > p.getX() && nd.getX() - 30 < p.getX() && nd.getY() - 30 < p.getY() && nd.getY() + 30 > p.getY()) {
                return nd;
            } else {
                if (buscar(nd.getDer(), p) != null) {
                    return buscar(nd.getDer(), p);
                } else {
                    return buscar(nd.getIzq(), p);
                }
            }
        }
        return null;
    }

    private int redox1(int i) {
        int aux = this.bono1;
        for (int j = 0; j <= i; j++) {
            aux = aux / 2;
        }
        return aux;
    }

    private int redox2(int i) {
        int aux = this.bono2;
        for (int j = 0; j <= i; j++) {
            aux = aux / 2;
        }
        return aux;
    }

    public Nodo buscarPadre(Nodo nd, Nodo elemento) {
        if (nd != null) {
            if (nd.getDer() != null || nd.getIzq() != null) {
                if (nd.getDer() == elemento) {
                    return nd;
                } else {
//                if (Raiz.getIzq() != null) {
                    if (nd.getIzq() == elemento) {
                        return nd;
                    } else {
                        if (buscarPadre(nd.getDer(), elemento) != null) {
                            return buscarPadre(nd.getDer(), elemento);
                        } else {
                            if (buscarPadre(nd.getIzq(), elemento) != null) {
                                return buscarPadre(nd.getIzq(), elemento);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean son_hermanos(Nodo Raiz, Nodo x, Nodo y) {
        if (Raiz != null) {
            if (buscarPadre(Raiz, x) == buscarPadre(Raiz, y)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void repintar(Nodo nd, Graphics G) {
        if (nd != null) {
            G.setColor(Color.ORANGE);
            G.fillOval(nd.x - nd.r, nd.y - nd.r, nd.d, nd.d);
            G.setColor(Color.BLACK);
            G.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
            int posString = nd.x;
            for (int i = 0; i < String.valueOf(nd.info).length(); i++) {
                posString -= 4;
            }
            G.drawString(String.valueOf(nd.info), posString, nd.y + 3);
            if (nd.getDer() != null) {
                G.setColor(Color.ORANGE);
                G.drawLine(nd.getX(), nd.getY(), nd.getDer().getX(), nd.getDer().getY());
            }
            if (nd.getIzq() != null) {
                G.setColor(Color.ORANGE);
                G.drawLine(nd.getX(), nd.getY(), nd.getIzq().getX(), nd.getIzq().getY());
            }
            repintar(nd.getIzq(), G);
            repintar(nd.getDer(), G);
        }
    }
}
