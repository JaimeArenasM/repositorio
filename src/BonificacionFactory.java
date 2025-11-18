public class BonificacionFactory {
    
    public static CalculadorBonificacion crearCalculador(Especialidad especialidad) {
        switch (especialidad) {
            case ESTRUCTURAS:
                return new BonificacionEstructuras();
            case RECURSOS_HIDRICOS:
                return new BonificacionRecursosHidricos();
            case INGENIERIA_VIAL:
                return new BonificacionIngenieriaVial();
            default:
                throw new IllegalArgumentException("Especialidad no válida: " + especialidad);
        }
    }
    
    public static double obtenerPorcentaje(Especialidad especialidad) {
        switch (especialidad) {
            case ESTRUCTURAS: return 16.0;
            case RECURSOS_HIDRICOS: return 18.0;
            case INGENIERIA_VIAL: return 22.0;
            default: return 0.0;
        }
    }
}