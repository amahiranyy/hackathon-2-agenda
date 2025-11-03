package contacto.main;
import contacto.service.*;

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

            opcion= scanner.nextInt();
            scanner.nextInt();

            switch (opcion){
                case 1 -> AñadirContacto.ejecutar();
                case 2 -> ExisteContacto.ejecutar();
                case 3 -> ListarContactos.ejecutar();
                case 4 -> BuscaContacto.ejecutar();
                case 5 -> EliminarContacto.ejecutar();
                case 6 -> ModificarTelefono.ejecutar();
                case 7 -> AgendaLlena.ejecutar();
                case 8 -> {
                    EspacioLibre espacio = new EspacioLibre();
                    int libre = espacio.espacioLibre();
                    System.out.println("Espacio libre: " + libre + " contactos disponibles.");
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, digita el numero de la opción deseada.");
            }




        } while (opcion != 0);
    }
}
