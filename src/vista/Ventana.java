/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author sehjud
 */
public class Ventana extends JFrame {

    private PanelSuperior ps;
    private PanelCentral pc;
    private int dific;

    public Ventana(String title, int nivel) throws HeadlessException {
        super(title);
        switch (nivel) {
            case 1:
                this.setBounds(300, 50, 700, 500);
                ps = new PanelSuperior(5,20);
                break;
            case 2:
                this.setBounds(250, 50, 900, 650);
                ps = new PanelSuperior(6,0);
                break;
            default:
                this.setBounds(40, 10, 1280, 700);
                ps = new PanelSuperior(8,30);
                break;
        }
        this.setLayout(new BorderLayout(5, 10));
        pc = new PanelCentral(nivel);
        dific = nivel;
        this.add(ps, BorderLayout.NORTH);
        this.add(pc, BorderLayout.CENTER);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * @return the ps
     */
    public PanelSuperior getPs() {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(PanelSuperior ps) {
        this.ps = ps;
    }

    /**
     * @return the pc
     */
    public PanelCentral getPc() {
        return pc;
    }

    /**
     * @param pc the pc to set
     */
    public void setPc(PanelCentral pc) {
        this.pc = pc;
    }

    public int getDific() {
        return dific;
    }

    public void setDific(int dific) {
        this.dific = dific;
    }

}
