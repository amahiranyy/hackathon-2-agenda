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

    // Método principal que muestra los contactos registrados
    public void listarContactos(){
        if (contacto.isEmpty()){
            System.out.println("No hay contactos registrados en la agenda");
            return;
        }
        contacto.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        // Muestra por consola todos los contactos ordenados
        System.out.println("Lista de contactos:");
        for (Contacto contacto : contacto) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
        }
    }

    // Método "ejecutar" pensado para integrarse con un menú principal del sistema
    // Llama internamente al método listarContactos()
    public void ejecutar() {
        System.out.println("** Contactos **");
        listarContactos();
    }

    // Método ejecutar para integración con el menú
    public void ejecutar() {
        System.out.println("** Contactos **");
        listarContactos();
    }

}
