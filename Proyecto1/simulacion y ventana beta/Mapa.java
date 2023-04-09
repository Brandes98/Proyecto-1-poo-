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
        private Alimento[] contenedorAlimento;
        private int filas;
        private int columnas;
        AlimentoEnergia alimentoEnergia=new AlimentoEnergia(2, 20, Color.GREEN);
        Jugador jugador=new Jugador("jugador", 0, 0, 0, 0, 0, 30, Color.BLUE);
        Timer timer=new Timer(5,this);
        ArrayList<Alimento> listaAlimentos=new ArrayList<>();
        listaAlimentos.add(alimentoEnergia)
        public Mapa(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
            this.mapa = new Microorganismo[filas][columnas];
            
            alimentoEnergia.generarAlimentoEnergia(jugador.posX,jugador.posY);
            setFocusable(true);
            addKeyListener(new teclado());
            
           
            
            timer.start();
        }
        
        public void paint(Graphics pintor){
            super.paint(pintor);
            pintor.setColor(jugador.identificador);
            pintor.fillRect(jugador.posX, jugador.posY, 30, 30);

            pintor.setColor(alimentoEnergia.reconocer);
            pintor.fillRect(alimentoEnergia.posX, alimentoEnergia.posY, 30, 30);
        }
        public void actionPerformed(ActionEvent e){
            jugador.mover();
            comer();
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
       
        public void comer(){
            if (jugador.posX>(alimentoEnergia.posX-15)&&jugador.posX<(alimentoEnergia.posX+15) 
            && jugador.posY>(alimentoEnergia.posY-15)&&jugador.posY<(alimentoEnergia.posY+15) ){
                alimentoEnergia.generarAlimentoEnergia(jugador.posX, jugador.posY);
                
            }
        }

    }
    

