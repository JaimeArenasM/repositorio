public class BonificacionRecursosHidricos implements CalculadorBonificacion {
    @Override
    public double calcular(double sueldoBase) {
        return sueldoBase * 0.18;
    }
}