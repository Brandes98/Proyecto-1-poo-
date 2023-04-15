
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.Timer;

public class Mapa extends JPanel implements ActionListener {
    Scanner energy = new Scanner(System.in);//Variable que inicializa el input en consola
    Scanner velocity= new Scanner(System.in);//Variable que inicializa el input en consola
    Scanner vition=new Scanner(System.in);//Variable que inicializa el input en consola
    int Energia=energy.nextInt();//variable que recibe el input
    int Velocidad=velocity.nextInt();//variable que recibe el input
    int vision=vition.nextInt();//variable que recibe el input


        private Microorganismo[][] mapa;//Variable que almacena el arreglo de microorganismos.
        ArrayList<Alimento> listaAlimentos=new ArrayList<>();//Array que almacena alimentos.
        private AlimentoEnergia[] contenedorAlimento= new AlimentoEnergia[3];//Lista que almacena alimentos energia
        private AlimentoVelocidad[] contenedorAlimentoV=new AlimentoVelocidad[3];//Lista que almacena alimentos velocidad
        private AlimentoVision[] contenedorAlimentoVi=new AlimentoVision[3];//Lista que almacena alimentos vision
        private Microorganismo[] contenedorMicro=new Microorganismo[6];//Lista que almacena organismos
        private int filas;
        private int columnas;
        //---------------------------instancia y almacenamiento de alimentos energia------------------------------------//
        AlimentoEnergia alimentoEnergia1=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        AlimentoEnergia alimentoEnergia2=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        AlimentoEnergia alimentoEnergia3=new AlimentoEnergia(1, 20,0,0, Color.GREEN);
        //---------------------------instancia y almacenamiento de alimentos velocidad----------------------------------//
        AlimentoVelocidad alimentoVelocidad1= new AlimentoVelocidad(1,5,0,0,Color.ORANGE);
        AlimentoVelocidad alimentoVelocidad2= new AlimentoVelocidad(1,5,0,0,Color.ORANGE);
        AlimentoVelocidad alimentoVelocidad3= new AlimentoVelocidad(1,5,0, 0,Color.ORANGE);
        //--------------------------instancia y almacenamiento de alimentos vision--------------------------------------//
        AlimentoVision alimentoVision1= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        AlimentoVision alimentoVision2= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        AlimentoVision alimentoVision3= new AlimentoVision(1,0,20,0,Color.MAGENTA);
        //--------------------------instancia y almacenamiento de organimos y jugador----------------------------------//
        Jugador jugador=new Jugador("jugador", Energia,Velocidad,vision, 0, 0, 30, Color.BLUE,0,100,0,10,0,100);
        Microorganismo microorganismoE1= new Microorganismo("Energico1",50,5,150,0,300,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        Microorganismo microorganismoE2= new Microorganismo("Energico2",50,5,150,0,200,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        Microorganismo microorganismoV1= new Microorganismo("Velocista3",50,5,150,0,100,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        Microorganismo microorganismoV2= new Microorganismo("Velocista4",50,5,150,100,300,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        Microorganismo microorganismoVI1= new Microorganismo("Visionario5",50,5,150,100,200,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        Microorganismo microorganismoVI2= new Microorganismo("Visionario6",50,5,150,100,100,30,Color.LIGHT_GRAY,0,100,0,40,0,500);
        

        //-------------------------------------------------------------------------------------------------------------//

       
        
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

            //-------------------------asignacion de valores a fila,columna y mapa---------------------------------------//
            this.filas = filas;
            this.columnas = columnas;
            this.mapa = new Microorganismo[filas][columnas];
            //----------------genera alimentos y organismos-------------------------------------------------------------//
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
            //-----------Le da prioridad a los eventos de esta clase en la interfaz---------------------//
            setFocusable(true);
            // permite escuchar los eventos del teclado//
            addKeyListener(new teclado());
            
           
            //Comienza del timer//
            timer.start();
        }
        //---------------------------------FUNCION PAINT IMPRIME EN PANTALLA TODOS LOS OBJETOS----------------//
        public void paint(Graphics pintor){
            super.paint(pintor);
            pintor.setColor(jugador.identificador);
            pintor.fillRect(jugador.posX, jugador.posY, 15, 15);
            for(int i=0;i<3;i++){
                pintor.setColor(contenedorAlimento[i].reconocer);
                pintor.fillRect(contenedorAlimento[i].posX, contenedorAlimento[i].posY, 15, 15);
                pintor.setColor(contenedorAlimentoV[i].reconocer);
                pintor.fillRect(contenedorAlimentoV[i].posX, contenedorAlimentoV[i].posY, 15, 15);
                pintor.setColor(contenedorAlimentoVi[i].reconocer);
                pintor.fillRect(contenedorAlimentoVi[i].posX, contenedorAlimentoVi[i].posY, 15, 15);

            }
            for (int i=0;i<6;i++){
                pintor.setColor(contenedorMicro[i].identificador);
                pintor.fillRect(contenedorMicro[i].posX, contenedorMicro[i].posY, 15,15);
            }
           /* pintor.setColor(contenedorAlimento[0].reconocer);
            pintor.fillRect(contenedorAlimento[0].posX, contenedorAlimento[0].posY, 30, 30);
            pintor.setColor(contenedorAlimento[1].reconocer);
            pintor.fillRect(contenedorAlimento[1].posX, contenedorAlimento[1].posY, 30, 30);
            pintor.setColor(contenedorAlimento[2].reconocer);
            pintor.fillRect(contenedorAlimento[2].posX, contenedorAlimento[2].posY, 30, 30);*/ 
            
        }
        //funcion que lee las funcionalidades de las funciones y actualiza en pantalla//
        public void actionPerformed(ActionEvent e){
        
            jugador.mover();
           
        
            
            comerEnergia();
            comerVelocidad();
            comerVision();
            comerOrganismos();
           
            canibal();
            comerAlimentoOrganismos();
            huirPrioridad();
            repaint();

        } //Clase teclado que permite la lectura de la presion y el dejar de presionar las teclas del juego//
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
        //Permite mover objetos//
        public void mover(int posX, int posY, int nuevaPosX, int nuevaPosY) {
            Microorganismo microorganismo = mapa[posX][posY];
            mapa[posX][posY] = null;
            mapa[nuevaPosX][nuevaPosY] = microorganismo;
            //microorganismo.setPosX(nuevaPosX);
            //microorganismo.setPosY(nuevaPosY);
        }
        //permite ubicar microorganismos//
        public void ubicar(Microorganismo microorganismo, int posX, int posY) {
            mapa[posX][posY] = microorganismo;
            //microorganismo.setPosX(posX);
            //microorganismo.setPosY(posY);
        }
        //define el limite de la matriz de mapa//
        public boolean limite(int posX, int posY) {
            return (posX < 0 || posX >= filas || posY < 0 || posY >= columnas);
        }
        //retorna turnos//
        public void turnos() {
         
        }
       //permite comer alimentos que aportan energia al usuario//
        public void comerEnergia(){
           for(int i=0;i<3;i++) {
            if (jugador.posX>(contenedorAlimento[i].posX-30)&&jugador.posX<(contenedorAlimento[i].posX+30) 
            && jugador.posY>(contenedorAlimento[i].posY-30)&&jugador.posY<(contenedorAlimento[i].posY+30) ){
                System.out.println("jugador energia: "+jugador.energia);
                if (jugador.energia<jugador.maxEnergia){
                jugador.energia+=contenedorAlimento[i].energia;
                System.out.println("jugador energia: "+jugador.energia);
                }/*else{
                    
                    System.out.println(jugador.energia);
                } */
                contenedorAlimento[i].generarAlimento(jugador.posX, jugador.posY);

            } 
         } 
     }//permite comer alimentos que brindan vision al jugador//
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

        }//permite comer alimentos que mejoran la velocidad al usuario//
        public void comerVelocidad(){
            for(int i=0;i<3;i++) {
                if (jugador.posX>(contenedorAlimentoV[i].posX-30)&&jugador.posX<(contenedorAlimentoV[i].posX+30) 
                && jugador.posY>(contenedorAlimentoV[i].posY-30)&&jugador.posY<(contenedorAlimentoV[i].posY+30) ){
                    System.out.println("jugador velocidad: "+jugador.velocidad);
                    if (jugador.velocidad<jugador.maxVelocidad){
                    jugador.velocidad += contenedorAlimentoV[i].velocidad;
                    System.out.println("jugador velocidad: "+jugador.velocidad);
                    
                    }
                    contenedorAlimentoV[i].generarAlimento(jugador.posX, jugador.posY);
                } 
             } 

        }
        //permite comer organismos al usuario y obtener sus stats, asi mismo comer al usuario//
      public void comerOrganismos(){
        for(int j=0;j<6;j++){
        if (jugador.posX>(contenedorMicro[j].posX-30)&&jugador.posX<(contenedorMicro[j].posX+30) 
                && jugador.posY>(contenedorMicro[j].posY-30)&&jugador.posY<(contenedorMicro[j].posY+30) ){
                    if(jugador.energia>contenedorMicro[j].energia){
                        if(jugador.energia<jugador.maxEnergia)
                        jugador.energia+=contenedorMicro[j].energia;
                        if(jugador.velocidad<jugador.maxVelocidad)
                        jugador.velocidad+=contenedorMicro[j].velocidad;
                        if(jugador.vision<jugador.maxVision)
                       jugador.vision+=contenedorMicro[j].vision;
                
                       jugador.tamano+=contenedorMicro[j].tamano;
                        contenedorMicro[j].energia=50;
                        contenedorMicro[j].velocidad=5;
                        contenedorMicro[j].vision=150;
                        contenedorMicro[j].tamano=1;
                        contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                      //-----------------------------------------------------------------//
                    }else if(jugador.energia<contenedorMicro[j].energia){
                        JOptionPane.showConfirmDialog(null, "HAS PERDIDO");
                        if(contenedorMicro[j].energia<contenedorMicro[j].maxEnergia)
                        contenedorMicro[j].energia+=jugador.energia;
                        if(contenedorMicro[j].velocidad<contenedorMicro[j].maxVelocidad)
                        contenedorMicro[j].velocidad+=jugador.velocidad;
                        if(contenedorMicro[j].vision<contenedorMicro[j].maxVision)
                        contenedorMicro[j].vision+=jugador.vision;
                        contenedorMicro[j].tamano+=jugador.tamano;
                        jugador.energia=50;
                        jugador.velocidad=5;
                        jugador.vision=150;
                        jugador.tamano=1;
                        jugador.generarOrganismo(jugador.posX, jugador.posY);
                      //--------------------------------------------------------------// 
                    }else{
                        if(jugador.velocidad>contenedorMicro[j].velocidad){
                            if(jugador.energia<jugador.maxEnergia)
                        jugador.energia+=contenedorMicro[j].energia;
                        if(jugador.velocidad<jugador.maxVelocidad)
                        jugador.velocidad+=contenedorMicro[j].velocidad;
                        if(jugador.vision<jugador.maxVision)
                       jugador.vision+=contenedorMicro[j].vision;
                            jugador.tamano+=contenedorMicro[j].tamano;
                        contenedorMicro[j].energia=50;
                        contenedorMicro[j].velocidad=5;
                        contenedorMicro[j].vision=150;
                        contenedorMicro[j].tamano=1;
                        contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                        }else if(jugador.velocidad<contenedorMicro[j].velocidad){
                            JOptionPane.showConfirmDialog(null, "HAS PERDIDO");
                            if(contenedorMicro[j].energia<contenedorMicro[j].maxEnergia)
                        contenedorMicro[j].energia+=jugador.energia;
                        if(contenedorMicro[j].velocidad<contenedorMicro[j].maxVelocidad)
                        contenedorMicro[j].velocidad+=jugador.velocidad;
                        if(contenedorMicro[j].vision<contenedorMicro[j].maxVision)
                        contenedorMicro[j].vision+=jugador.vision;
                            contenedorMicro[j].tamano+=jugador.tamano;
                            jugador.energia=50;
                            jugador.velocidad=5;
                            jugador.vision=150;
                            jugador.tamano=1;
                            jugador.generarOrganismo(jugador.posX, jugador.posY);
                            //------------------------------------------------------------//
                        }else{
                            
                                if(jugador.tamano>contenedorMicro[j].tamano){
                                    if(jugador.energia<jugador.maxEnergia)
                                    jugador.energia+=contenedorMicro[j].energia;
                                    if(jugador.velocidad<jugador.maxVelocidad)
                                    jugador.velocidad+=contenedorMicro[j].velocidad;
                                    if(jugador.vision<jugador.maxVision)
                                jugador.vision+=contenedorMicro[j].vision;
                                    jugador.tamano+=contenedorMicro[j].tamano;
                                contenedorMicro[j].energia=50;
                                contenedorMicro[j].velocidad=5;
                                contenedorMicro[j].vision=150;
                                contenedorMicro[j].tamano=1;
                                contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);

                                }else if(jugador.tamano<contenedorMicro[j].tamano){
                                    JOptionPane.showConfirmDialog(null, "HAS PERDIDO");
                                    if(contenedorMicro[j].energia<contenedorMicro[j].maxEnergia)
                                    contenedorMicro[j].energia+=jugador.energia;
                                    if(contenedorMicro[j].velocidad<contenedorMicro[j].maxVelocidad)
                                    contenedorMicro[j].velocidad+=jugador.velocidad;
                                    if(contenedorMicro[j].vision<contenedorMicro[j].maxVision)
                                    contenedorMicro[j].vision+=jugador.vision;

                                    contenedorMicro[j].tamano+=jugador.tamano;
                                    jugador.energia=50;
                                    jugador.velocidad=5;
                                    jugador.vision=150;
                                    jugador.tamano=1;
                                    jugador.generarOrganismo(jugador.posX, jugador.posY);
                                    //-----------------------------------------------------//
                                }else
                                {
                                    Microorganismo[] desicion=new Microorganismo[2];
                                    desicion[0]=jugador;
                                    desicion[1]=contenedorMicro[j];
                                    int indice=Aleatorio(0, 1);
                                    if (indice==0){

                                    desicion[1].energia+=desicion[indice].energia;
                                    desicion[1].velocidad+=desicion[indice].velocidad;
                                    desicion[1].vision+=desicion[indice].vision;
                                    desicion[1].tamano+=desicion[indice].tamano;
                                    }else{
                                        desicion[0].energia+=desicion[indice].energia;
                                        desicion[0].velocidad+=desicion[indice].velocidad;
                                        desicion[0].vision+=desicion[indice].vision;
                                        desicion[0].tamano+=desicion[indice].tamano;  
                                    }
                                    desicion[indice].energia=50;
                                    desicion[indice].velocidad=5;
                                    desicion[indice].vision=150;
                                    desicion[indice].tamano=1;
                                    desicion[indice].generarOrganismo(jugador.posX, jugador.posY);
                                }
                        }
                    }
      } 
    }  
    }
    //permite comerse entre organismos y obtener sus stats//
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
                        if(comparado.energia>contenedorMicro[j].energia){
                            comparado.energia+=contenedorMicro[j].energia;
                            comparado.velocidad+=contenedorMicro[j].velocidad;
                            comparado.vision+=contenedorMicro[j].vision;
                            comparado.tamano+=contenedorMicro[j].tamano;
                            contenedorMicro[j].energia=50;
                            contenedorMicro[j].velocidad=5;
                            contenedorMicro[j].vision=150;
                            contenedorMicro[j].tamano=1;
                            contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                        }else if(comparado.energia<contenedorMicro[j].energia){
                            contenedorMicro[j].energia+=comparado.energia;
                            contenedorMicro[j].velocidad+=comparado.velocidad;
                            contenedorMicro[j].vision+=comparado.vision;
                            contenedorMicro[j].tamano+=comparado.tamano;
                            comparado.energia=50;
                            comparado.velocidad=5;
                            comparado.vision=150;
                            comparado.generarOrganismo(jugador.posX, jugador.posY);
                        }else{
                            if(comparado.velocidad>contenedorMicro[j].velocidad){
                                comparado.energia+=contenedorMicro[j].energia;
                                comparado.velocidad+=contenedorMicro[j].velocidad;
                                comparado.vision+=contenedorMicro[j].vision;
                                comparado.tamano+=contenedorMicro[j].tamano;
                            contenedorMicro[j].energia=50;
                            contenedorMicro[j].velocidad=5;
                            contenedorMicro[j].vision=150;
                            contenedorMicro[j].tamano=1;
                            contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                            }else if(comparado.velocidad<contenedorMicro[j].velocidad){
                                contenedorMicro[j].energia+=comparado.energia;
                            contenedorMicro[j].velocidad+=comparado.velocidad;
                            contenedorMicro[j].vision+=comparado.vision;
                            contenedorMicro[j].tamano+=comparado.tamano;
                            comparado.energia=50;
                            comparado.velocidad=5;
                            comparado.vision=150;
                            comparado.generarOrganismo(jugador.posX, jugador.posY);
                            }else{
                                
                                    if(comparado.tamano>contenedorMicro[j].tamano){
                                        comparado.energia+=contenedorMicro[j].energia;
                                        comparado.velocidad+=contenedorMicro[j].velocidad;
                                        comparado.vision+=contenedorMicro[j].vision;
                                        comparado.tamano+=contenedorMicro[j].tamano;
                                    contenedorMicro[j].energia=50;
                                    contenedorMicro[j].velocidad=5;
                                    contenedorMicro[j].vision=150;
                                    contenedorMicro[j].tamano=1;
                                    contenedorMicro[j].generarOrganismo(jugador.posX, jugador.posY);
                                    }else if(comparado.tamano<contenedorMicro[j].tamano){
                                        contenedorMicro[j].energia+=comparado.energia;
                                        contenedorMicro[j].velocidad+=comparado.velocidad;
                                        contenedorMicro[j].vision+=comparado.vision;
                                        contenedorMicro[j].tamano+=comparado.tamano;
                                        comparado.energia=50;
                                        comparado.velocidad=5;
                                        comparado.vision=150;
                                        comparado.generarOrganismo(jugador.posX, jugador.posY);
                                    }else
                                    {
                                        Microorganismo[] desicion=new Microorganismo[2];
                                        desicion[0]=comparado;
                                        desicion[1]=contenedorMicro[j];
                                        int indice=Aleatorio(0, 1);
                                        if (indice==0){
                                        desicion[1].energia+=desicion[indice].energia;
                                        desicion[1].velocidad+=desicion[indice].velocidad;
                                        desicion[1].vision+=desicion[indice].vision;
                                        desicion[1].tamano+=desicion[indice].tamano;
                                        }else{
                                            desicion[0].energia+=desicion[indice].energia;
                                            desicion[0].velocidad+=desicion[indice].velocidad;
                                            desicion[0].vision+=desicion[indice].vision;
                                            desicion[0].tamano+=desicion[indice].tamano;  
                                        }
                                        desicion[indice].energia=50;
                                        desicion[indice].velocidad=5;
                                        desicion[indice].vision=150;
                                        desicion[indice].tamano=1;
                                        desicion[indice].generarOrganismo(jugador.posX, jugador.posY);
                                    }
                            }
                        }
                    }
                }
            }
        }
    }
    //permite generar organismos//
    public static int Aleatorio(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }//permite comer alimento a los organismos//
    public void comerAlimentoOrganismos(){
        Microorganismo comparador;
        for(int j=0;j<6;j++){
            comparador=contenedorMicro[j];
            for(int i=0;i<3;i++){
            if (comparador.posX>(contenedorAlimentoVi[i].posX-30)&&comparador.posX<(contenedorAlimentoVi[i].posX+30) 
            && comparador.posY>(contenedorAlimentoVi[i].posY-30)&&comparador.posY<(contenedorAlimentoVi[i].posY+30) ){
                System.out.println(comparador.vision);
                if( comparador.vision<comparador.maxVision){
                comparador.vision+=contenedorAlimentoVi[i].vision;
                }
                contenedorAlimentoVi[i].generarAlimento(jugador.posX, jugador.posY);
                System.out.println(comparador.vision);
           }    
           else if (comparador.posX>(contenedorAlimentoV[i].posX-30)&&comparador.posX<(contenedorAlimentoV[i].posX+30) 
            && comparador.posY>(contenedorAlimentoV[i].posY-30)&&comparador.posY<(contenedorAlimentoV[i].posY+30) ){
                System.out.println(comparador.velocidad);
                if(comparador.velocidad<comparador.maxVelocidad){
                comparador.velocidad+=contenedorAlimentoV[i].velocidad;
                }
                contenedorAlimentoV[i].generarAlimento(jugador.posX, jugador.posY);
                System.out.println(comparador.velocidad);
           }else if (comparador.posX>(contenedorAlimento[i].posX-30)&&comparador.posX<(contenedorAlimento[i].posX+30) 
           && comparador.posY>(contenedorAlimento[i].posY-30)&&comparador.posY<(contenedorAlimento[i].posY+30) ){
            System.out.println(comparador.energia);
            if(comparador.energia<comparador.maxEnergia){
            comparador.energia+=contenedorAlimento[i].energia;
            }
               contenedorAlimento[i].generarAlimento(jugador.posX, jugador.posY);
               System.out.println(comparador.energia);
          }
        }
        
    }
} //permite huir a los organismos de otros organismos y jugador ademas de buscar alimentos segun su comportamiento//
void huirPrioridad(){
    contenedorMicro[0].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
           
    contenedorMicro[0].huirJugador(jugador);
    contenedorMicro[0].huirMismaEspecie(contenedorMicro);
    contenedorMicro[1].buscarPrioridadEnergia(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
    contenedorMicro[1].huirJugador(jugador);
    contenedorMicro[1].huirMismaEspecie(contenedorMicro);
    contenedorMicro[2].buscarPrioridadVelocidad(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
    contenedorMicro[2].huirJugador(jugador);
    contenedorMicro[2].huirMismaEspecie(contenedorMicro);
    contenedorMicro[3].buscarPrioridadVelocidad(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
    contenedorMicro[3].huirJugador(jugador);
    contenedorMicro[4].huirMismaEspecie(contenedorMicro);
    contenedorMicro[4].buscarPrioridadVision(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
   contenedorMicro[4].huirJugador(jugador);
   contenedorMicro[5].huirMismaEspecie(contenedorMicro);
    contenedorMicro[5].buscarPrioridadVision(contenedorAlimento, contenedorAlimentoV, contenedorAlimentoVi, contenedorMicro);
    contenedorMicro[5].huirJugador(jugador);
    contenedorMicro[5].huirMismaEspecie(contenedorMicro);
}   
}
