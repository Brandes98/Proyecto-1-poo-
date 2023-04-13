import java.awt.Color;

public class Alimento {
    Color reconocer;
    int tamano;
     int energia;
     int velocidad;
     int vision;
     int posX;
     int posY;
     public Alimento(int tamano, int energia, int velocidad, int vision,int posX,int posY) {
         this.tamano = tamano;
         this.energia = energia;
         this.velocidad = velocidad;
         this.vision = vision;
         this.posX=posX;
         this.posY=posY;
     }
     public Alimento(int tamano,int energia,int velocidad,int vision,Color reconocer){
        this.tamano = tamano;
        this.energia = energia;
        this.velocidad = velocidad;
        this.vision = vision;
        this.posX=0;
        this.posY=0;
        this.reconocer=reconocer;
     }
     
     public int getTamano() {
         return tamano;
     }
 
     public void setTamano(int tamano) {
         this.tamano = tamano;
     }
 
     public int getEnergia() {
         return energia;
     }
 
     public void setEnergia(int energia) {
         this.energia = energia;
     }
 
     public int getVelocidad() {
         return velocidad;
     }
 
     public void setVelocidad(int velocidad) {
         this.velocidad = velocidad;
     }
 
     public int getVision() {
         return vision;
     }
 
     public void setVision(int vision) {
         this.vision = vision;
     }
     public void generarAlimento(int jposX, int jposY){
        boolean existe=false;
        int X=(int)(Math.random()*500);
        int Y=(int)(Math.random()*500);
        if(jposX==X && jposY==Y){
            existe=true;
            generarAlimento(jposX,jposY);
        }
        else{
            if(!existe){
                this.posX=X;
                this.posY=Y;
            }
        }
    }
 }