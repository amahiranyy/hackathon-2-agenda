package contacto.service;

import contacto.model.Contacto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListarContactos {
    // Lista de todos los contactos registrados
    public final List<Contacto> contactos = new ArrayList<>();

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void AgregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    public void listarContactos(){
        if (contactos.isEmpty()){
            System.out.println("No hay contactos registrados en la agenda");
            return;
        }
        contactos.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        System.out.println("Lista de contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
        }

    }

}
