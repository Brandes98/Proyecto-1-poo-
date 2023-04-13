import java.awt.Color;

public class AlimentoEnergia extends Alimento{
        Color reconocer;
        int tamano;
         int energia;
         int velocidad;
         int vision;
        int posX;
        int posY;
         
         public AlimentoEnergia(int tamano, int energia,int velocidad,int vision,Color reconocer) {
            super(tamano, energia,vision,velocidad,reconocer);
             this.tamano = tamano;
             this.energia = energia;
             this.velocidad=velocidad;
             this.vision=vision;
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
