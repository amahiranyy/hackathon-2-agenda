package contacto.service;

import contacto.model.Contacto;

public class AgregarContacto {
    private final ListarContactos listarContactos;

    public void agregarContacto(Contacto contacto) {
        ListarContactos listarContactos = new ListarContactos();
        ExisteContacto existeContacto = new ExisteContacto();

        if (existeContacto.existeContacto(contacto)== true) {
            System.out.println("El contacto ya existe, no se pudo registrar");
        }
        else {
            // Crear y agregar el contacto
            listarContactos.contacto.add(contacto);
            System.out.println("✅ Contacto añadido: " + contacto);
        }
    }
}
