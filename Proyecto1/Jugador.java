
import java.awt.*;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Jugador extends Microorganismo {
 
   //hereda funciones y parametros de la clase microorganismo, este va a ser el jugador de la partida
    
    int tamanoMax=1000;
    int cuadroTam=30;
    int tam;
    int res;
    int direccionX;
    int direccionY;
    int[] posicion;
    
    public Jugador(String tipo, int energia, int velocidad, int vision, int posX, int posY, int tamano,Color identificador,int minEnergia,int maxEnergia,int minVelocidad,int maxVelocidad,int minVision,int maxVision) {
                super(tipo, energia, velocidad, vision, posX, posY, tamano,identificador,minEnergia,maxEnergia,minVelocidad,maxVelocidad,minVision,maxVision);
               
               this.tamano=tamano;
               
                
                this.posX=cuadroTam;
                this.posY=cuadroTam;
              
                
                //this.tam=tamanoMax/cuadroTam;
                //this.res=tamanoMax%cuadroTam;
                
            }
                
              //permite mover al jugador
                public void mover()
               
                {
                 // System.out.println(this.energia);
                  if(this.energia<=this.minEnergia){
                    JOptionPane.showMessageDialog(null, "Has perdido por energia");
                    System.exit(0);
                  }
                 else if (this.posX<30 && direccionX<0)
                 {
                  this.posX=720;
                  
                 }else if(this.posX>720 && direccionX>0){
                  this.posX=0;
                 }else if(this.posY>720 && direccionY>0){
                  this.posY=0;
                 }else if(this.posY<30 && direccionY<0){
                  this.posY=720;
                 }
                 
                   this.posX+=direccionX;
                   
                  
                   this.posY+=direccionY;
                  
                  // System.out.println(this.energia);
                
              }
                public int obtenerX()
                {
                    return this.posX;
                }
                public int obtenerY()
                {
                    return this.posY;

                }//permite mover al jugador al presionar las teclas definidas
                public void keypressed(KeyEvent e)
                {
                  int key = e.getKeyCode();
                if (this.energia>this.minEnergia){
                  if (key==KeyEvent.VK_LEFT)
                  {
                    direccionX=-this.velocidad;
                    this.energia-=1;
                  }
                  if (key==KeyEvent.VK_RIGHT)
                  {
                    
                    direccionX= this.velocidad;
                    this.energia-=1;
                    
                  }
                  if (key==KeyEvent.VK_DOWN)
                  {
                    direccionY= this.velocidad;
                    this.energia-=1;
                  }
                  if (key==KeyEvent.VK_UP)
                  {
                    direccionY=-this.velocidad;
                    this.energia-=1;
                  }
                }
                }//permite dejar de mover al jugador si se deja de presionar una tecla
                public void keyrelease(KeyEvent e)
                {
                  int key = e.getKeyCode();
                  if (key==KeyEvent.VK_LEFT)
                  {
                    direccionX=0;
                  }
                  if (key==KeyEvent.VK_RIGHT)
                  {
                    direccionX= 0;
                  }
                  if (key==KeyEvent.VK_DOWN)
                  {
                    direccionY=0;
                  }
                  if (key==KeyEvent.VK_UP)
                  {
                    direccionY=0;
                  }
                  this.tamano+=1;
                }
               
                public void buscar() {
            
                }
                
                public void huir() {
                   
                }
                //permite comer al jugador
                public boolean comer(int x, int y) {
                  boolean exist=true;
                  if (this.posX==x && this.posY==y){
                    return exist;
                  }else{
                    exist=false;
                    return exist;
                  }
                  
                }
                public void atacar() {
                   
                
            }
}