package contacto.service;

import contacto.exceptions.ExceptionContactoExistente;
import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;

import java.util.Scanner;

public class ExisteContacto {
    public boolean existeContacto(String nombre, String apellido) {
        ListarContactos listarContactos = new ListarContactos();
        for (Contacto c : listarContactos.contacto) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                return true; // Se encontró el contacto
            }
        }
        return false; // No se encontró ningún contacto con ese nombre y apellido
    }

    // Método ejecutar para integración con el menú
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Verificar si existe un contacto **");
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del contacto: ");
        String apellido = scanner.nextLine();
        boolean existe = existeContacto(nombre, apellido);
        if (existe) {
            System.out.println("✅ El contacto " + nombre + " " + apellido + " SÍ existe.");
        } else {
            System.out.println("❌ El contacto " + nombre + " " + apellido + " NO existe.");
        }
    }
}
