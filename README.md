# Sistema de Árbol AVL en Java

Este proyecto implementa un **árbol AVL**, una estructura de datos autoequilibrada que mantiene su balance mediante rotaciones después de cada inserción o eliminación.  
Incluye una implementación completa del árbol, un menú interactivo para gestionarlo y documentación del funcionamiento interno del factor de balance y las rotaciones.

## 📌 Funcionalidades
- **Insertar nodos:** Inserta un valor y aplica la rotación necesaria (LL, RR, LR o RL).  
- **Eliminar nodos:** Elimina un valor del árbol y mantiene el balance del AVL.  
- **Buscar valores:** Permite consultar rápidamente si un elemento existe.  
- **Menú interactivo:** Facilita la interacción desde consola.  
- **Cálculo del factor de balance:** Se evalúa en cada operación para garantizar el equilibrio.  
- **Rotaciones automáticas:** Implementadas en la clase `NodoAVL`.

## 🧩 Estructura del Proyecto
- **NodoAVL:**  
  - Almacena el valor del nodo.  
  - Guarda su altura.  
  - Implementa rotaciones LL, RR, LR y RL.  

- **AVL:**  
  - Contiene la lógica de inserción, búsqueda y eliminación.  
  - Actualiza alturas, factores de balance y aplica rotaciones según corresponda.  

- **Main (menú):**  
  - Permite insertar, eliminar, buscar y mostrar el árbol desde consola.

## 🛠️ Tecnologías Utilizadas
- **Lenguaje:** Java  
- **IDE:** IntelliJ IDEA  
- **Paradigma:** Programación Orientada a Objetos  
- **Tema central:** Estructuras de datos avanzadas (Árboles AVL)

## ▶️ Cómo Ejecutarlo
1. Abrí el proyecto en **IntelliJ IDEA**.  
2. Ejecutá `Main.java`.  
3. Usá el menú para insertar, eliminar o buscar valores en el árbol AVL.

## 📚 Propósito de Aprendizaje
Este proyecto refuerza:
- Uso de **árboles AVL** y estructuras equilibradas.  
- Cálculo y análisis del **factor de balance**.  
- Implementación correcta de rotaciones simples y dobles.  
- Optimización de operaciones de búsqueda, inserción y eliminación.  
- Comprensión de la teoría detrás de los AVL y su aplicación en sistemas reales.

## 🧠 Aplicaciones de los Árboles AVL
- Motores de bases de datos  
- Sistemas de archivos  
- Indexación de información  
- Estructuras de búsqueda eficientes  
- Aplicaciones donde la velocidad y el equilibrio son críticos  

---

✍️ **Autor:** D’Jehovann Dixon Lawrence
