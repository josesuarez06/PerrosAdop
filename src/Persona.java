import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre, apellido, documento;
    private int edad;
    private List<Perro> perros = new ArrayList<>();



    public boolean adoptarPerro(Perro perro) {
        if (perros.size() < 3) {
            perros.add(perro);
            return true;
        }
        return false;

    }

    public Persona(String nombre, String apellido, String documento, int edad, List<Perro> perros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.perros = perros;
    }

    public Perro perroMasGrande() {
        if (perros.isEmpty())return null;
        Perro mayor = perros.get(0);
        for (Perro p : perros){
            if (p.getEdad() > mayor.getEdad()){
                mayor = p;
        }

        }
        return mayor;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", perros=" + perros +
                '}';
    }
}
