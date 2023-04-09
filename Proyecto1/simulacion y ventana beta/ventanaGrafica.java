import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ventanaGrafica extends javax.swing.JFrame{
    public JPanel panel;
    JButton[][] tablero;
    int filas=50;
    int columnas=50;

 Mapa mapa;
    public ventanaGrafica(){
        mapa=new Mapa(50, 50);
        add(mapa);
        mapa.setBounds(0,0, 500, 500);
        mapa.setOpaque(false);
       setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("El juego va aqui");
        //setBounds(300,150,500,500);
        setLocationRelativeTo(null);
        //creaTablero();
        initComponents();
    }
    private void initComponents(){
        panel = new JPanel();
        panel.setLayout(null);
        //panel.add()
        this.getContentPane().add(panel);
        creaTablero();
    }
    public void creaTablero(){
        tablero= new JButton[filas][columnas];
        int contx=0;
        int conty=0;
         for (int i = 0; i < filas; i++){
             
             for (int j = 0; j < columnas; j++){
                 tablero[i][j] = new JButton();
                
                 
                 tablero[i][j].setBounds(contx, conty, 30, 30);
                 tablero[i][j].setBackground(Color.BLACK);
                 tablero[i][j].setEnabled(false);
                 panel.add(tablero[i][j]);
                 
                 contx +=30;
                 
                 
               
             }
             
             conty +=30;
             contx = 0;
             
         }
        
 
     }
 
    
   
}
