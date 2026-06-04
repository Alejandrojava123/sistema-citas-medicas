public class Administrador {

    private String usuario;
    private String password;

    public Administrador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public boolean login(String usuario,
                         String password) {

        return this.usuario.equals(usuario)
                && this.password.equals(password);
    }
}