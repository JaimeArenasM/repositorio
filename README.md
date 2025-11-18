# SISTEMA DE GESTIÓN SALARIAL DE ARQUITECTOS

## Descripción del Proyecto
Sistema de gestión salarial que calcula sueldos de arquitectos según su condición de contrato,
especialidad, tipo de supervisión y número de obras asignadas.

## Patrones de Diseño Implementados

### 1. Factory Pattern (Creacional)
- **Clase**: BonificacionFactory
- **Propósito**: Crea calculadores de bonificación según la especialidad
- **Beneficio**: Centraliza la lógica de creación

### 2. Builder Pattern (Creacional)
- **Clase**: Arquitecto.Builder
- **Propósito**: Construcción fluida de objetos Arquitecto
- **Beneficio**: Mejora legibilidad y permite validaciones

### 3. Adapter Pattern (Estructural)
- **Clase**: AdaptadorCalculoSueldo
- **Propósito**: Adapta sistema legado a interfaz moderna
- **Beneficio**: Integra código legacy sin modificarlo

## Principios SOLID Aplicados

- **Single Responsibility Principle (SRP)**: Cada clase tiene una única responsabilidad
- **Open/Closed Principle (OCP)**: Extensible sin modificar código existente
- **Dependency Inversion Principle (DIP)**: Dependencias hacia abstracciones

## Estructura del Proyecto

```
SistemaArquitectos/
├── Enumeraciones/
│   ├── CondicionContrato.java
│   ├── Especialidad.java
│   └── TipoSupervision.java
├── Interfaces/
│   ├── CalculadorBonificacion.java
│   ├── CalculadorMovilidad.java
│   └── CalculadoraSueldoModerna.java
├── Implementaciones/
│   ├── BonificacionEstructuras.java
│   ├── BonificacionRecursosHidricos.java
│   ├── BonificacionIngenieriaVial.java
│   └── MovilidadPorObras.java
├── Patrones/
│   ├── BonificacionFactory.java (Factory)
│   ├── Arquitecto.java (Builder)
│   └── AdaptadorCalculoSueldo.java (Adapter)
├── Utilidades/
│   ├── SistemaCalculoLegado.java
│   └── ReporteSalarial.java
└── Main.java
```

## Instrucciones para NetBeans

### 1. Importar el Proyecto
1. Abrir NetBeans
2. File → Open Project
3. Seleccionar la carpeta "SistemaArquitectos"
4. Click en "Open Project"

### 2. Compilar
- Click derecho en el proyecto → Build
- O presionar F11

### 3. Ejecutar
- Click derecho en Main.java → Run File
- O presionar Shift + F6

### Alternativa: Crear Proyecto Nuevo
1. File → New Project → Java Application
2. Nombre: "SistemaArquitectos"
3. Desmarcar "Create Main Class"
4. Copiar todos los archivos .java a la carpeta src/

## Requisitos
- Java JDK 8 o superior
- NetBeans IDE 8.0 o superior

## Ejemplo de Salida

El programa genera reportes salariales detallados para cada arquitecto:

```
═══════════════════════════════════════════════════════════════════
   SISTEMA DE GESTIÓN SALARIAL DE ARQUITECTOS
═══════════════════════════════════════════════════════════════════

╔════════════════════════════════════════════════════════════════════╗
║              REPORTE SALARIAL DE ARQUITECTO                        ║
╠════════════════════════════════════════════════════════════════════╣
║ DATOS PERSONALES:                                                  ║
║   Código: ARQ001                                                   ║
║   Nombres: Juan Carlos Pérez García                                ║
║   Condición: ESTABLE                                               ║
║   Especialidad: ESTRUCTURAS                                        ║
║   Tipo Supervisión: OBRAS                                          ║
║   Obras Asignadas: 15                                              ║
╠════════════════════════════════════════════════════════════════════╣
║ CÁLCULOS SALARIALES:                                               ║
║   Sueldo Base:              S/  4,000.00                           ║
║   Bonificación (16%):       S/    640.00                           ║
║   Movilidad:                S/    300.00                           ║
║   Descuentos (AFP+SNP):     S/    920.00                           ║
║   ----------------------------------------------                    ║
║   Sueldo Bruto:             S/  4,940.00                           ║
║   Sueldo Neto:              S/  4,020.00                           ║
╚════════════════════════════════════════════════════════════════════╝
```

## Reglas de Cálculo

### Sueldo Base
- Supervisión de Obras Estable: S/ 4,000
- Supervisión de Obras Contratado: S/ 2,000
- Supervisión de Vías Estable: S/ 6,000
- Supervisión de Vías Contratado: S/ 4,500

### Bonificación (% del Sueldo Base)
- Especialidad Estructuras: 16%
- Especialidad Recursos Hídricos: 18%
- Especialidad Ingeniería Vial: 22%

### Movilidad
- Menos de 17 obras: S/ 300
- 17 o más obras: S/ 600

### Descuentos
- AFP: 15% del sueldo base
- SNP: 8% del sueldo base

## Autor
Proyecto desarrollado como ejemplo de aplicación de patrones de diseño en Java.
