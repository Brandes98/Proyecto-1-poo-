public class Mapa {
    private Microorganismo[][] mapa;
    private int filas;
    private int columnas;
    
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.mapa = new Microorganismo[filas][columnas];
    }
    
    public void mover(int posX, int posY, int nuevaPosX, int nuevaPosY) {
        Microorganismo microorganismo = mapa[posX][posY];
        mapa[posX][posY] = null;
        mapa[nuevaPosX][nuevaPosY] = microorganismo;
        microorganismo.setPosX(nuevaPosX);
        microorganismo.setPosY(nuevaPosY);
    }
    
    public void ubicar(Microorganismo microorganismo, int posX, int posY) {
        mapa[posX][posY] = microorganismo;
        microorganismo.setPosX(posX);
        microorganismo.setPosY(posY);
    }
    
    public boolean limite(int posX, int posY) {
        return (posX < 0 || posX >= filas || posY < 0 || posY >= columnas);
    }
    
    public void turnos() {
     
    }
}
