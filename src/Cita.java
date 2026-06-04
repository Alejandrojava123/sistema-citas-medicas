public class Cita {

    private String id;
    private String fecha;
    private String hora;
    private String motivo;

    private Doctor doctor;
    private Paciente paciente;

    public Cita(String id,
                String fecha,
                String hora,
                String motivo,
                Doctor doctor,
                Paciente paciente) {

        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    @Override
    public String toString() {

        return id + "," +
                fecha + "," +
                hora + "," +
                motivo + "," +
                doctor.getNombre() + "," +
                paciente.getNombre();
    }
}
