# Demo de Separación de Responsabilidades (SoC)

Este proyecto es un ejemplo de demostración para explicar el principio de **Separación de Responsabilidades (SoC)** en el desarrollo de software.

## Descripción

El código muestra una aplicación simple de gestión de inventario y procesamiento de pedidos. La lógica de negocio está separada en diferentes clases, cada una con una única responsabilidad, siguiendo el principio de SoC.

## Clases y Responsabilidades

El proyecto está estructurado en las siguientes clases, cada una con un propósito bien definido para lograr una clara Separación de Conceptos:

- **`Main`**: Es el punto de entrada de la aplicación. Su única responsabilidad es orquestar la creación de los objetos principales (`InventoryManager` y `OrderProcessor`) y gestionar el flujo de interacción con el usuario. No contiene lógica de negocio, simplemente delega las tareas a las clases correspondientes.

- **`OrderProcessor`**: Actúa como un coordinador en el proceso de pedidos. Su función es recibir la solicitud para procesar un nuevo producto y delegar la tarea de guardarlo al `InventoryManager`. Esta clase no sabe *cómo* se almacenan los productos, solo sabe *quién* es el responsable de hacerlo. Esto reduce el acoplamiento y hace que el sistema sea más fácil de mantener.

- **`InventoryManager`**: Tiene la única responsabilidad de gestionar el inventario de productos. Encapsula la colección de productos y proporciona métodos para manipularla (como `addProduct`). Si en el futuro se decidiera cambiar el almacenamiento de una lista en memoria a una base de datos, esta sería la única clase que necesitaría ser modificada.

- **`Product`**: Es una clase de datos (un POJO) que representa la entidad "Producto". Contiene únicamente los atributos del producto (`id`, `name`, `price`) y sus métodos de acceso. No tiene ninguna lógica de negocio ni sabe cómo es gestionado o procesado. Su única responsabilidad es contener la información de un producto.

## Diagrama UML

El proyecto incluye un diagrama UML (`diagram.puml`) que visualiza la estructura de clases y sus relaciones:

![Diagrama UML](diagram.puml)

### Relaciones entre Clases

El diagrama muestra tres tipos de relaciones importantes:

#### 1. **Dependencia (Main → OrderProcessor e InventoryManager)**

- Representada con flechas punteadas (`...>`)
- `Main` utiliza temporalmente `OrderProcessor` e `InventoryManager` dentro del método `main()`
- Es una relación débil: `Main` solo necesita estas clases durante su ejecución, pero no las almacena como atributos

#### 2. **Composición (OrderProcessor ◆→ InventoryManager)**

- Representada con un rombo relleno (`*->`)
- `OrderProcessor` **posee** un `InventoryManager` como atributo (`private final`)
- Es una relación fuerte de "todo-parte": el `InventoryManager` forma parte integral del `OrderProcessor`
- **Ciclo de vida compartido**: cuando se destruye el `OrderProcessor`, su `InventoryManager` también deja de existir
- El `OrderProcessor` no puede funcionar sin un `InventoryManager`, y este se pasa en el constructor
- Esta es una **composición** porque:
  - El `InventoryManager` es `final`, por lo que no puede ser cambiado después de la creación
  - Es un atributo privado que no se expone al exterior
  - El `OrderProcessor` controla completamente la vida del `InventoryManager` que recibe

#### 3. **Agregación (InventoryManager ◇→ Product)**

- Representada con un rombo vacío (`o->`)
- `InventoryManager` **contiene** múltiples objetos `Product` en su lista
- Es una relación "tiene-un" más débil que la composición
- **Ciclos de vida independientes**: los objetos `Product` pueden existir independientemente del `InventoryManager`
- Esta es una **agregación** porque:
  - Los productos se crean fuera del `InventoryManager` (en `Main` o dentro del constructor)
  - Los productos podrían ser compartidos por otros componentes del sistema
  - Si se destruye el `InventoryManager`, los objetos `Product` conceptualmente podrían seguir existiendo
  - La lista de productos es mutable y los productos pueden ser añadidos desde el exterior

### ¿Por qué estas distinciones importan?

- **Composición** indica una relación más fuerte y un mayor acoplamiento. Si cambias el `InventoryManager`, probablemente tendrás que revisar el `OrderProcessor`.
- **Agregación** indica una relación más flexible. Podrías cambiar la implementación de cómo se almacenan los productos sin afectar necesariamente a otras partes del sistema.
- **Dependencia** indica el menor acoplamiento posible: solo se usa temporalmente sin crear una relación permanente.

## Características del Lenguaje

Este proyecto utiliza algunas características modernas de Java:

- **Java 25**: El proyecto está configurado para usar Java 25.
- **Método `main` compacto**: Se utiliza la sintaxis simplificada para el método `main` introducida en versiones recientes de Java.
- **Objeto `IO`**: Para la entrada y salida de datos por consola, se utiliza un objeto `IO` personalizado, que simplifica las operaciones de lectura y escritura.

## Cómo ejecutar el proyecto

1. Asegúrate de tener instalado un JDK de Java 25.
2. Ejecuta el método `main` en la clase `Main.java`.
