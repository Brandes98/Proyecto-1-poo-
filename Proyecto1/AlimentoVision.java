import java.awt.Color;

public class AlimentoVision extends Alimento{
    //herencia de la clase Alimento, hereda sus parametros y funciones, solo brinda vision al ser comido.
    Color reconocer;
    int tamano;
    int velocidad;
         int energia;
    int vision;
    int posX;
    int posY;
  
         public AlimentoVision(int tamano,int velocidad,int vision, int energia,Color reconocer) {
            super(tamano,energia,vision,velocidad,reconocer);
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
