import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Persona> personas = new ArrayList<>();
    private static List<Perro> perrosDisponibles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("---  ---");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar perro más viejo adoptado");
            System.out.println("7. Salir");
            System.out.print("Eliga la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarPersona();
                case 2 -> registrarPerro();
                case 3 -> verPersonas();
                case 4 -> verPerros();
                case 5 -> adoptarPerro();
                case 6 -> consultarPerroMasViejo();
                case 7 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    private static void registrarPersona() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        personas.add(new Persona(nombre, apellido, edad, documento));
        System.out.println("Persona registrada.");
    }

    private static void registrarPerro() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tamaño: ");
        String tamaño = scanner.nextLine();

        perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamaño));
        System.out.println("Perro registrado.");
    }

    private static void verPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
    }

    private static void verPerros() {
        if (perrosDisponibles.isEmpty()) {
            System.out.println("No hay perros disponibles.");
        } else {
            for (Perro p : perrosDisponibles) {
                System.out.println(p);
            }
        }
    }

    private static void adoptarPerro() {
        System.out.print("Documento de la persona: ");
        String doc = scanner.nextLine();
        Persona persona = buscarPersona(doc);

        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }

        System.out.print("Placa del perro: ");
        String placa = scanner.nextLine();
        Perro perro = buscarPerro(placa);

        if (perro == null) {
            System.out.println("Perro no encontrado o ya fue adoptado.");
            return;
        }

        boolean adoptado = persona.adoptarPerro(perro);
        if (adoptado) {
            perrosDisponibles.remove(perro);
            System.out.println("Perro adoptado exitosamente.");
        } else {
            System.out.println("No puede adoptar más perros (máximo 3).");
        }
    }

    private static void consultarPerroMasViejo() {
        System.out.print("Documento de la persona: ");
        String doc = scanner.nextLine();
        Persona persona = buscarPersona(doc);

        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }

        Perro perroMayor = persona.perroMasGrande();
        if (perroMayor != null) {
            System.out.println("Perro más viejo adoptado: " + perroMayor);
        } else {
            System.out.println("La persona no ha adoptado perros.");
        }
    }

    private static Persona buscarPersona(String documento) {
        for (Persona p : personas) {
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                return p;
            }
        }
        return null;
    }

    private static Perro buscarPerro(String placa) {
        for (Perro p : perrosDisponibles) {
            if (p.getPlaca().equalsIgnoreCase(placa)) {
                return p;
            }
        }
        return null;
    }
}