/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Buscaminas;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sehjud
 */
public class PanelCentral extends JPanel {

    /**
     * @return the matriz
     */
    public JButton[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(JButton[][] matriz) {
        this.matriz = matriz;
    }

    private JButton matriz[][];
    private int ancho, alto;

    public PanelCentral(int nivel) {
        ancho = 8;
        alto = 8;
        if (nivel == 2) {
            ancho = alto = 16;
        } else if (nivel == 3) {
            ancho = 30;
            alto = 16;
        }
        this.setLayout(new GridLayout(alto, ancho));
        matriz = new JButton[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = new JButton();
                matriz[i][j].addMouseListener(Buscaminas.cb);
                this.add(matriz[i][j]);
            }
        }

    }

    public int[] botonPresionado(JButton b) {
        int arr[] = new int[2];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (b.equals(matriz[i][j])) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }

    public void ocultarBoton(int f, int c, int num) {
        if (num == 0) {
            matriz[f][c].setVisible(false);
        } else {
            matriz[f][c].setText(num + "");
            matriz[f][c].setEnabled(false);
            matriz[f][c].setFocusable(false);

        }
    }

    public void ponerBandera(int f, int c) {
        matriz[f][c].setText("B");
    }

    public void perder() {
        for (int i = 0; i < alto; i++) {
            for (int j = 00; j < ancho; j++) {
                matriz[i][j].setEnabled(false);
                matriz[i][j].setFocusable(false);
            }
        }
    }

    public boolean esBandera(int f, int c) {
        return "B".equals(matriz[f][c].getText());
    }

    public void quitarBandera(int f, int c) {
         matriz[f][c].setText("");
    }

}
