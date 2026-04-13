/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import vista.ControladorTeclado;
import vista.PanelJuego;

public class Jugador extends Entidad{
    PanelJuego panelJuego;
    ControladorTeclado conTeclado;
    
    public Jugador(PanelJuego panelJuego, ControladorTeclado conTeclado){
        this.panelJuego = panelJuego;
        this.conTeclado = conTeclado;
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void actualizar(){
        if(conTeclado.upPressed == true){
            y -= speed;
        }else if(conTeclado.downPressed == true){
            y += speed;
        }else if(conTeclado.leftPressed == true){
            x -= speed;
        }else if(conTeclado.rightPressed == true){
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, panelJuego.tamañoFinal, panelJuego.tamañoFinal);
    }
}
