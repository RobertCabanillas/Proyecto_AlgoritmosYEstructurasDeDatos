/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import modelo.Jugador;

public class PanelJuego extends JPanel implements Runnable{
    final int tamañoLienzo = 32;
    final int escala = 2;
    
    public final int tamañoFinal = tamañoLienzo*escala;
    final int maxTamañoColumna = 24;
    final int maxTamañoFila = 12;
    final int pantallaAncho = tamañoFinal*maxTamañoColumna;
    final int pantallaAlto = tamañoFinal*maxTamañoFila;
    
    int FPS = 60;
    ControladorTeclado conTeclado = new ControladorTeclado();
    Thread threadJuego;
    Jugador jugador = new Jugador(this,conTeclado);
    
    public PanelJuego (){
        this.setPreferredSize(new Dimension(pantallaAncho, pantallaAlto));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(conTeclado);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        threadJuego = new Thread(this);
        threadJuego.start();
    }
    @Override
    public void run() {
        double intervaloDibujo = 1000000000/FPS;
        double delta = 0;
        long tiempoAnterior = System.nanoTime();
        long tiempoActual;
        
        while(threadJuego != null){
            tiempoActual = System.nanoTime();
            delta += (tiempoActual - tiempoAnterior) / intervaloDibujo;
            tiempoAnterior = tiempoActual;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update(){
        jugador.actualizar();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        jugador.draw(g2);
        g2.dispose();
    }
}
