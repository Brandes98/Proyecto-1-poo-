public class AlimentoVelocidad extends Alimento {
    int tamano;
    int velocidad;
    int posX;
    int posY;
         public AlimentoVelocidad(int tamano, int velocidad,int posX,int posY) {
            super(tamano,velocidad,posX,posY);
             this.tamano = tamano;
            
             this.velocidad = velocidad;
             this.posX=posX;
             this.posY=posY;
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
     
    
     }
    

