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
            int direccion = obtenerDireccion(); // Método para obtener la dirección del movimiento
            int nuevaPosX = posX + (direccion == DERECHA ? 1 : -1); // Si dirección es DERECHA, se suma 1 a posX, sino se resta 1
            int nuevaPosY = posY + (direccion == ABAJO ? 1 : -1); // Si dirección es ABAJO, se suma 1 a posY, sino se resta 1
    
            posX = nuevaPosX;
            posY = nuevaPosY;
    
            energia -= consumoEnergiaPorTurno; // Se resta la energía consumida por turno
            reproduccion(); // Método para determinar si se puede reproducir
            actualizarInteraccion(); // Método para actualizar interacción con el entorno
    
            // Lógica específica para el jugador
            if (this instanceof Jugador) {
                int accion = obtenerAccion(); // Método para obtener la acción del jugador
                switch (accion) {
                    case MOVER_DERECHA:
                        moverDerecha();
                        break;
                    case MOVER_IZQUIERDA:
                        moverIzquierda();
                        break;
                    case MOVER_ARRIBA:
                        moverArriba();
                        break;
                    case MOVER_ABAJO:
                        moverAbajo();
                        break;
                    case "buscarAlimento":
                        this.buscarAlimento();
                        break;
                    case "comer":
                        this.comer();
                        break;
                    case "huir":
                        this.huir();
                        break;
                    case "mover":
                        this.mover();
                        break
                    default:
                        // Acción inválida
                        break;
                }
    
                actualizarEstado(); // Método para actualizar estado del jugador
                actualizarInterfazGrafica(); // Método para actualizar interfaz gráfica
            }
        }
    
        // ...
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
