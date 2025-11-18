/**
 * Clase auxiliar para generar reportes detallados
 */
public class ReporteSalarial {

    public static void generarReporte(Arquitecto arquitecto, CalculadoraSueldoModerna calculadora) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + centrar("REPORTE SALARIAL DE ARQUITECTO", 68) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");

        // Datos personales
        System.out.println("║ " + ajustar("DATOS PERSONALES:", 66) + " ║");
        System.out.println("║ " + ajustar("  Código: " + arquitecto.getCodigo(), 66) + " ║");
        System.out.println("║ " + ajustar("  Nombres: " + arquitecto.getNombres(), 66) + " ║");
        System.out.println("║ " + ajustar("  Condición: " + arquitecto.getCondicionContrato(), 66) + " ║");
        System.out.println("║ " + ajustar("  Especialidad: " + arquitecto.getEspecialidad(), 66) + " ║");
        System.out.println("║ " + ajustar("  Tipo Supervisión: " + arquitecto.getTipoSupervision(), 66) + " ║");
        System.out.println("║ " + ajustar("  Obras Asignadas: " + arquitecto.getNumeroObrasAsignadas(), 66) + " ║");

        System.out.println("╠" + "═".repeat(68) + "╣");

        // Cálculos salariales
        double sueldoBase = calculadora.calcularSueldoBase(arquitecto);
        double bonificacion = calculadora.calcularBonificacion(arquitecto);
        double movilidad = calculadora.calcularMovilidad(arquitecto);
        double descuentos = calculadora.calcularDescuentos(sueldoBase);
        double sueldoBruto = calculadora.calcularSueldoBruto(sueldoBase, bonificacion, movilidad);
        double sueldoNeto = calculadora.calcularSueldoNeto(sueldoBruto, descuentos);

        double porcentajeBonif = BonificacionFactory.obtenerPorcentaje(arquitecto.getEspecialidad());

        System.out.println("║ " + ajustar("CÁLCULOS SALARIALES:", 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Sueldo Base:              S/ %,10.2f", sueldoBase), 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Bonificación (%.0f%%):        S/ %,10.2f", porcentajeBonif, bonificacion), 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Movilidad:                S/ %,10.2f", movilidad), 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Descuentos (AFP+SNP):     S/ %,10.2f", descuentos), 66) + " ║");
        System.out.println("║ " + ajustar("  " + "-".repeat(46), 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Sueldo Bruto:             S/ %,10.2f", sueldoBruto), 66) + " ║");
        System.out.println("║ " + ajustar(String.format("  Sueldo Neto:              S/ %,10.2f", sueldoNeto), 66) + " ║");

        System.out.println("╚" + "═".repeat(68) + "╝");
        System.out.println();
    }

    private static String centrar(String texto, int ancho) {
        int padding = (ancho - texto.length()) / 2;
        return " ".repeat(padding) + texto + " ".repeat(ancho - padding - texto.length());
    }

    private static String ajustar(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto.substring(0, ancho);
        }
        return texto + " ".repeat(ancho - texto.length());
    }
}