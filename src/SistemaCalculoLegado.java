public class SistemaCalculoLegado {
    public double obtenerSueldoBasePorTipo(String tipo, String contrato) {
        double base = 0;
        if (tipo.equals("OBRAS")) {
            base = contrato.equals("ESTABLE") ? 3500.0 : 3000.0;
        } else if (tipo.equals("VIAS")) {
            base = contrato.equals("ESTABLE") ? 4000.0 : 3500.0;
        }
        return base;
    }

    public double aplicarDescuentoTotal(double sueldoBase) {
        double afp = sueldoBase * 0.13;
        double seguro = sueldoBase * 0.09;
        return afp + seguro;
    }

    public double sumarConceptos(double sueldoBase, double bonificacion, double movilidad) {
        return sueldoBase + bonificacion + movilidad;
    }
}