public class AlimentoVision extends Alimento{
    int tamano;
    int vision;
    int posX;
    int posY;
         public AlimentoVision(int tamano, int vision,int posX,int posY) {
            super(tamano,vision,posX,posY);
             this.tamano = tamano;
            
             this.vision = vision;
             this.posX=posX;
             this.posY=posY;
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
     
    
    
}
