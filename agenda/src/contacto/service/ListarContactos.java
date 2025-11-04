package contacto.service;

import contacto.model.Contacto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListarContactos {

    // Lista estática que almacena todos los contactos registrados en memoria
    public static final List<Contacto> contacto = new ArrayList<>();

    // Método para obtener la lista completa de contactos
    public List<Contacto> getContactos() {
        return contacto;
    }

    // Método principal que muestra los contactos registrados
    public void listarContactos(){
        // Si la lista está vacía, se muestra un mensaje y se termina la ejecución del método
        if (contacto.isEmpty()){
            System.out.println("No hay contactos registrados en la agenda");
            return;
        }

        // Ordena la lista de contactos alfabéticamente:
        // primero por nombre (ignorando mayúsculas/minúsculas)
        // y luego por apellido (también sin distinguir mayúsculas/minúsculas)
        contacto.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        // Muestra por consola todos los contactos ordenados
        System.out.println("Lista de contactos:");
        for (Contacto contacto : contacto) {
            // Se imprime el nombre completo y el número telefónico de cada contacto
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
        }
    }

    // Método "ejecutar" pensado para integrarse con un menú principal del sistema
    // Llama internamente al método listarContactos()
    public void ejecutar() {
        System.out.println("** Contactos **");
        listarContactos();
    }

}
