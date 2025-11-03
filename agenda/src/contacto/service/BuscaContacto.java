package contacto.service;

import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;

import java.util.List;

public class BuscaContacto {
    public Contacto buscar(List<Contacto> contacto, String nombreBuscado, String apellidoBuscado) throws ExceptionContactoNoExiste {
        String nombreBuscado = nombre == null ? "" : nombre.trim().toLowerCase() ;
        String apellidoBuscado = apellido == null ? "" : apellido.trim().toLowerCase();
        for (Contacto contactoActual : contactos){
            String nombreActual = contactoActual.getNombre() == null ? "" : contactoActual.getNombre().trim().toLowerCase();
            String apellidoActual = contactoActual.getApellido() == null ? "" : contactoActual.getApellido().trim().toLowerCase() ;
            if  (nombreActual.equals(nombreBuscado) && apellidoActual.equals(apellidoBuscado)){
                return contactoActual;
            }
        }
        throw new ExceptionContactoNoExiste("El contacto no existe");
    }
}