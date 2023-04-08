
import java.util.Random;

public class Microorganismo {
    int energia;
    int vision;
    int velocidad;
    int edad;
    int maxEnergia;
    int minEnergia;
    int maxVision;
    int minVision;
    int maxVelocidad;
    int minVelocidad;
    int incrementoEnergia;
    int decrementoEnergia;
    int incrementoVision;
    int decrementoVision;
    int incrementoVelocidad;
    int decrementoVelocidad;

    public Microorganismo(int maxEnergia, int minEnergia, int maxVision, int minVision, int maxVelocidad, int minVelocidad,
                           int incrementoEnergia, int decrementoEnergia, int incrementoVision, int decrementoVision, int incrementoVelocidad, int decrementoVelocidad) 
        this.energia = (maxEnergia + minEnergia) / 2; // Energía inicial promedio
        this.vision = (maxVision + minVision) / 2; // Visión inicial promedio
        this.velocidad = (maxVelocidad + minVelocidad) / 2; // Velocidad inicial promedio
        this.edad = 0;
        this.maxEnergia = maxEnergia;
        this.minEnergia = minEnergia;
        this.maxVision = maxVision;
        this.minVision = minVision;
        this.maxVelocidad = maxVelocidad;
        this.minVelocidad = minVelocidad;
        this.incrementoEnergia = incrementoEnergia;
        this.decrementoEnergia = decrementoEnergia;
        this.incrementoVision = incrementoVision;
        this.decrementoVision = decrementoVision;
        this.incrementoVelocidad = incrementoVelocidad;
        this.decrementoVelocidad = decrementoVelocidad;
  
                           }

      // Getters y setters
    public int getEnergia() {
        return energia;
    }

    public int getVision() {
        return vision;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getEdad() {
        return edad;
    }



    // Métodos
    public void mover() {
        int energyChange = 0;
        int visionChange = 0;
        int speedChange = 0;
        
        // Determinar el cambio de energía
        energyChange -= energiaConsumidaPorMovimiento();
        if (alimentoCercano()) {
            energyChange += gananciaEnergiaAlimento();
        }
        
        // Determinar el cambio de visión y velocidad
        visionChange += gananciaVisionAlimento();
        speedChange += gananciaVelocidadAlimento();
        
        // Aplicar los cambios en las características
        energia += energyChange;
        vision += visionChange;
        velocidad += speedChange;
        
        // Incrementar la edad
        edad++;
    }
    
    public void comer(Alimento alimento) {
        int maxEnergia = getMaxEnergia();
        int maxVision = getMaxVision();
        int maxVelocidad = getMaxVelocidad();
        
        // Aumentar la energía, la visión y la velocidad del organismo
        energia = (energia + alimento.getEnergia() > maxEnergia) ? maxEnergia : energia + alimento.getEnergia();
        vision = (vision + alimento.getVision() > maxVision) ? maxVision : vision + alimento.getVision();
        velocidad = (velocidad + alimento.getVelocidad() > maxVelocidad) ? maxVelocidad : velocidad + alimento.getVelocidad();
        
        // Eliminar el alimento del entorno
        entorno.eliminarAlimento(alimento);
    }
    
    
    
    public Alimento buscarAlimento(Mapa[] alimentos) {
        // Obtener el alimento más cercano en el arreglo de alimentos
        Alimento alimentoCercano = Stream.of(alimentos)
                .min(Comparator.comparingDouble(a -> this.distancia(a)))
                .orElse(null);
                
        // Devolver el alimento más cercano si la distancia es menor que la visión del microorganismo
        return (alimentoCercano != null && this.distancia(alimentoCercano) <= this.vision) ? alimentoCercano : null;
    }
    
    
    public void atacar(Microorganismo otro) {
        // Obtener los atributos a comparar
        int miEnergia = this.getEnergia();
        int miVelocidad = this.getVelocidad();
        int miEdad = this.getEdad();
        int suEnergia = otro.getEnergia();
        int suVelocidad = otro.getVelocidad();
        int suEdad = otro.getEdad();
    
        // Calcular el ganador basándose en los atributos
        Microorganismo ganador = (miEnergia > suEnergia) ? this
                : (suEnergia > miEnergia) ? otro
                : (miVelocidad > suVelocidad) ? this
                : (suVelocidad > miVelocidad) ? otro
                : (miEdad > suEdad) ? this
                : (suEdad > miEdad) ? otro
                : (Math.random() < 0.5) ? this
                : otro;
    
        // El ganador consume al perdedor
        if (ganador == this) {
            otro.consumir(this);
        } else {
            this.consumir(otro);
        }
    }
    
    
    public void serComido(Microorganismo atacante) {
        this.energia -= this.energia / 2;
        this.vision -= this.vision / 2;
        this.velocidad -= this.velocidad / 2;
    
        atacante.energia += this.energia / 2;
        atacante.vision += this.vision / 2;
        atacante.velocidad += this.velocidad / 2;
    }
    
    
    public void huir(Microorganismo perseguidor) {
        // Calcular la dirección opuesta a la del perseguidor
        int deltaX = perseguidor.posicion.x - this.posicion.x;
        int deltaY = perseguidor.posicion.y - this.posicion.y;
        int dirX = deltaX == 0 ? 0 : deltaX / Math.abs(deltaX);
        int dirY = deltaY == 0 ? 0 : deltaY / Math.abs(deltaY);
        int nuevaX = this.posicion.x + dirX * this.velocidad;
        int nuevaY = this.posicion.y + dirY * this.velocidad;
        // Verificar que la nueva posición esté dentro del área de juego
        nuevaX = Math.max(0, Math.min(nuevaX, Microorganismo.AREA_ANCHO - 1));
        nuevaY = Math.max(0, Math.min(nuevaY, Microorganismo.AREA_ALTO - 1));
        // Mover el microorganismo a la nueva posición
        this.posicion = new Point(nuevaX, nuevaY);
    }
    
    public boolean estaEnRango(Microorganismo otro) {
        int distancia = (int) Math.sqrt(Math.pow(this.getX() - otro.getX(), 2) + Math.pow(this.getY() - otro.getY(), 2));
        return distancia <= vision;
    }
 