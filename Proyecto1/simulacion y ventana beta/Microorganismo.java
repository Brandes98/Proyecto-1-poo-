import javax.swing.JPanel;
import java.awt.*;


public class Microorganismo extends JPanel {
    String tipo;
    int energia;
    int velocidad;
    int vision;
    int posX;
    int posY;
    int tamano;
    Color identificador;
    public Microorganismo(String tipo, int energia, int velocidad, int vision, int posX, int posY, int tamano, Color identificador) {
        this.tipo = tipo;
        this.energia = energia;
        this.velocidad = velocidad;
        this.vision = vision;
        this.posX = posX;
        this.posY = posY;
        this.tamano = tamano;
        this.identificador=identificador;
    }
    
    public void buscar() {
        
    }
    
    public void huir() {
       
    }
    
    public void comer() {
      
    }
    public void atacar() {
       
    }
}