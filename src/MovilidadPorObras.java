public class MovilidadPorObras implements CalculadorMovilidad {
    @Override
    public double calcular(int numeroObras) {
        return numeroObras < 17 ? 300 : 600;
    }
}