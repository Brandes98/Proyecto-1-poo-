import java.awt.Color;

public class Alimento {
    //definicion de variables
    Color reconocer;
    int tamano;
     int energia;
     int velocidad;
     int vision;
     int posX;
     int posY;
     //constructor de la clase e instanciacion de las variables
     public Alimento(int tamano, int energia, int velocidad, int vision,int posX,int posY) {
         this.tamano = tamano;
         this.energia = energia;
         this.velocidad = velocidad;
         this.vision = vision;
         this.posX=posX;
         this.posY=posY;
     }
     //constructor de la clase e instanciacion de las variables
     public Alimento(int tamano,int energia,int velocidad,int vision,Color reconocer){
        this.tamano = tamano;
        this.energia = energia;
        this.velocidad = velocidad;
        this.vision = vision;
        this.posX=0;
        this.posY=0;
        this.reconocer=reconocer;
     }
     //obtiene el tamano del jalimneto
     public int getTamano() {
         return tamano;
     }
 // da el tamano del alimento
     public void setTamano(int tamano) {
         this.tamano = tamano;
     }
 //obtiene la energia del alimento
     public int getEnergia() {
         return energia;
     }
 //da la energia al alimento
     public void setEnergia(int energia) {
         this.energia = energia;
     }
 // obtiene la energia del alimento
     public int getVelocidad() {
         return velocidad;
     }
 //da la velocidad al alimento
     public void setVelocidad(int velocidad) {
         this.velocidad = velocidad;
     }
 //obtiene la vision del alimento
     public int getVision() {
         return vision;
     }
 //da la vision al alimento
     public void setVision(int vision) {
         this.vision = vision;
     }//genera el alimento en una posicion diferente a la del jugador
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