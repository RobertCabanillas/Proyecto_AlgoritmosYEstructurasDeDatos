/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import vista.ControladorTeclado;
import vista.PanelJuego;

public class Jugador extends Entidad{
    PanelJuego panelJuego;
    ControladorTeclado conTeclado;
    int animacion[] = {0, 1, 0, 2};
    BufferedImage[] arriba = new BufferedImage[animacion.length];
    BufferedImage[] abajo = new BufferedImage[4];
    BufferedImage[] izquierda = new BufferedImage[4];
    BufferedImage[] derecha = new BufferedImage[4];
    
    public Jugador(PanelJuego panelJuego, ControladorTeclado conTeclado){
        this.panelJuego = panelJuego;
        this.conTeclado = conTeclado;
        setDefaultValues();
        obtenerImagenJugador();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direccion = "abajo";
    }
    
    public void obtenerImagenJugador(){
        try {
            for(int i=0; i < animacion.length-1; i++){
                arriba[i] = ImageIO.read(getClass().getResourceAsStream("/res/jugador/ATRAS_"+(i+1)+".png"));
                abajo[i] = ImageIO.read(getClass().getResourceAsStream("/res/jugador/FRONTAL_"+(i+1)+".png"));
                izquierda[i] = ImageIO.read(getClass().getResourceAsStream("/res/jugador/IZQUIERDA_"+(i+1)+".png"));
                derecha[i] = ImageIO.read(getClass().getResourceAsStream("/res/jugador/DERECHA_"+(i+1)+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizar(){
        
        if(conTeclado.upPressed == true || conTeclado.downPressed == true || conTeclado.leftPressed == true || conTeclado.rightPressed == true){
            if(conTeclado.upPressed == true){
                direccion = "arriba";
                y -= speed;
            }else if(conTeclado.downPressed == true){
                direccion = "abajo";
                y += speed;
            }else if(conTeclado.leftPressed == true){
                direccion = "izquierda";
                x -= speed;
            }else if(conTeclado.rightPressed == true){
                direccion = "derecha";
                x += speed;
            }
            
            contadorSprite++;

            if (contadorSprite > 8) {
                indiceAnimacion = (indiceAnimacion + 1) % animacion.length;
                numeroSprite = animacion[indiceAnimacion];

                contadorSprite = 0;
            }
        } else {
        indiceAnimacion = 0;
        numeroSprite = animacion[0]; // normalmente 0
        contadorSprite = 0;
        }  
    }
    public void draw(Graphics2D g2){
//      g2.setColor(Color.white);
//      g2.fillRect(x, y, panelJuego.tamañoFinal, panelJuego.tamañoFinal);
        BufferedImage imagen = null;
        
        switch (direccion){
            case "arriba" -> imagen = arriba[numeroSprite];
            case "abajo" -> imagen = abajo[numeroSprite];
            case "izquierda" -> imagen = izquierda[numeroSprite];
            case "derecha" -> imagen = derecha[numeroSprite];
        }
        g2.drawImage(imagen, x, y, panelJuego.tamañoFinal, panelJuego.tamañoFinal, null);
    }
}
