package contacto.service;

import contacto.model.Contacto;

public class EspacioLibre {
    ListarContactos listaContactos = new ListarContactos();

    // Muestra cuántos contactos más se pueden agregar a la agenda.
    public int espacioLibre(){
        int maximo = 10;
        int contactosExistentes = listaContactos.contacto.size(); // Se utiliza el método size() para obtener el número total de elementos
        return maximo-contactosExistentes;
    }
}
