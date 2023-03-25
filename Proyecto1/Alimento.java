public class Alimento {
   int tamano;
    int energia;
    int velocidad;
    int vision;
    
    public Alimento(int tamano, int energia, int velocidad, int vision) {
        this.tamano = tamano;
        this.energia = energia;
        this.velocidad = velocidad;
        this.vision = vision;
    }
    
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
}
