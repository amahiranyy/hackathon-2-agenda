package contacto.service;

import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;
import java.util.Scanner;
import java.util.List;

public class BuscaContacto {

    /**
     * Método que busca un contacto en una lista por nombre y apellido.
     *
     * @param contacto Lista de contactos donde se va a buscar.
     * @param nombre Nombre del contacto a buscar.
     * @param apellido Apellido del contacto a buscar.
     * @return Devuelve el objeto Contacto encontrado.
     * @throws ExceptionContactoNoExiste Si no se encuentra ningún contacto que coincida.
     */
    public Contacto buscar(List<Contacto> contacto, String nombre, String apellido) throws ExceptionContactoNoExiste {

        // Normaliza el nombre y apellido ingresados:
        // - Si es null, se reemplaza con una cadena vacía
        // - Se eliminan espacios sobrantes y se pasa a minúsculas
        String nombreBuscado = nombre == null ? "" : nombre.trim().toLowerCase();
        String apellidoBuscado = apellido == null ? "" : apellido.trim().toLowerCase();

        // Recorre la lista de contactos existente
        for (Contacto contactoActual : contacto) {
            // Normaliza también los datos del contacto actual para hacer una comparación insensible a mayúsculas y espacios
            String nombreActual = contactoActual.getNombre() == null ? "" : contactoActual.getNombre().trim().toLowerCase();
            String apellidoActual = contactoActual.getApellido() == null ? "" : contactoActual.getApellido().trim().toLowerCase();

            // Compara nombre y apellido normalizados
            if (nombreActual.equals(nombreBuscado) && apellidoActual.equals(apellidoBuscado)) {
                // Si hay coincidencia exacta, se devuelve el contacto encontrado
                return contactoActual;
            }
        }

        // Si se recorrió toda la lista y no se encontró coincidencia, se lanza una excepción personalizada
        throw new ExceptionContactoNoExiste("El contacto no existe");
    }

    /**
     * Método de ejecución pensado para integrarse con el menú principal.
     * Permite buscar un contacto de manera interactiva por consola.
     */
    public void ejecutar() {
        // Se crea una instancia de la clase ListarContactos para acceder a la lista de contactos existente
        ListarContactos listarContactos = new ListarContactos();

        // Objeto Scanner para leer entrada del usuario por consola
        Scanner scanner = new Scanner(System.in);

        // Se crea una instancia del propio buscador
        BuscaContacto buscador = new BuscaContacto();

        System.out.println("** Buscar un contacto **");

        // Solicita al usuario el nombre del contacto a buscar
        System.out.print("Nombre del contacto: ");
        String nombre = scanner.nextLine();

        // Solicita el apellido del contacto
        System.out.print("Apellido del contacto: ");
        String apellido = scanner.nextLine();

        try {
            // Llama al método 'buscar' pasándole la lista estática de contactos desde ListarContactos
            Contacto encontrado = buscador.buscar(listarContactos.contacto, nombre, apellido);

            // Si el contacto se encuentra, se muestra su información
            System.out.println("Contacto encontrado:");
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Apellido: " + encontrado.getApellido());
            System.out.println("Teléfono: " + encontrado.getNumero());

        } catch (ExceptionContactoNoExiste e) {
            // Si la búsqueda falla, se muestra el mensaje de error definido en la excepción personalizada
            System.out.println("❌ " + e.getMessage());
        }
    }
}
