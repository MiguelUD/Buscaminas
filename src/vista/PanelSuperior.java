/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Buscaminas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author sehjud
 */
public class PanelSuperior extends JPanel {
    
    private JLabel tiempo;
    private JLabel contadorMinas;
    private JButton funciones;
    private int minut;
    private int seg;
    private Timer crono= new Timer(1000,Buscaminas.ca);

    public PanelSuperior(int min,int seg) {
        this.minut=min;
        this.seg=seg;
        tiempo = new JLabel();
        contadorMinas = new JLabel(Buscaminas.cantMinas+"");
        funciones = new JButton(":)");
        funciones.addActionListener(Buscaminas.ca);
        tiempo.setBackground(Color.black);
        tiempo.setForeground(Color.red);
        contadorMinas.setBackground(Color.black);
        contadorMinas.setForeground(Color.red);
        this.setLayout(new GridLayout(1, 3));
        this.add(contadorMinas);
        this.add(funciones);
        this.add(tiempo);
        this.actualTiempo(this.minut, this.seg);
        crono.start();
    }
    
    /**
     * @return the tiempo
     */
    public JLabel getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(JLabel tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the contadorMinas
     */
    public JLabel getContadorMinas() {
        return contadorMinas;
    }

    /**
     * @param contadorMinas the contadorMinas to set
     */
    public void setContadorMinas(JLabel contadorMinas) {
        this.contadorMinas = contadorMinas;
    }

    /**
     * @return the funciones
     */
    public JButton getFunciones() {
        return funciones;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(JButton funciones) {
        this.funciones = funciones;
    }

    public int getMinut() {
        return minut;
    }

    public void setMinut(int minut) {
        this.minut = minut;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public Timer getCrono() {
        return crono;
    }

    public void setCrono(Timer crono) {
        this.crono = crono;
    }
    
    
    
    public void actualTiempo(int minutos, int segundos){
        if(segundos<10){
            tiempo.setText(minutos+":0"+segundos);
        }
        else{
            tiempo.setText(minutos+":"+segundos);
        }
    }

    public void actBanderas(int cantMinas) {
        contadorMinas.setText(String.valueOf(cantMinas));
    }
}
