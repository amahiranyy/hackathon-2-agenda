package contacto.service;
import contacto.model.Contacto;
import java.util.Scanner;

public class ModificarTelefono {
    ListarContactos listaContactos = new ListarContactos();

    // Metodo que modifica el teléfono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        boolean encontrado = false;

        for (Contacto contacto : listaContactos.contacto) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                contacto.setNumero(nuevoTelefono);
                System.out.println("✅ Teléfono actualizado correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("⚠No se encontró un contacto con ese nombre y apellido.");
        }
    }

    // integración con el menú
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Modificar el número de teléfono de un contacto **");
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del contacto: ");
        String apellido = scanner.nextLine();
        // Verificar si el contacto existe antes de pedir el nuevo número
        ExisteContacto existeContacto = new ExisteContacto();
        boolean existe = existeContacto.existeContacto(nombre, apellido);

        if (existe) {
            System.out.print("Ingrese el nuevo número de teléfono: ");
            String nuevoTelefono = scanner.nextLine();

            ModificarTelefono mt = new ModificarTelefono();
            mt.modificarTelefono(nombre, apellido, nuevoTelefono);
        } else {
            System.out.println("❌ El contacto " + nombre + " " + apellido + " no existe en la agenda.");
        }
    }
}