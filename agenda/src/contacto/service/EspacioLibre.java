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
    // Método ejecutar para integración con el menú
    public void ejecutar() {
        System.out.println("** Espacio en agenda **");
        int espacio = espacioLibre();
        if (espacio > 0) {
            System.out.println("Espacio disponible: puedes agregar " + espacio + " contacto(s) más.");
        } else {
            System.out.println("La agenda está llena. No puedes agregar más contactos.");
        }
    }

}
