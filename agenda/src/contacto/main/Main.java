package contacto.main;
import contacto.model.Contacto;
import contacto.service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE CONTACTOS ===");
            System.out.println("Para realizar una acción en tus contactos, digite alguna de las siguientes acciones: ");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Contacto existente");
            System.out.println("3. Todos los contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar contacto");
            System.out.println("7. Agenda llena");
            System.out.println("8. Espacio en agenda");
            System.out.println("0. Salir");
            System.out.println("INGRESA EL NUMERO DE LA OPCIÓN QUE DESEAS EJECUTAR: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            String nombre;
            String apellido;
            String numero;
            switch (opcion){
                case 1:
                    AgregarContacto agregarContacto = new AgregarContacto();
                    agregarContacto.ejecutar();
                    break;
                case 2:
                    ExisteContacto existeContacto = new ExisteContacto();
                    existeContacto.ejecutar();
                    break;
                case 3:
                    ListarContactos listarContactos = new ListarContactos();
                    listarContactos.ejecutar();
                    break;
                case 4:
                    BuscaContacto buscaContacto = new BuscaContacto();
                    buscaContacto.ejecutar();
                    break;
                case 5:
                    EliminarContacto eliminarContacto = new EliminarContacto();
                    eliminarContacto.ejecutar();
                    break;
                case 6:
                    ModificarTelefono modificarTelefono = new ModificarTelefono();
                    modificarTelefono.ejecutar();
                    break;
                case 7:
                    AgendaLlena agendaLlena = new AgendaLlena();
                    agendaLlena.ejecutar();
                    break;
                case 8:
                    EspacioLibre espacioLibre = new EspacioLibre();
                    espacioLibre.ejecutar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, digita el numero de la opción deseada.");
                    break;
            }
        } while (opcion != 0);
    }
}
