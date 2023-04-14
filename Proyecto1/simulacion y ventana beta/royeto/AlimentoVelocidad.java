import java.awt.Color;

public class AlimentoVelocidad extends Alimento {
    Color reconocer;
    int tamano;
    int velocidad;
    int energia;
    int vision;
    int posX;
    int posY;
         public AlimentoVelocidad(int tamano, int velocidad,int vision,int energia,Color reconocer) {
            super(tamano,velocidad,energia,vision,reconocer);
             this.tamano = tamano;
            this.energia=energia;
            this.vision=vision;
             this.velocidad = velocidad;
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
     
         public int getVelocidad() {
             return this.velocidad;
         }
     
         public void setVelocidad(int velocidad) {
             this.velocidad = velocidad;
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
    

