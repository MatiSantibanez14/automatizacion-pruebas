# Automatización de Pruebas

## 1. Descripción del proyecto

Este proyecto tiene como objetivo implementar pruebas unitarias automatizadas en una aplicación desarrollada en Java, utilizando Maven para la gestión del proyecto y JUnit 5 para la ejecución de las pruebas.

Además, se incorpora un proceso de integración continua mediante GitHub Actions, que permite compilar el proyecto y ejecutar las pruebas automáticamente cada vez que se realizan cambios en el repositorio.

## 2. Tecnologías utilizadas

- **Java 17:** lenguaje de programación.
- **Apache Maven:** herramienta para la gestión y construcción del proyecto.
- **JUnit 5:** framework utilizado para desarrollar y ejecutar las pruebas unitarias.
- **Git:** sistema de control de versiones.
- **GitHub:** plataforma de alojamiento del repositorio.
- **GitHub Actions:** herramienta utilizada para implementar la integración continua.
- **Visual Studio Code:** entorno de desarrollo.

## 3. Estructura del proyecto

```text
automatizacion-pruebas/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── cl/
│   │           └── automatizacion/
│   │               └── Calculadora.java
│   └── test/
│       └── java/
│           └── cl/
│               └── automatizacion/
│                   └── CalculadoraTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## 4. Requisitos previos

Para ejecutar el proyecto se necesita tener instalado:

- Java JDK 17 o superior.
- Apache Maven.
- Git.

## 5. Instalación y ejecución

Clonar el repositorio:

```bash
git clone https://github.com/MatiSantibanez14/automatizacion-pruebas.git
```

Ingresar a la carpeta del proyecto:

```bash
cd automatizacion-pruebas
```

Compilar el proyecto y ejecutar las pruebas unitarias:

```bash
mvn clean test
```

## 6. Pruebas unitarias

Se implementaron dos pruebas unitarias utilizando JUnit 5:

- **Prueba de suma:** verifica que el método `sumar()` entregue el resultado esperado.
- **Prueba de resta:** verifica que el método `restar()` entregue el resultado esperado.

Las pruebas permiten comprobar de manera individual el comportamiento de los métodos de la clase `Calculadora`.

## 7. Integración continua

Se configuró un pipeline mediante GitHub Actions, ubicado en:

`.github/workflows/ci.yml`

El pipeline se ejecuta automáticamente cuando se realizan cambios mediante `push` o `pull request` en las ramas `main` y `develop`.

El proceso contempla las siguientes etapas:

1. Descarga del código del repositorio.
2. Configuración del entorno Java 17.
3. Compilación del proyecto y ejecución de las pruebas unitarias.
4. Publicación de los resultados de las pruebas como artefactos.

Los resultados pueden consultarse desde la pestaña **Actions** del repositorio de GitHub.

## 8. Repositorio

[Repositorio del proyecto en GitHub](https://github.com/MatiSantibanez14/automatizacion-pruebas)
