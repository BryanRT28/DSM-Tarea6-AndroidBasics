# DSM - Tarea 6: Android Basics with Compose (Unidad 4)

Repositorio correspondiente al desarrollo de las actividades, proyectos prácticos y sustentaciones de la **Unidad 4: Arquitectura, Navegación y Diseños Adaptables en Android**, del curso de **Desarrollo de Sistemas Móviles** en la Universidad Nacional Mayor de San Marcos (UNMSM).

---

##  Estructura del Repositorio

- `ruta1-kotlin/`: Ruta 1 - Componentes de la Arquitectura de Android (`Unscramble`).
- `ruta2-kotlin/`: Ruta 2 - Navegación en Jetpack Compose (`Cupcake`).
- `ruta3-kotlin/`: Ruta 3 - Diseños adaptables y responsivos (`Reply`).
- `README.md`: Documentación general de entrega.

---

##  Contenido de las Rutas

###  Ruta 1: Componentes de la Arquitectura de Android (`Unscramble`)
- **Descripción:** Implementación de arquitectura moderna basada en el flujo unidireccional de datos (UDF), separación de capas e inmutabilidad del estado.
- **Conceptos clave:** `ViewModel`, `StateFlow`, `asStateFlow()` y retención del estado ante rotaciones de pantalla.

###  Ruta 2: Navegación en Jetpack Compose (`Cupcake`)
- **Descripción:** Gestión de flujos multipantalla para un proceso de orden y compra de cupcakes.
- **Conceptos clave:** `NavHost`, `rememberNavController()`, rutas tipadas con `enum CupcakeScreen`, botón de navegación dinámica en `TopAppBar` e `Intent` implícito (`ACTION_SEND`).

###  Ruta 3: Adáptate a diferentes tamaños de pantalla (`Reply`)
- **Descripción:** Adaptación dinámica de interfaces para distintos factores de forma (smartphones, pantallas plegables y tablets).
- **Conceptos clave:** `WindowWidthSizeClass` (Compact, Medium, Expanded), alternancia entre `NavigationBar` y `NavigationRail`, y patrón de diseño de doble columna Lista-Detalle (`List-Detail`).

---

##  Tecnologías y Entorno

- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose (Material 3)
- **IDE:** Android Studio
- **Target SDK:** Android 14+ (API 34 / 35)
