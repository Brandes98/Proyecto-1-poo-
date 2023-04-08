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
    
    public void turno() {
        // Actualizar la edad de todos los microorganismos
        for (Microorganismo m : microorganismos) {
            m.aumentarEdad();
        }
        
        // Mover a los microorganismos en el mapa
        for (Microorganismo m : microorganismos) {
            m.mover(mapa);
        }
        
        // Comprobar si algún microorganismo ha sido comido
        for (Microorganismo m : microorganismos) {
            Microorganismo otro = mapa.hayComida(m.getPosicion()) ? null : mapa.getMicroorganismo(m.getPosicion());
            m.comer(mapa.getComida(m.getPosicion()));
            m.atacar(otro);
            otro = m.esComido() ? m.getAtacante() : otro;
            microorganismos.remove(otro);
        }
        
        // Mover al jugador en el mapa
        jugador.mover(mapa);
        
        // Comprobar si el jugador ha encontrado comida
        Comida comidaEncontrada = mapa.hayComida(jugador.getPosicion()) ? mapa.getComida(jugador.getPosicion()) : null;
        jugador.comer(comidaEncontrada);
        mapa.eliminarComida(jugador.getPosicion());
    }
    
}
