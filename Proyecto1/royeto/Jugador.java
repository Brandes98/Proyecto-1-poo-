import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Jugador extends Microorganismo {
 
   
    
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
                
              
                public void mover()
               
                {
                 // System.out.println(this.energia);
                 
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

                }
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
                }
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

                }
               
                public void buscar() {
            
                }
                
                public void huir() {
                   
                }
                
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