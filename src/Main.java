public class Main {

    public static void main(String[] args) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("   SISTEMA DE GESTIÓN SALARIAL DE ARQUITECTOS");
        System.out.println("═".repeat(70) + "\n");

        // Crear calculadora usando el Adapter
        CalculadoraSueldoModerna calculadora = new AdaptadorCalculoSueldo();

        // Crear arquitectos usando el Builder Pattern
        Arquitecto arq1 = new Arquitecto.Builder()
                .codigo("ARQ001")
                .nombres("Juan Carlos Pérez García")
                .condicionContrato(CondicionContrato.ESTABLE)
                .especialidad(Especialidad.ESTRUCTURAS)
                .tipoSupervision(TipoSupervision.OBRAS)
                .numeroObrasAsignadas(15)
                .build();

        Arquitecto arq2 = new Arquitecto.Builder()
                .codigo("ARQ002")
                .nombres("María Elena López Ramírez")
                .condicionContrato(CondicionContrato.CONTRATADO)
                .especialidad(Especialidad.RECURSOS_HIDRICOS)
                .tipoSupervision(TipoSupervision.VIAS)
                .numeroObrasAsignadas(20)
                .build();

        Arquitecto arq3 = new Arquitecto.Builder()
                .codigo("ARQ003")
                .nombres("Carlos Alberto Sánchez Torres")
                .condicionContrato(CondicionContrato.ESTABLE)
                .especialidad(Especialidad.INGENIERIA_VIAL)
                .tipoSupervision(TipoSupervision.VIAS)
                .numeroObrasAsignadas(12)
                .build();

        Arquitecto arq4 = new Arquitecto.Builder()
                .codigo("ARQ004")
                .nombres("Ana Patricia Rodríguez Flores")
                .condicionContrato(CondicionContrato.CONTRATADO)
                .especialidad(Especialidad.ESTRUCTURAS)
                .tipoSupervision(TipoSupervision.OBRAS)
                .numeroObrasAsignadas(18)
                .build();

        // Generar reportes
        ReporteSalarial.generarReporte(arq1, calculadora);
        ReporteSalarial.generarReporte(arq2, calculadora);
        ReporteSalarial.generarReporte(arq3, calculadora);
        ReporteSalarial.generarReporte(arq4, calculadora);

        // Mostrar patrones y principios aplicados
        mostrarPatronesAplicados();
    }

    private static void mostrarPatronesAplicados() {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + centrar("PATRONES DE DISEÑO IMPLEMENTADOS", 68) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");

        System.out.println("║ " + ajustar("", 66) + " ║");
        System.out.println("║ " + ajustar("1. PATRÓN FACTORY (Creacional)", 66) + " ║");
        System.out.println("║ " + ajustar("   Clase: BonificacionFactory", 66) + " ║");
        System.out.println("║ " + ajustar("   Propósito: Encapsula la creación de calculadores de", 66) + " ║");
        System.out.println("║ " + ajustar("   bonificación según la especialidad del arquitecto.", 66) + " ║");
        System.out.println("║ " + ajustar("   Beneficio: Centraliza la lógica de creación y facilita", 66) + " ║");
        System.out.println("║ " + ajustar("   agregar nuevas especialidades sin modificar clientes.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");

        System.out.println("║ " + ajustar("2. PATRÓN BUILDER (Creacional)", 66) + " ║");
        System.out.println("║ " + ajustar("   Clase: Arquitecto.Builder", 66) + " ║");
        System.out.println("║ " + ajustar("   Propósito: Construye objetos Arquitecto de forma fluida", 66) + " ║");
        System.out.println("║ " + ajustar("   y legible, separando construcción de representación.", 66) + " ║");
        System.out.println("║ " + ajustar("   Beneficio: Mejora legibilidad del código y permite", 66) + " ║");
        System.out.println("║ " + ajustar("   construcción paso a paso con validaciones.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");

        System.out.println("║ " + ajustar("3. PATRÓN ADAPTER (Estructural)", 66) + " ║");
        System.out.println("║ " + ajustar("   Clase: AdaptadorCalculoSueldo", 66) + " ║");
        System.out.println("║ " + ajustar("   Propósito: Adapta el sistema de cálculo legado a la", 66) + " ║");
        System.out.println("║ " + ajustar("   interfaz moderna CalculadoraSueldoModerna.", 66) + " ║");
        System.out.println("║ " + ajustar("   Beneficio: Permite integrar código legacy sin", 66) + " ║");
        System.out.println("║ " + ajustar("   modificarlo, manteniendo compatibilidad.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");

        System.out.println("╠" + "═".repeat(68) + "╣");
        System.out.println("║" + centrar("PRINCIPIOS SOLID APLICADOS", 68) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");

        System.out.println("║ " + ajustar("", 66) + " ║");
        System.out.println("║ " + ajustar("• Single Responsibility Principle (SRP)", 66) + " ║");
        System.out.println("║ " + ajustar("  Cada clase tiene una única responsabilidad definida.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");
        System.out.println("║ " + ajustar("• Open/Closed Principle (OCP)", 66) + " ║");
        System.out.println("║ " + ajustar("  Extensible mediante interfaces sin modificar código.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");
        System.out.println("║ " + ajustar("• Dependency Inversion Principle (DIP)", 66) + " ║");
        System.out.println("║ " + ajustar("  Dependencias hacia abstracciones, no implementaciones.", 66) + " ║");
        System.out.println("║ " + ajustar("", 66) + " ║");

        System.out.println("╚" + "═".repeat(68) + "╝");
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