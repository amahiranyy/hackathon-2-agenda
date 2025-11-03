package contacto.service;
import contacto.exceptions.ExceptionAgendaLlena;
import contacto.service.ListarContactos;

public class AgendaLlena {
    ListarContactos listaContactos = new ListarContactos();
    EspacioLibre espacioLibre = new EspacioLibre();

    public int agendaLlena() {
        int numeroEspacio = espacioLibre.espacioLibre();
        if (numeroEspacio > 0) {
            System.out.println("Puedes agregar otros " + numeroEspacio + " más.");
            }
        throw new ExceptionAgendaLlena("Su agenda esta llena, verifique su lista de contactos.");

    }
}
