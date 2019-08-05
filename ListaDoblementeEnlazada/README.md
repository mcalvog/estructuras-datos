# Lista Doblemente Enlazada

>Hasta ahora, el recorrido de una lista se ha realizado en sentido directo (adelante). Existen numerosas aplicaciones en las que es conveniente poder acceder a los elementos o nodos de una lista en cualquier orden, tanto hacia adelante como hacia atrás. En este caso, se recomienda el uso de una lista doblemente enlazada. En esta lista, cada elemento contiene dos punteros (referencias), además del valor almacenado. Una referencia apunta al siguiente elemento de la lista y la otra referencia apunta al elemento anterior.

<p align="right"><b>Estructuras de datos en Java</b> - <i>Luis Joyanes Aguilar</i> e <i>Ignacio Zahonero Martínez</i>.</p>

<br/>

<p align="center"><img src="http://cidecame.uaeh.edu.mx/lcc/mapa/PROYECTO/libro9/listas_doblemente_enlazadas.jpg" alt="Lista doblemente enlazada - cidecame.uaeh.edu.mx" width="600"/></p>
## Métodos implementados

### ListaDoblementeEnlazada

- Insertar al principio de la lista
```java
public void insertarCabezaLista(Object dato) { }
```

- Insertar elemento después de otro en la lista
```java
public void insertaDespues(Nodo anterior, Object dato) { }
```

- Eliminar elemento de la lista
```java
public void eliminar(Object dato) { }
```

- Buscar un elemento en la lista
```java
public Nodo buscarLista(Object dato) { }
```

- Buscar un elemento en la lista mediante su posición
```java
public void eliminar(Object dato) { }
```

- Visualizar contenido de la lista
```java
public void visualizar() { }
```

- Visualizar contenido de la lista mediante iterador
```java
public void visualizarIterador() { }
```

- Obtener el primer nodo de la lista
```java
public Nodo leerCabeza() { }
```

- Comprobar si la lista está vacía
```java
public boolean esVacia() { }
```

### ListaIterador

- Inicializar iterador con una lista
```java
public ListaIterador(ListaDoblementeEnlazada list) { }
```

- Leer el siguiente elemento de la lista
```java
public Object siguiente() { }
```

- Reiniciar iterador a posición inicial
```java
public void reiniciar() { }
```

---

> NOTA: El código recogido en este repositorio está basado en el libro **"Estructuras de datos en Java"**, de _Luis Joyanes Aguilar_ e _Ignacio Zahonero Martínez_. Todos los derechos van a sus respectivos dueños.

Espero que este repositorio te sirva de ayuda. A pesar de estar basado en Java, el código puede ser adaptado a otros lenguajes. Cualquier contribución es bienvenida.

**Contacto:** [marcoscgdev@gmail.com](mailto:marcoscgdev@gmail.com).