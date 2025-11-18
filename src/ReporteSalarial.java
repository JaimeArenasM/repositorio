public class ReporteSalarial {
    public static void generarReporte(Arquitecto arquitecto, CalculadoraSueldoModerna calculadora) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + centrar("REPORTE SALARIAL", 68) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");
        
        double sueldoBase = calculadora.calcularSueldoBase(arquitecto);
        double bonificacion = calculadora.calcularBonificacion(arquitecto);
        double movilidad = calculadora.calcularMovilidad(arquitecto);
        double sueldoBruto = calculadora.calcularSueldoBruto(sueldoBase, bonificacion, movilidad);
        double descuentos = calculadora.calcularDescuentos(sueldoBase);
        double sueldoNeto = calculadora.calcularSueldoNeto(sueldoBruto, descuentos);
        
        System.out.println("║ Código: " + ajustar(arquitecto.getCodigo(), 57) + "║");
        System.out.println("║ Nombre: " + ajustar(arquitecto.getNombres(), 57) + "║");
        System.out.println("║ Especialidad: " + ajustar(arquitecto.getEspecialidad().toString(), 52) + "║");
        System.out.println("║ Condición: " + ajustar(arquitecto.getCondicionContrato().toString(), 55) + "║");
        System.out.println("║ Supervisión: " + ajustar(arquitecto.getTipoSupervision().toString(), 53) + "║");
        System.out.println("║ Obras asignadas: " + ajustar(String.valueOf(arquitecto.getNumeroObrasAsignadas()), 49) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");
        System.out.println("║ Sueldo Base: " + ajustarDerecha(String.format("S/. %.2f", sueldoBase), 53) + "║");
        System.out.println("║ Bonificación: " + ajustarDerecha(String.format("S/. %.2f", bonificacion), 52) + "║");
        System.out.println("║ Movilidad: " + ajustarDerecha(String.format("S/. %.2f", movilidad), 55) + "║");
        System.out.println("║ Sueldo Bruto: " + ajustarDerecha(String.format("S/. %.2f", sueldoBruto), 52) + "║");
        System.out.println("║ Descuentos: " + ajustarDerecha(String.format("S/. %.2f", descuentos), 54) + "║");
        System.out.println("║ SUELDO NETO: " + ajustarDerecha(String.format("S/. %.2f", sueldoNeto), 53) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝\n");
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
    
    private static String ajustarDerecha(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto.substring(0, ancho);
        }
        return " ".repeat(ancho - texto.length()) + texto;
    }
}