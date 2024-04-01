import java.util.ArrayList;
import java.util.List;

class Materia {
    private String nombre;
    private boolean correlativa;

    public Materia(String nombre, boolean correlativa) {
        this.nombre = nombre;
        this.correlativa = correlativa;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public boolean esCorrelativa() {
        return correlativa;
    }
}

class Alumno {
    String nombre;
    private List<Materia> materiasInscriptas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        materiasInscriptas = new ArrayList<>();
    }

    public void inscribir(Materia materia) {
        materiasInscriptas.add(materia);
    }

    public boolean aprobada() {
        for (Materia materia : materiasInscriptas) {
            if (materia.esCorrelativa()) {
                boolean aprobada = false;
                for (Materia correlativa : materiasInscriptas) {
                    if (correlativa.obtenerNombre().equals(materia.obtenerNombre())) {
                        aprobada = true;
                        break;
                    }
                }
                if (!aprobada) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Inscripcion {
    public static void main(String[] args) {
        Alumno un_alumno = new Alumno("Juan");
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos", false);
        Materia paradigmas = new Materia("Paradigmas de Programación", true);
        Materia disenio = new Materia("Diseño de Sistemas", true);

        un_alumno.inscribir(algoritmos);
        un_alumno.inscribir(paradigmas);
        un_alumno.inscribir(disenio);

        if (un_alumno.aprobada()) {
            System.out.println("El alumno puede inscribirse a las materias.");
        } else {
            System.out.println("El alumno no puede inscribirse a las materias debido a correlativas pendientes.");
        }
    }
}
