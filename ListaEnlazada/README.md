# Lista Enlazada

>Una lista enlazada es una colección o secuencia de elementos dispuestos uno detrás de otro, en la que cada elemento se conecta al siguiente elemento por un “enlace” o “referencia”. La idea básica consiste en construir una lista cuyos elementos, llamados nodos, se componen de dos partes (campos): la primera parte contiene la información y es, por consiguiente, un valor de un tipo genérico (denominado Dato, TipoElemento, Info , etc.), y la segunda parte es una referencia (denominado enlace o sgte ) que apunta (enlaza) al siguiente elemento de la lista. 

<p align="right"><b>Estructuras de datos en Java</b> - <i>Luis Joyanes Aguilar</i> e <i>Ignacio Zahonero Martínez</i>.</p>

<br/>

<p align="center"><img src="http://www.calcifer.org/documentos/librognome/img/lista.png" alt="Lista enlazada - calcifer.org"/></p>
## Métodos implementados

### Lista

- Insertar al principio de la lista
```java
public void insertarCabezaLista(Object dato) { }
```

- Insertar elemento después de otro en la lista
```java
public void insertarLista(Nodo anterior, Object dato) { }
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
public Nodo leerPrimero() { }
```

- Comprobar si la lista está vacía
```java
public boolean esVacia() { }
```

### ListaOrdenada

Extiende de _Lista_, por lo que hereda todos sus métodos además de:

- Insertar elemento ordenado (entero)
```java
public void insertaOrden(int dato) { }
```

### ListaIterador

- Inicializar iterador con una lista
```java
public ListaIterador(Lista list) { }
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