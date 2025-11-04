package contacto.service;

import contacto.model.Contacto;

import java.util.Scanner;

public class AgregarContacto {
    public void agregarContacto(Contacto contacto) {
        // Validar nombre y apellido no vacíos
        if (contacto.getNombre().trim().isEmpty() || contacto.getApellido().trim().isEmpty()) {
            System.out.println("❌ El nombre y apellido no pueden estar vacíos.");
            return;
        }

        // Validar número de teléfono: exactamente 10 dígitos
        String numero = contacto.getNumero().trim();
        if (!numero.matches("\\d{10}")) {
            System.out.println("❌ El número de teléfono debe tener exactamente 10 dígitos numéricos.");
            return;
        }

        // Verificar si hay espacio disponible
        EspacioLibre espacioLibre = new EspacioLibre();
        int espacio = espacioLibre.espacioLibre();
        if (espacio <= 0) {
            System.out.println("❌ La agenda está llena. No se puede agregar más contactos.");
            return;
        }

        // Verificar si el contacto ya existe
        ExisteContacto existeContacto = new ExisteContacto();
        if (existeContacto.existeContacto(contacto.getNombre(), contacto.getApellido())) {
            System.out.println("⚠️ El contacto ya existe. No se pudo registrar.");
            return;
        }

        // Agregar el contacto
        ListarContactos.contacto.add(contacto);
        System.out.println("✅ Contacto añadido exitosamente: " +
                contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
    }

    // integración con el menú
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Agregar un contacto nuevo **");
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del contacto: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        String telefono = scanner.nextLine();

        // Crear el objeto Contacto
        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
        // Agregar el contacto
        agregarContacto(nuevoContacto);
    }
}


