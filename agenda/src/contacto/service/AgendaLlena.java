package contacto.service;
import contacto.exceptions.ExceptionAgendaLlena;
import contacto.service.ListarContactos;

public class AgendaLlena {
    ListarContactos listaContactos = new ListarContactos();
    EspacioLibre espacioLibre = new EspacioLibre();

    public int agendaLlena() {
        int numeroEspacio = espacioLibre.espacioLibre();

        if (numeroEspacio > 0) {
            System.out.println("✅ Puedes agregar otros " + numeroEspacio + " contacto(s).");
            return numeroEspacio;
        } else {
            throw new ExceptionAgendaLlena("❌ Su agenda está llena. Verifique su lista de contactos.");
        }
    }
    public void ejecutar() {
        System.out.println("** Espacio en agenda **");
        try {
            agendaLlena(); // Muestra el mensaje si hay espacio
        } catch (ExceptionAgendaLlena e) {
            System.out.println(e.getMessage()); // Muestra el mensaje si está llena
        }
    }

}
