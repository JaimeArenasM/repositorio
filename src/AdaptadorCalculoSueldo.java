/**
 * PATRÓN ADAPTER (Estructural)
 * Adapta el sistema de cálculo legado a la interfaz moderna,
 * permitiendo que clases con interfaces incompatibles trabajen juntas.
 */
public class AdaptadorCalculoSueldo implements CalculadoraSueldoModerna {

    private SistemaCalculoLegado sistemaLegado;
    private CalculadorMovilidad calculadorMovilidad;

    public AdaptadorCalculoSueldo() {
        this.sistemaLegado = new SistemaCalculoLegado();
        this.calculadorMovilidad = new MovilidadPorObras();
    }

    @Override
    public double calcularSueldoBase(Arquitecto arquitecto) {
        // Adapta la llamada al sistema legado
        String tipo = arquitecto.getTipoSupervision().toString();
        String contrato = arquitecto.getCondicionContrato().toString();
        return sistemaLegado.obtenerSueldoBasePorTipo(tipo, contrato);
    }

    @Override
    public double calcularBonificacion(Arquitecto arquitecto) {
        // Usa el Factory para obtener el calculador apropiado
        double sueldoBase = calcularSueldoBase(arquitecto);
        CalculadorBonificacion calculador = BonificacionFactory.crearCalculador(
            arquitecto.getEspecialidad()
        );
        return calculador.calcular(sueldoBase);
    }

    @Override
    public double calcularMovilidad(Arquitecto arquitecto) {
        return calculadorMovilidad.calcular(arquitecto.getNumeroObrasAsignadas());
    }

    @Override
    public double calcularDescuentos(double sueldoBase) {
        // Adapta la llamada al método legado
        return sistemaLegado.aplicarDescuentoTotal(sueldoBase);
    }

    @Override
    public double calcularSueldoBruto(double sueldoBase, double bonificacion, double movilidad) {
        // Adapta la llamada al método legado
        return sistemaLegado.sumarConceptos(sueldoBase, bonificacion, movilidad);
    }

    @Override
    public double calcularSueldoNeto(double sueldoBruto, double descuentos) {
        return sueldoBruto - descuentos;
    }
}