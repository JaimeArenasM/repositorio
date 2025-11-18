public interface CalculadoraSueldoModerna {
    double calcularSueldoBase(Arquitecto arquitecto);
    double calcularBonificacion(Arquitecto arquitecto);
    double calcularMovilidad(Arquitecto arquitecto);
    double calcularDescuentos(double sueldoBase);
    double calcularSueldoBruto(double sueldoBase, double bonificacion, double movilidad);
    double calcularSueldoNeto(double sueldoBruto, double descuentos);
}