import java.awt.Color;

import javax.swing.JPanel;
import java.awt.*;
public class FondoVentana extends JPanel{
    Color fondo=Color.blue;
    int tamanoMax,tamano,cuadroTama,res;
    public FondoVentana(){
        this.tamanoMax=1000;
        this.cuadroTama=30;
        this.tamano=this.tamanoMax/this.cuadroTama;
        this.res=this.tamanoMax%this.cuadroTama;
    }
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(fondo);
        for (int i = 0; i < this.cuadroTama; i++){
            
            for (int j = 0; j < this.cuadroTama; j++){
                pintor.fillRect(this.res/2+i*this.tamano, this.res/2+j*this.tamano, tamano-1, tamano-1);
                
              
            }
            
           
            
        


    }
}
}