package contacto.service;

import contacto.exceptions.ExceptionContactoNoExiste;
import contacto.model.Contacto;

public class EliminarContacto {
    ListarContactos listaContactos = new ListarContactos();
    BuscaContacto buscarContacto = new BuscaContacto();

    //Eliminar contacto por nombre
    public void eliminarContacto(String nombreBuscado, String apellidoBuscado) {
        Contacto encontrarContacto = buscarContacto.buscar(listaContactos.contacto, nombreBuscado, apellidoBuscado);
        boolean eliminar = listaContactos.contacto.remove(encontrarContacto);
        if (eliminar) {
            System.out.println("Se elimino exitosamente el contacto" + encontrarContacto.getNombre() + " " + encontrarContacto.getApellido());
        }
        throw new ExceptionContactoNoExiste("Contacto no encontrado, verifique el nombre para eliminar de su agenda.");
    }
}
