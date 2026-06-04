import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCitas {

    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    private Scanner scanner;

    public SistemaCitas() {

        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();

        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        Administrador admin = new Administrador("admin", "1234");

        System.out.println("===== LOGIN =====");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (!admin.login(usuario, password)) {

            System.out.println("Acceso denegado.");
            return;
        }

        menu();
    }

    private void menu() {

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar Doctor");
            System.out.println("2. Registrar Paciente");
            System.out.println("3. Crear Cita");
            System.out.println("4. Mostrar Doctores");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarDoctor();
                    break;

                case 2:
                    registrarPaciente();
                    break;

                case 3:
                    crearCita();
                    break;

                case 4:
                    mostrarDoctores();
                    break;

                case 5:
                    mostrarPacientes();
                    break;

                case 6:
                    mostrarCitas();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);
    }

    private void registrarDoctor() {

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombre, especialidad);

        doctores.add(doctor);

        GestorArchivos.guardarDoctor(doctor);

        System.out.println("Doctor registrado correctamente.");
    }

    private void registrarPaciente() {

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombre);

        pacientes.add(paciente);

        GestorArchivos.guardarPaciente(paciente);

        System.out.println("Paciente registrado correctamente.");
    }

    private void crearCita() {

        if (doctores.isEmpty()) {

            System.out.println("No hay doctores registrados.");
            return;
        }

        if (pacientes.isEmpty()) {

            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.print("ID de la cita: ");
        String id = scanner.nextLine();

        System.out.print("Fecha (dd/mm/yyyy): ");
        String fecha = scanner.nextLine();

        System.out.print("Hora (hh:mm): ");
        String hora = scanner.nextLine();

        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();

        Doctor doctor = doctores.get(0);
        Paciente paciente = pacientes.get(0);

        Cita cita = new Cita(
                id,
                fecha,
                hora,
                motivo,
                doctor,
                paciente
        );

        citas.add(cita);

        GestorArchivos.guardarCita(cita);

        System.out.println("Cita registrada correctamente.");
    }

    private void mostrarDoctores() {

        System.out.println("\n--- LISTA DE DOCTORES ---");

        for (Doctor doctor : doctores) {
            System.out.println(doctor);
        }
    }

    private void mostrarPacientes() {

        System.out.println("\n--- LISTA DE PACIENTES ---");

        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    private void mostrarCitas() {

        System.out.println("\n--- LISTA DE CITAS ---");

        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }
}