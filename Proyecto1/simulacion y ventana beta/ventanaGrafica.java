import java.awt.*;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ventanaGrafica extends javax.swing.JFrame{
    public JPanel panel;
  private int filas=50;
  private int columnas=50;
  JButton[][] tablero;
    public ventanaGrafica(){
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
        
        this.getContentPane().add(panel);
       etiquetar();
       creaTablero();
    }
    private void etiquetar(){
        JLabel etiqueta=new JLabel("probando la etiqueta");
        etiqueta.setBounds(10, 20,150, 20);
        //panel.add(etiqueta);
    }
    public void creaTablero(){
       tablero= new JButton[filas][columnas];
       int contx=10;
       int conty=10;
        for (int i = 0; i < filas; i++){
            
            for (int j = 0; j < columnas; j++){
                tablero[i][j] = new JButton();
               
                
                tablero[i][j].setBounds(contx, conty, 30, 30);
                tablero[i][j].setText("jeje");
                panel.add(tablero[i][j]);
                
                contx +=30;
                
                
              
            }
            
            conty +=30;
            contx = 10;
            
        }
       

    }
}
