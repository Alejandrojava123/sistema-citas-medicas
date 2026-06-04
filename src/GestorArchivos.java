import java.io.FileWriter;
import java.io.IOException;

public class GestorArchivos {

    public static void guardarDoctor(Doctor doctor) {

        try (FileWriter fw = new FileWriter("doctores.csv", true)) {

            fw.write(doctor.toString() + "\n");

        } catch (IOException e) {

            System.out.println("Error al guardar doctor.");
        }
    }

    public static void guardarPaciente(Paciente paciente) {

        try (FileWriter fw = new FileWriter("pacientes.csv", true)) {

            fw.write(paciente.toString() + "\n");

        } catch (IOException e) {

            System.out.println("Error al guardar paciente.");
        }
    }

    public static void guardarCita(Cita cita) {

        try (FileWriter fw = new FileWriter("citas.csv", true)) {

            fw.write(cita.toString() + "\n");

        } catch (IOException e) {

            System.out.println("Error al guardar cita.");
        }
    }
}