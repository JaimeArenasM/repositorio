/**
 * Sistema legado que calcula sueldos usando una interfaz diferente
 * Esta clase simula un sistema antiguo con métodos incompatibles
 */
public class SistemaCalculoLegado {

    public double obtenerSueldoBasePorTipo(String tipo, String contrato) {
        if (tipo.equals("OBRAS")) {
            return contrato.equals("ESTABLE") ? 4000 : 2000;
        } else if (tipo.equals("VIAS")) {
            return contrato.equals("ESTABLE") ? 6000 : 4500;
        }
        return 0;
    }

    public double aplicarDescuentoTotal(double monto) {
        double afp = monto * 0.15;
        double snp = monto * 0.08;
        return afp + snp;
    }

    public double sumarConceptos(double base, double bono, double movilidad) {
        return base + bono + movilidad;
    }
}