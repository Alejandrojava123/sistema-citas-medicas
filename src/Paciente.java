public class Paciente extends Persona {

    public Paciente(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String toString() {
        return id + "," + nombre;
    }
}