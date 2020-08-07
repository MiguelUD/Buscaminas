/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author sehjud
 */
public class ControladorBotones implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent me) {

        if(((JButton)me.getSource()).isFocusable()){
            
            int arr[] = Buscaminas.ventanita.getPc().botonPresionado((JButton) me.getSource());
            if(!Buscaminas.iniciado){
                Buscaminas.nuevaPartida(arr[1], arr[0], Buscaminas.ventanita.getDific());
                Buscaminas.iniciado = true;
            }
            if (arr != null) {
                if (me.getButton()== 1) {
                    Buscaminas.partida.destaparCasilla(arr[1], arr[0]);
                }else if (me.getButton()== 3){
                    Buscaminas.colocarBandera(arr[0], arr[1]);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    
}


