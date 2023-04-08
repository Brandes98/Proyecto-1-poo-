import java.util.*;

public class Jugador extends Microorganismo {
    private Map<String, Integer> prioridades;
    private List<String> personalidad;
    private List<String> acciones;

    public Jugador(int maxEnergia, int minEnergia, int maxVision, int minVision,
            int maxVelocidad, int minVelocidad, int maxEdad, int minEdad) {
        super(maxEnergia, minEnergia, maxVision, minVision, maxVelocidad, minVelocidad, maxEdad, minEdad);
        this.prioridades = new HashMap<>();
        this.personalidad = new ArrayList<>();
        this.acciones = new ArrayList<>();
    }

    public void setPrioridad(String caracteristica, int valor) {
        this.prioridades.put(caracteristica, valor);
    }

    public void setPersonalidad(List<String> personalidad) {
        this.personalidad = personalidad;
    }

    public void setAcciones(List<String> acciones) {
        this.acciones = acciones;
    }

    public void tomarDecision(Map<String, List<Microorganismo>> entorno) {
        Map<String, Integer> opciones = new HashMap<>();
        for (String accion : this.acciones) {
            opciones.put(accion, 0);
        }
        for (String caracteristica : this.prioridades.keySet()) {
            for (Microorganismo m : entorno.get(caracteristica)) {
                if (m instanceof NPC) {
                    opciones.put(this.personalidad.get(0), opciones.get(this.personalidad.get(0)) + this.prioridades.get(caracteristica));
                    opciones.put(this.personalidad.get(1), opciones.get(this.personalidad.get(1)) - this.prioridades.get(caracteristica));
                } else {
                    opciones.put(this.personalidad.get(0), opciones.get(this.personalidad.get(0)) - this.prioridades.get(caracteristica));
                    opciones.put(this.personalidad.get(1), opciones.get(this.personalidad.get(1)) + this.prioridades.get(caracteristica));
                }
            }
        }
        String accionElegida = Collections.max(opciones.entrySet(), Map.Entry.comparingByValue()).getKey();
        switch (accionElegida) {
            case "comer":
                this.comer();
                break;
            case "huir":
                this.huir();
                break;
            case "perseguir":
                this.perseguir();
                break;
            case "descansar":
                this.descansar();
                break;
            default:
                System.out.println("Acción inválida");
                break;
        }
    }
}
