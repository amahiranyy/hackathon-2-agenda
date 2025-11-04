package contacto.service;

import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;
import java.util.Scanner;

import java.util.List;

public class BuscaContacto {
    public Contacto buscar(List<Contacto> contacto, String nombre, String apellido) throws ExceptionContactoNoExiste {

        String nombreBuscado = nombre == null ? "" : nombre.trim().toLowerCase() ;
        String apellidoBuscado = apellido == null ? "" : apellido.trim().toLowerCase();
        for (Contacto contactoActual : contacto){
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
    // Metodo estático para usar directamente desde el menú principal
    public void ejecutar() {
        ListarContactos listarContactos= new ListarContactos();
        Scanner scanner = new Scanner(System.in);
        BuscaContacto buscador = new BuscaContacto();

        System.out.println("** Buscar un contacto **");

        System.out.print("Nombre del contacto: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido del contacto: ");
        String apellido = scanner.nextLine();

        try {
            Contacto encontrado = buscador.buscar(listarContactos.contacto, nombre, apellido);
            System.out.println("Contacto encontrado:");
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Apellido: " + encontrado.getApellido());
            System.out.println("Teléfono: " + encontrado.getNumero());
        } catch (ExceptionContactoNoExiste e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
