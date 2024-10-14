package es.iesoretania.listviewpersonalizado;

public class Personas {
    private String nombre;
    private String apellidos;
    private String sexo;
    private String ciclo;

    public Personas(String nombre, String apellidos, String sexo, String ciclo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellidos() {
        return apellidos;
    }


    public String getSexo() {
        return sexo;
    }

    public String getCiclo() {
        return ciclo;
    }

}
