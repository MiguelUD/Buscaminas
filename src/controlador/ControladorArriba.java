/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kil_5
 */
public class ControladorArriba implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Buscaminas.ventanita.getPs().getFunciones()){
            Buscaminas.reiniciar();
        }
        else{
            Buscaminas.actTimer();
        }
    }
    
}
