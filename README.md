☎️ Sistema de Gestión de Agenda Telefónica
🧾 Descripción

Este proyecto es un sistema de agenda telefónica en Java, desarrollado con enfoque modular y orientado a objetos.
Permite gestionar contactos (agregar, listar, buscar, eliminar y modificar) y utiliza excepciones personalizadas para manejar errores de forma clara.

El usuario interactúa con la aplicación mediante un menú por consola.

🧱 Estructura del proyecto
agenda/
│
├── src/
│   └── contacto/
│       ├── exceptions/        # Excepciones personalizadas
│       │   ├── ExceptionAgendaLlena.java
│       │   ├── ExceptionContactoExistente.java
│       │   └── ExceptionContactoNoExiste.java
│       │
│       ├── main/              # Punto de entrada del programa
│       │   └── Main.java
│       │
│       ├── model/             # Clase que define la estructura del contacto
│       │   └── Contacto.java
│       │
│       └── service/           # Clases que implementan la lógica de negocio
│           ├── AgendaLlena.java
│           ├── AgregarContacto.java
│           ├── BuscaContacto.java
│           ├── EliminarContacto.java
│           ├── EspacioLibre.java
│           ├── ExisteContacto.java
│           ├── ListarContactos.java
│           └── ModificarTelefono.java
│
└── README.md

⚙️ Funcionalidades principales

Añadir contacto: Permite registrar un nuevo contacto validando nombre, apellido y duplicados.

Listar contactos: Muestra todos los contactos ordenados alfabéticamente.

Buscar contacto: Busca un contacto por nombre y apellido y muestra su teléfono.

Eliminar contacto: Borra un contacto existente.

Modificar teléfono: Actualiza el número de teléfono de un contacto.

Verificar agenda llena: Indica si se alcanzó la capacidad máxima.

Mostrar espacios libres: Muestra cuántos contactos más se pueden agregar.

⚠️ Validaciones

Los campos nombre y apellido no pueden estar vacíos.

No se permiten contactos duplicados (mismo nombre y apellido, sin importar mayúsculas).

Si la agenda alcanza su límite, se lanza una ExceptionAgendaLlena.

Si se intenta agregar un contacto existente, se lanza una ExceptionContactoExistente.

Si se busca o elimina un contacto inexistente, se lanza una ExceptionContactoNoExiste.

🧠 Diseño del proyecto

El sistema se divide en cuatro capas principales:

Paquete	Función
contacto.model	Define la clase Contacto y su estructura.
contacto.exceptions	Contiene las excepciones personalizadas para manejar errores específicos.
contacto.service	Implementa la lógica de negocio (operaciones sobre la agenda).
contacto.main	Contiene la clase Main con el menú de usuario por consola.
🖥️ Interfaz de consola

El usuario interactúa mediante un menú textual:

===== AGENDA TELEFÓNICA =====
1. Añadir contacto
2. Listar contactos
3. Buscar contacto
4. Eliminar contacto
5. Modificar teléfono
6. Mostrar espacio libre
7. Comprobar si la agenda está llena
8. Salir
==============================
Seleccione una opción:

🧪 Ejemplo de uso
📒 Bienvenido a la Agenda Telefónica
¿Desea definir un tamaño máximo? (s/n): n

Seleccione una opción: 1
Ingrese nombre: Ana
Ingrese apellido: López
Ingrese teléfono: 123456789
✅ Contacto añadido correctamente.

🛠️ Tecnologías

Lenguaje: Java (versión 17)

Ejecución: desde consola o IDE (IntelliJ IDEA, Eclipse, NetBeans)

Paradigma: Programación orientada a objetos

Diseño: modular por paquetes, con manejo de excepciones personalizadas

✨ Autor

Proyecto desarrollado por:
[Ximena Martinez - SCRUM Master](https://github.com/amahiranyy) 
[Karen Nava - Developer](https://github.com/byannakn) 
[Paola Castillo](https://github.com/ailedcastrom) 
[Ernesto Gonzélez - Developer](https://github.com/ironnet10) 
[Ricardo Avilés - Developer](https://github.com/ricardoavi304) 

📅 Año: Noviembre 2025
