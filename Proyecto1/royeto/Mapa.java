import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.Timer;
public class Mapa extends JPanel implements ActionListener {
        private Microorganismo[][] mapa;
        ArrayList<Alimento> listaAlimentos=new ArrayList<>();
        private AlimentoEnergia[] contenedorAlimento= new AlimentoEnergia[3];
        private AlimentoVelocidad[] contenedorAlimentoV=new AlimentoVelocidad[3];
        private AlimentoVision[] contenedorAlimentoVi=new AlimentoVision[3];
        private Microorganismo[] contenedorMicro=new Microorganismo[6];
        private int filas;
        private int columnas;
        //--------------------------------------------------------------------------------------------------------------//
        AlimentoEnergia alimentoEnergia1=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        AlimentoEnergia alimentoEnergia2=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        AlimentoEnergia alimentoEnergia3=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        //-------------------------------------------------------------------------------------------------------------//
        AlimentoVelocidad alimentoVelocidad1= new AlimentoVelocidad(1,20,0,0,Color.ORANGE);
        AlimentoVelocidad alimentoVelocidad2= new AlimentoVelocidad(1,20,0,0,Color.ORANGE);
        AlimentoVelocidad alimentoVelocidad3= new AlimentoVelocidad(1,20,0, 0,Color.ORANGE);
        //-------------------------------------------------------------------------------------------------------------//
        AlimentoVision alimentoVision1= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        AlimentoVision alimentoVision2= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        AlimentoVision alimentoVision3= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        //-------------------------------------------------------------------------------------------------------------//


        //-------------------------------------------------------------------------------------------------------------//

        Jugador jugador=new Jugador("jugador", 50, 5, 0, 0, 0, 30, Color.BLUE,0,100,0,40,0,100);
        Microorganismo microorganismoE1= new Microorganismo("Energico1",50,5,30,0,300,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        Microorganismo microorganismoE2= new Microorganismo("Energico2",50,5,30,0,200,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        Microorganismo microorganismoV1= new Microorganismo("Velocista3",50,5,30,0,100,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        Microorganismo microorganismoV2= new Microorganismo("Velocista4",50,5,30,100,300,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        Microorganismo microorganismoVI1= new Microorganismo("Visionario5",50,5,30,100,200,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        Microorganismo microorganismoVI2= new Microorganismo("Visionario6",50,5,30,100,100,30,Color.LIGHT_GRAY,0,100,0,40,0,20);
        
        
        Timer timer=new Timer(5,this);

        
        
        public Mapa(int filas, int columnas) {
            //------------Agrega los objetos a su lista correspondiente--------------------------//
            contenedorAlimento[0]=alimentoEnergia1;
            contenedorAlimento[1]=alimentoEnergia2;
            contenedorAlimento[2]=alimentoEnergia3;
            contenedorAlimentoV[0]=alimentoVelocidad1;
            contenedorAlimentoV[1]=alimentoVelocidad2;
            contenedorAlimentoV[2]=alimentoVelocidad3;
            contenedorAlimentoVi[0]=alimentoVision1;
            contenedorAlimentoVi[1]=alimentoVision2;
            contenedorAlimentoVi[2]=alimentoVision3;
            contenedorMicro[0]=microorganismoE1;
            contenedorMicro[1]=microorganismoE2;
            contenedorMicro[2]=microorganismoV1;
            contenedorMicro[3]=microorganismoV2;
            contenedorMicro[4]=microorganismoVI1;
            contenedorMicro[5]=microorganismoVI2;

            //----------------------------------------------------------------------------------//
            this.filas = filas;
            this.columnas = columnas;
            this.mapa = new Microorganismo[filas][columnas];
            
            contenedorAlimento[0].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimento[1].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimento[2].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoV[0].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoV[1].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoV[2].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoVi[0].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoVi[1].generarAlimento(jugador.posX,jugador.posY);
            contenedorAlimentoVi[2].generarAlimento(jugador.posX,jugador.posY);
            contenedorMicro[0].generarOrganismo(jugador.posX,jugador.posY);
            contenedorMicro[1].generarOrganismo(jugador.posX,jugador.posY);
            contenedorMicro[2].generarOrganismo(jugador.posX,jugador.posY);
            contenedorMicro[3].generarOrganismo(jugador.posX,jugador.posY);
            contenedorMicro[4].generarOrganismo(jugador.posX,jugador.posY);
            contenedorMicro[5].generarOrganismo(jugador.posX,jugador.posY);
            setFocusable(true);
            addKeyListener(new teclado());
            
           
            
            timer.start();
        }
        
        public void paint(Graphics pintor){
            super.paint(pintor);
            pintor.setColor(jugador.identificador);
            pintor.fillRect(jugador.posX, jugador.posY, 30, 30);
            for(int i=0;i<3;i++){
                pintor.setColor(contenedorAlimento[i].reconocer);
                pintor.fillRect(contenedorAlimento[i].posX, contenedorAlimento[i].posY, 30, 30);
                pintor.setColor(contenedorAlimentoV[i].reconocer);
                pintor.fillRect(contenedorAlimentoV[i].posX, contenedorAlimentoV[i].posY, 30, 30);
                pintor.setColor(contenedorAlimentoVi[i].reconocer);
                pintor.fillRect(contenedorAlimentoVi[i].posX, contenedorAlimentoVi[i].posY, 30, 30);

            }
            for (int i=0;i<6;i++){
                pintor.setColor(contenedorMicro[i].identificador);
                pintor.fillRect(contenedorMicro[i].posX, contenedorMicro[i].posY, 30,30);
            }
           /* pintor.setColor(contenedorAlimento[0].reconocer);
            pintor.fillRect(contenedorAlimento[0].posX, contenedorAlimento[0].posY, 30, 30);
            pintor.setColor(contenedorAlimento[1].reconocer);
            pintor.fillRect(contenedorAlimento[1].posX, contenedorAlimento[1].posY, 30, 30);
            pintor.setColor(contenedorAlimento[2].reconocer);
            pintor.fillRect(contenedorAlimento[2].posX, contenedorAlimento[2].posY, 30, 30);*/ 
            
        }
        public void actionPerformed(ActionEvent e){
        
            jugador.mover();
           
        
            
            comerEnergia();
            comerVelocidad();
            comerVision();
            comerOrganismos();
            canibal();
            comerAlimentoOrganismos();
            contenedorMicro[0].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
           
        
            contenedorMicro[1].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
          
        
            contenedorMicro[2].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
         
       
            contenedorMicro[3].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
            
          
            contenedorMicro[4].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
           
        
            contenedorMicro[5].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
        
            repaint();

        }
        private class teclado extends KeyAdapter
        {
            public void keyPressed(KeyEvent e)
            {
                jugador.keypressed(e);
            }
            public void keyReleased(KeyEvent e)
            {
                jugador.keyrelease(e);
            }
        }
        public void mover(int posX, int posY, int nuevaPosX, int nuevaPosY) {
            Microorganismo microorganismo = mapa[posX][posY];
            mapa[posX][posY] = null;
            mapa[nuevaPosX][nuevaPosY] = microorganismo;
            //microorganismo.setPosX(nuevaPosX);
            //microorganismo.setPosY(nuevaPosY);
        }
        
        public void ubicar(Microorganismo microorganismo, int posX, int posY) {
            mapa[posX][posY] = microorganismo;
            //microorganismo.setPosX(posX);
            //microorganismo.setPosY(posY);
        }
        
        public boolean limite(int posX, int posY) {
            return (posX < 0 || posX >= filas || posY < 0 || posY >= columnas);
        }
        
        public void turnos() {
         
        }
       
        public void comerEnergia(){
           for(int i=0;i<3;i++) {
            if (jugador.posX>(contenedorAlimento[i].posX-30)&&jugador.posX<(contenedorAlimento[i].posX+30) 
            && jugador.posY>(contenedorAlimento[i].posY-30)&&jugador.posY<(contenedorAlimento[i].posY+30) ){
                //System.out.println(jugador.energia);
                if (jugador.energia<=jugador.maxEnergia){
                jugador.energia+=contenedorAlimento[i].energia;
                //System.out.println(jugador.energia);
                }/*else{
                    
                    System.out.println(jugador.energia);
                } */
                contenedorAlimento[i].generarAlimento(jugador.posX, jugador.posY);

            } 
         } 
     }
        public void comerVision(){
            for(int i=0;i<3;i++) {
                if (jugador.posX>(contenedorAlimentoVi[i].posX-30)&&jugador.posX<(contenedorAlimentoVi[i].posX+30) 
                && jugador.posY>(contenedorAlimentoVi[i].posY-30)&&jugador.posY<(contenedorAlimentoVi[i].posY+30) ){
                    System.out.println(jugador.vision);
                    jugador.vision+=contenedorAlimentoVi[i].vision;
                    System.out.println(jugador.vision);
                    contenedorAlimentoVi[i].generarAlimento(jugador.posX, jugador.posY);
                    
                } 
             } 

        }
        public void comerVelocidad(){
            for(int i=0;i<3;i++) {
                if (jugador.posX>(contenedorAlimentoV[i].posX-30)&&jugador.posX<(contenedorAlimentoV[i].posX+30) 
                && jugador.posY>(contenedorAlimentoV[i].posY-30)&&jugador.posY<(contenedorAlimentoV[i].posY+30) ){
                    System.out.println(jugador.velocidad);
                    if (jugador.velocidad<jugador.maxVelocidad){
                    jugador.velocidad+=contenedorAlimentoV[i].velocidad;
                    System.out.println(jugador.velocidad);
                    
                    }
                    contenedorAlimentoV[i].generarAlimento(jugador.posX, jugador.posY);
                } 
             } 

        }
      public void comerOrganismos(){
        for(int i=0;i<6;i++){
        if (jugador.posX>(contenedorMicro[i].posX-30)&&jugador.posX<(contenedorMicro[i].posX+30) 
                && jugador.posY>(contenedorMicro[i].posY-30)&&jugador.posY<(contenedorMicro[i].posY+30) ){
                  contenedorMicro[i].generarOrganismo(jugador.posX, jugador.posY);
      } 
    }  
    }
    public void canibal()
    {
        Microorganismo comparado;
        for(int i=0;i<6;i++)
        {
            comparado=contenedorMicro[i];
            for (int j=0;j<6;j++)
            {
                if (comparado!=contenedorMicro[j])
                {
                 if (comparado.posX>(contenedorMicro[j].posX-30)&&comparado.posX<(contenedorMicro[j].posX+30) 
                    && comparado.posY>(contenedorMicro[j].posY-30)&&comparado.posY<(contenedorMicro[j].posY+30) )
                    {
                    contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                    }
                }
            }
        }
    }
    public void comerAlimentoOrganismos(){
        Microorganismo comparador;
        for(int j=0;j<6;j++){
            comparador=contenedorMicro[j];
            for(int i=0;i<3;i++){
            if (comparador.posX>(contenedorAlimentoVi[i].posX-30)&&comparador.posX<(contenedorAlimentoVi[i].posX+30) 
            && comparador.posY>(contenedorAlimentoVi[i].posY-30)&&comparador.posY<(contenedorAlimentoVi[i].posY+30) ){
                contenedorAlimentoVi[i].generarAlimento(jugador.posX, jugador.posY);
           }
           else if (comparador.posX>(contenedorAlimentoV[i].posX-30)&&comparador.posX<(contenedorAlimentoV[i].posX+30) 
            && comparador.posY>(contenedorAlimentoV[i].posY-30)&&comparador.posY<(contenedorAlimentoV[i].posY+30) ){
                contenedorAlimentoV[i].generarAlimento(jugador.posX, jugador.posY);
           }else if (comparador.posX>(contenedorAlimento[i].posX-30)&&comparador.posX<(contenedorAlimento[i].posX+30) 
           && comparador.posY>(contenedorAlimento[i].posY-30)&&comparador.posY<(contenedorAlimento[i].posY+30) ){
               contenedorAlimento[i].generarAlimento(jugador.posX, jugador.posY);
          }
        }
        
    }
}    
}
