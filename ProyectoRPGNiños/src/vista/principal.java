/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import javax.swing.JFrame;

public class principal {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("My Adventure");
        
        PanelJuego panelJuego = new PanelJuego();
        window.add(panelJuego);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        panelJuego.startGameThread();
    }   
}
