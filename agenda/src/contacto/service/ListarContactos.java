package contacto.service;

import contacto.model.Contacto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListarContactos {
    // Lista de todos los contactos registrados
    public static final List<Contacto> contacto = new ArrayList<>();

    public List<Contacto> getContactos() {
        return contacto;
    }

    public void listarContactos(){
        if (contacto.isEmpty()){
            System.out.println("No hay contactos registrados en la agenda");
            return;
        }
        contacto.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        System.out.println("Lista de contactos:");
        for (Contacto contacto : contacto) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
        }

    }

    // Método ejecutar para integración con el menú
    public void ejecutar() {
        System.out.println("** Contactos **");
        listarContactos();
    }

}
