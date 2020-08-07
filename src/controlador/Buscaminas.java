/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Partida;
import vista.Ventana;

/**
 *
 * @author sehjud
 */
public class Buscaminas {

    public static Ventana ventanita;
    public static int cantMinas;
    public static Partida partida;
    public static boolean iniciado;
    public static ControladorBotones cb = new ControladorBotones();
    public static ControladorArriba ca = new ControladorArriba();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        iniciado = false;
        cantMinas = 10;
        ventanita = new Ventana("Buscaminas Nivel 1", 1);

    }

    public static void Peerdio(int tipo) {
        ventanita.getPs().getCrono().stop();
        if (tipo == 1) {
            JOptionPane.showMessageDialog(ventanita, "Has caido en una mina");
        } else {
            JOptionPane.showMessageDialog(ventanita, "Se ha quedado sin tiempo");
        }
        
        ventanita.getPc().perder();
    }

    public static void nuevaPartida(int c, int f, int nivel) {
        partida = new Partida(c, f, nivel);
    }

    public static void reiniciar() {
        iniciado = false;
        ventanita.dispose();
        ventanita = new Ventana("Buscaminas Nivel " + 1, 1);
    }

    public static void colocarBandera(int f, int c) {
        if(cantMinas>0){
            if(!ventanita.getPc().esBandera(f,c)){
                ventanita.getPc().ponerBandera(f, c);
                cantMinas=cantMinas-1;
            }
            else{
                ventanita.getPc().quitarBandera(f,c);
                cantMinas=cantMinas+1;
            }
        }
        else{
            JOptionPane.showMessageDialog(ventanita, "No tiene más banderas que poner");
        }
        ventanita.getPs().actBanderas(cantMinas);
    }

    public static void destaparCasilla(int f, int c, int text) {
        if(ventanita.getPc().esBandera(f,c)){
            cantMinas=cantMinas+1;
            ventanita.getPs().actBanderas(cantMinas);
        }
        ventanita.getPc().ocultarBoton(f, c, text);
    }

    public static void gano() {
        JOptionPane.showMessageDialog(ventanita, "Felicitaciónes, gano la partida");
        if (partida.getNivelDificultad() < 3) {
            ventanita.dispose();
            ventanita = new Ventana("Buscaminas Nivel " + partida.getNivelDificultad() + 1, partida.getNivelDificultad() + 1);
            iniciado = false;
            ventanita.getPs().getCrono().stop();
        }
    }

    static void actTimer() {
        ventanita.getPs().setSeg(ventanita.getPs().getSeg() - 1);
        if (ventanita.getPs().getSeg() == 0 && ventanita.getPs().getMinut() == 0) {
            Buscaminas.Peerdio(2);
        } else {
            if (ventanita.getPs().getSeg() < 0) {
                ventanita.getPs().setSeg(59);
                ventanita.getPs().setMinut(ventanita.getPs().getMinut() - 1);
            }
            ventanita.getPs().actualTiempo(ventanita.getPs().getMinut(), ventanita.getPs().getSeg());
        }
    }

}
