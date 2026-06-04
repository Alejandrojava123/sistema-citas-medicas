public class Doctor extends Persona {

    private String especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + especialidad;
    }
}