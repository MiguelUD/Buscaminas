/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Buscaminas;
import java.util.Random;

/**
 *
 * @author sehjud
 */
public class Tablero {
    
    private int tab[][];
    private int ancho, alto;

    public Tablero(int x, int y, int ancho, int alto) {
        this.alto=alto;
        this.ancho=ancho;
        tab = new int[alto][ancho];
        Random r = new Random(System.currentTimeMillis());
        int contador=0;
        while(contador<Buscaminas.cantMinas){
            int mx, my;
            mx = r.nextInt(ancho);
            my = r.nextInt(alto);
            if(mx!=x&&my!=y&&tab[my][mx]!=9){
                tab[my][mx] = 9;
                contador++;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(i!=0||j!=0){
                            try{
                            if(tab[my+i][mx+j]!=9)
                                tab[my+i][mx+j]++;
                            }catch(ArrayIndexOutOfBoundsException e){
                                //no hacer nada
                            }
                        }
                    }
                }
            }
            
            
        }
    }
    
    public void imprimirMatriz(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print(getTab()[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * @return the tab
     */
    public int[][] getTab() {
        return tab;
    }

    /**
     * @param tab the tab to set
     */
    public void setTab(int[][] tab) {
        this.setTab(tab);
    }

    

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    public boolean verificarSiHayMina(int x, int y){
        return tab[y][x]==9;
    }
    
}
