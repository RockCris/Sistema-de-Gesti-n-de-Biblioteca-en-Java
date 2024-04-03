package Usuario;
public class Usuario {
    private String nombre;
    private int identificador;

    public Usuario(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }
}
