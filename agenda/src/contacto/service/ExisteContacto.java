package contacto.service;

import contacto.model.Contacto;

public class ExisteContacto {
    public boolean existeContacto(String nombre, String apellido) {
        ListarContactos listarContactos = new ListarContactos();
        // Variable de verificación
        boolean verificacion = false;
        // Verificar si ya existe un contacto con el mismo nombre y apellido
        for (Contacto c : listarContactos.contacto) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("⚠️ Ya existe un contacto con ese nombre y apellido.");
                verificacion = true;
            }
        }
        return verificacion;
    }
}
