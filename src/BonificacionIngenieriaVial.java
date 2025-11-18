public class BonificacionIngenieriaVial implements CalculadorBonificacion {
    @Override
    public double calcular(double sueldoBase) {
        return sueldoBase * 0.22;
    }
}