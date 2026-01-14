# GameEngine
# Java 2D Game Engine 🚀

Este es un pequeño motor gráfico 2D desarrollado en Java utilizando **Swing** y **Canvas**. Ha sido diseñado como material pedagógico para enseñar conceptos avanzados de **Programación Orientada a Objetos (POO)** y arquitectura de videojuegos.

## 🛠 Características Técnicas

- **Renderizado Activo**: Uso de `BufferStrategy` (Triple Buffering) para evitar el parpadeo.
- **Game Loop Profesional**: Implementación de **Delta Time** para asegurar que la lógica sea independiente de los FPS.
- **Arquitectura Basada en Escenas**: Sistema desacoplado para gestionar diferentes niveles o estados de juego.
- **Input Manager**: Gestión avanzada de teclado con detección de pulsaciones únicas (`isKeyPressed`) y mantenidas.

## 🏗 Estructura del Proyecto (POO)

El proyecto está dividido en dos grandes bloques para fomentar el bajo acoplamiento:

1.  **`engine`**: El núcleo del motor. Contiene la infraestructura (Ventana, Bucle de juego, Input, Clase base `GameObject` y `Scene`).
2.  **`game`**: El contenido del juego. Donde se implementan los niveles y entidades concretas heredando de la base del motor.

## 🧩 Conceptos de Programación Aplicados

- **Abstracción**: Uso de clases abstractas para definir entidades y escenas.
- **Polimorfismo**: La escena gestiona una lista de `GameObject`, llamando a sus métodos `update` y `render` sin conocer su tipo específico.
- **Encapsulamiento**: Gestión de estados internos de los objetos y acceso mediante modificadores de visibilidad (`protected`, `private`).
- **Composición**: La clase `Game` integra la ventana, el input y la escena actual.

## 🚀 Cómo empezar

1. Clona el repositorio.
2. Abre el proyecto en IntelliJ IDEA.
3. Ejecuta la clase `SimpleGame` ubicada en `SimpleSample`.
4. Usa las teclas **W-A-S-D** o las **Flechas** para mover al jugador.

## 📚 Guía para el Alumnado: Incluye el proyecto como dependencia

### 1. Cómo integrar este Motor en tu propio Proyecto (IntelliJ)
Para trabajar en tu propio juego utilizando este motor como base, sigue estos pasos:

1. Ten abierto **tu propio proyecto** en IntelliJ.
2. Ve a `File` -> `Project Structure...` -> `Modules`.
3. Haz clic en el botón `+` (Plus) y selecciona **Import Module**.
4. Busca la carpeta donde clonaste este motor y selecciona el archivo `.iml` o la carpeta raíz.
5. Elige "Import module from external model" -> **Maven/Gradle** (si aplica) o simplemente sigue el asistente de IntelliJ.
6. **Importante**: En la pestaña `Dependencies` de tu módulo de juego, haz clic en `+` -> `Module Dependency` y selecciona el módulo del motor. Ahora podrás hacer `extends GameObject` desde tus clases.

---

### 2. Cómo mantener el Motor actualizado 🔄
Como el profesor irá añadiendo mejoras al motor (sprites, sonido, colisiones), debes actualizar tu copia local periódicamente.

#### Opción A: Desde la Terminal (Recomendado)
Abre la terminal dentro de la carpeta del motor y escribe:
```bash
# Baja los últimos cambios del servidor
git pull origin main
```


#### Opción B: Desde el IDE (IntelliJ)
1. En la barra superior, ve al menú Git.
2. Selecciona la opción Pull....
3. Asegúrate de que origin/main esté seleccionado y pulsa Pull.
Nota: No te preocupes por perder tu trabajo; como tú solo creas clases en tu propio módulo y no tocas el código del motor, no habrá conflictos de archivos.
---
Creado con fines educativos para la clase de Programación.
