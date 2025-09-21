# Agenda TODO

Rama: **agenda**

------------------------------------------------------------------------

## 📋 Descripción

Una aplicación de Android que funciona como agenda de tareas. Permite:

-   Agregar nuevas tareas.
-   Eliminar tareas específicas manteniendo pulsado el ítem (long
    click).
-   Vaciar todos los ítems de la lista ("borrar todo").
-   Confirmar eliminación de tareas mediante diálogo (AlertDialog).
-   Actualizar visualmente la lista al eliminar elementos.

------------------------------------------------------------------------

## 🛠 Tecnologías / Herramientas usadas

-   Java\
-   Android SDK\
-   ListView\
-   ArrayAdapter\
-   AlertDialog\
-   Gradle (Kotlin DSL para scripts de build)\
-   Estructura de proyecto estándar de Android Studio

------------------------------------------------------------------------

## 🚀 Cómo usar / ejecutar el proyecto

1.  Clonar el repositorio:

    ``` bash
    git clone https://github.com/yamidev52/actividad5_yamil.git
    cd actividad5_yamil
    git checkout agenda
    ```

2.  Abrir el proyecto en **Android Studio**.

3.  Esperar que gradle sincronice.

4.  Ejecutar la app en un emulador o dispositivo real con Android
    compatible.
    
------------------------------------------------------------------------

## 📂 Estructura del repositorio

    actividad5_yamil/
    ├── app/
    │   ├── src/
    │   │   ├── main/
    │   │   │   ├── java/    ← código fuente Java
    │   │   │   └── res/     ← layouts, strings, colores, drawables, etc.
    │   └── build.gradle.kts
    ├── .gitignore
    ├── settings.gradle.kts
    ├── gradle.properties
    ├── gradlew / gradlew.bat
    └── README.md

------------------------------------------------------------------------

## 🤝 Colaboración

Si quieres aportar (feature, arreglos, etc.), sigue estos pasos:

1.  Hacer un fork del repositorio.
2.  Crear una rama con el cambio: `git checkout -b mi-funcionalidad`
3.  Hacer los cambios y asegurarse de probar la app.
4.  Hacer commit de los cambios con mensajes claros.
5.  Enviar un pull request describiendo lo que hiciste.
