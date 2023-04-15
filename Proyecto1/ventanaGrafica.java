import java.awt.*;


import javax.swing.JButton;

import javax.swing.JPanel;
public class ventanaGrafica extends javax.swing.JFrame{
    //instancia variables
    public JPanel panel;
    JButton[][] tablero;
    int filas=50;
    int columnas=50;

 Mapa mapa;
 //constructor donde se inica los componentes y asi mismo define el tamano de la pantalla, ademas de agregar elementos a la interfaz
    public ventanaGrafica(){
        mapa=new Mapa(50, 50);
        add(mapa);
        mapa.setBounds(0,0, 750, 1000);
        mapa.setOpaque(false);
       setSize(750, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bacterias al ataque");
        //setBounds(300,150,500,500);
        setLocationRelativeTo(null);
        //creaTablero();
        initComponents();
    }//almacena los componentes de la interfaz
    private void initComponents(){
        panel = new JPanel();
        panel.setLayout(null);
        //panel.add()
        this.getContentPane().add(panel);
        creaTablero();
    }//crea el tablero dle juego
    public void creaTablero(){
        tablero= new JButton[filas][columnas];
        int contx=0;
        int conty=0;
         for (int i = 0; i < filas; i++){
             
             for (int j = 0; j < columnas; j++){
                 tablero[i][j] = new JButton();
                
                 
                 tablero[i][j].setBounds(contx, conty, 15, 15);
                 tablero[i][j].setBackground(Color.BLACK);
                 tablero[i][j].setEnabled(false);
                 panel.add(tablero[i][j]);
                 
                 contx +=15;
                 
                 
               
             }
             
             conty +=15;
             contx = 0;
             
         }
        
 
     }
 
    
   
}
