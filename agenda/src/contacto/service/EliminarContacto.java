package contacto.service;

import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;

import java.util.Scanner;

public class EliminarContacto {
    ListarContactos listaContactos = new ListarContactos();
    BuscaContacto buscarContacto = new BuscaContacto();

    // Eliminar contacto por nombre y apellido
    public void eliminarContacto(String nombreBuscado, String apellidoBuscado) {
        Contacto encontrarContacto = buscarContacto.buscar(listaContactos.contacto, nombreBuscado, apellidoBuscado);

        if (encontrarContacto != null) {
            boolean eliminado = listaContactos.contacto.remove(encontrarContacto);
            if (eliminado) {
                System.out.println("✅ Se eliminó exitosamente el contacto: " +
                        encontrarContacto.getNombre() + " " + encontrarContacto.getApellido());
            } else {
                System.out.println("⚠️ No se pudo eliminar el contacto por alguna razón interna.");
            }
        } else {
            throw new ExceptionContactoNoExiste("❌ Contacto no encontrado. Verifica el nombre y apellido para eliminarlo de tu agenda.");
        }
    }
    // integración con el menú
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Eliminar un contacto **");
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del contacto: ");
        String apellido = scanner.nextLine();

        eliminarContacto(nombre, apellido);
    }
}
