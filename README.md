# Automatización de Pruebas

## 1. Descripción del proyecto

Este proyecto tiene como objetivo aplicar técnicas y herramientas de automatización de pruebas de software, integrando pruebas unitarias, pruebas basadas en comportamiento (BDD), integración continua y pruebas de rendimiento.

La solución se desarrolla en Java utilizando Maven, JUnit 5, Cucumber y Apache JMeter, incorporando un flujo de integración continua mediante GitHub Actions.

El caso práctico de la Actividad 2 corresponde a una aplicación de reservas de viajes compartidos, orientada a facilitar el transporte de regreso a casa de los trabajadores de una empresa ubicada lejos de la ciudad.

## 2. Tecnologías y herramientas utilizadas

- **Java 17:** lenguaje de programación.
- **Maven:** administración de dependencias y ejecución de pruebas.
- **JUnit 5:** pruebas unitarias.
- **Cucumber:** implementación de pruebas BDD mediante Gherkin.
- **Apache JMeter:** pruebas de rendimiento.
- **Git y GitHub:** control de versiones y alojamiento del proyecto.
- **GitHub Actions:** integración continua y ejecución automatizada del pipeline.
- **Visual Studio Code:** entorno de desarrollo.

## 3. Estructura del proyecto

La estructura principal del repositorio es la siguiente:

```text
automatizacion-pruebas/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── pruebas-rendimiento/
│   └── Prueba_Reservas.jmx
│
├── reportes/
│   └── reporte.html
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── cl/
│   │           └── automatizacion/
│   │               ├── Calculadora.java
│   │               └── ServidorReservas.java
│   │
│   └── test/
│       ├── java/
│       │   └── cl/
│       │       └── automatizacion/
│       │           ├── CalculadoraTest.java
│       │           ├── ReservaViajeSteps.java
│       │           └── RunCucumberTest.java
│       │
│       └── resources/
│           └── features/
│               └── reserva_viaje.feature
│
├── pom.xml
└── README.md
```

## 4. Actividad 1: Automatización de pruebas unitarias

Se desarrolló una calculadora sencilla en Java para implementar y ejecutar pruebas unitarias utilizando JUnit 5.

Se implementaron las siguientes operaciones:

- Suma de dos números.
- Resta de dos números.

Se crearon pruebas para verificar que los resultados de ambas operaciones fueran los esperados.

### Integración continua

Se configuró un pipeline mediante GitHub Actions para automatizar la compilación del proyecto y la ejecución de las pruebas.

El flujo realiza las siguientes tareas:

1. Descarga el código del repositorio.
2. Configura el entorno Java 17.
3. Ejecuta las pruebas mediante Maven.
4. Publica los resultados como artefactos de GitHub Actions.

## 5. Actividad 2: Pruebas BDD y rendimiento

### 5.1. Sesión Three Amigos

Se simuló una sesión Three Amigos para analizar la funcionalidad de reserva de viajes compartidos.

Participaron los siguientes roles:

- **Product Owner:** representa la necesidad del trabajador de reservar un asiento para regresar a casa.
- **QA:** define las validaciones y los escenarios que deben probarse.
- **Desarrollo:** establece la lógica necesaria para confirmar o rechazar las reservas.

Se definieron criterios de aceptación relacionados con la disponibilidad de asientos, la confirmación de reservas válidas y el rechazo de solicitudes que no cumplan las condiciones.

### 5.2. Escenarios BDD con Gherkin

Se utilizó Cucumber para implementar escenarios de comportamiento escritos en Gherkin.

Se desarrollaron los siguientes casos:

- Reserva exitosa de un asiento.
- Validación de disponibilidad de asientos mediante un Esquema del escenario (Scenario Outline).

El esquema contempla distintos ejemplos de disponibilidad, incluyendo reservas confirmadas y rechazadas.

### 5.3. Implementación de pasos

Se implementaron las definiciones de pasos en Java mediante Cucumber.

La lógica permite comprobar la disponibilidad de asientos, procesar las solicitudes y validar el resultado de cada reserva.

### 5.4. Integración BDD en el pipeline

Se incorporaron las pruebas Cucumber al pipeline de GitHub Actions, manteniendo también las pruebas unitarias de JUnit.

Se configuró la generación de un reporte HTML con los resultados de los escenarios BDD.

El reporte se genera en:

`target/cucumber-reports/reporte.html`

Además, se configuró la publicación de los reportes de pruebas como artefactos del pipeline.

## 6. Pruebas de rendimiento con Apache JMeter

Se diseñó una prueba de rendimiento para simular solicitudes de reserva de viajes.

Para realizar la prueba se implementó un servidor local en Java que recibe solicitudes HTTP POST en la ruta `/reservas`.

La configuración de Apache JMeter fue la siguiente:

| Parámetro | Configuración |
|---|---:|
| Usuarios simulados | 10 |
| Tiempo de inicio (Ramp-up) | 5 segundos |
| Iteraciones por usuario | 10 |
| Total de solicitudes | 100 |
| Método HTTP | POST |
| Dirección | localhost:8080 |
| Ruta | /reservas |

El plan de prueba se encuentra en:

`pruebas-rendimiento/Prueba_Reservas.jmx`

### 6.1. Resultados obtenidos

Durante la ejecución local se obtuvieron los siguientes resultados:

| Métrica | Resultado |
|---|---:|
| Solicitudes ejecutadas | 100 |
| Tiempo promedio de respuesta | 1 ms |
| Throughput | 22,5 solicitudes/segundo |
| Porcentaje de errores | 0 % |

### 6.2. Interpretación de métricas

- **TPS / Throughput:** representa la cantidad de solicitudes procesadas por segundo. En esta prueba se obtuvo aproximadamente 22,5 solicitudes por segundo.
- **Latencia:** corresponde al tiempo que tarda el servidor en responder. El promedio registrado fue de 1 ms.
- **Porcentaje de errores:** indica la proporción de solicitudes que terminaron con errores. En esta ejecución fue de 0 %.

Los resultados corresponden a una simulación realizada en un entorno local y no representan mediciones de un sistema productivo.

## 7. Dashboard de métricas

Se incorporó al pipeline un resumen de resultados mediante GitHub Actions.

El dashboard presenta información de las pruebas funcionales y BDD, incluyendo:

- Cantidad total de pruebas.
- Pruebas aprobadas.
- Pruebas fallidas.
- Pruebas omitidas.

También se incorporaron las métricas de referencia obtenidas durante la prueba local de rendimiento con JMeter.

Las métricas de JMeter se muestran como resultados de referencia, ya que su ejecución no forma parte automática del pipeline.

## 8. Alertas automáticas

Se configuró un paso en GitHub Actions para detectar fallos durante la ejecución de las pruebas.

Cuando el pipeline presenta un error, se genera una alerta visible en los registros y en el resumen de ejecución, indicando que se deben revisar los resultados de las pruebas.

Esta configuración permite identificar oportunamente posibles problemas durante el proceso de integración continua.

## 9. Ejecución del proyecto

### Requisitos

- Java JDK 17.
- Apache Maven.
- Git.
- Visual Studio Code.

### Ejecutar las pruebas

Desde la raíz del proyecto, ejecutar:

```bash
mvn test
```

Este comando compila el proyecto y ejecuta las pruebas unitarias y los escenarios BDD.

### Generación del reporte Cucumber

El reporte HTML se genera automáticamente al ejecutar las pruebas y queda disponible en:

```text
target/cucumber-reports/reporte.html
```

### Ejecutar la prueba de rendimiento

1. Iniciar el servidor ejecutando la clase `ServidorReservas.java`.
2. Abrir Apache JMeter.
3. Cargar el archivo `pruebas-rendimiento/Prueba_Reservas.jmx`.
4. Ejecutar el plan de prueba.
5. Revisar los resultados en los componentes Summary Report y View Results Tree.

## 10. Repositorio

El código fuente y los archivos del proyecto se encuentran disponibles en GitHub:

[Repositorio automatizacion-pruebas](https://github.com/MatiSantibanez14/automatizacion-pruebas)
