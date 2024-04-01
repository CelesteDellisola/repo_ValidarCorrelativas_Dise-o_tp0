
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class InscripcionTest {

    @Test
    public void testAprobada_SinCorrelativas() {
        Alumno alumno = new Alumno("Pedro");
        Materia materia1 = new Materia("Matemáticas", false);
        Materia materia2 = new Materia("Historia", false);

        alumno.inscribir(materia1);
        alumno.inscribir(materia2);

        assertTrue(alumno.aprobada());
    }

    @Test
    public void testAprobada_ConCorrelativas() {
        Alumno alumno = new Alumno("Juan");
        Materia correlativa = new Materia("Correlativa", true);
        Materia materia = new Materia("Materia", false);

        alumno.inscribir(correlativa);
        alumno.inscribir(materia);

        assertFalse(alumno.aprobada());
    }

    @Test
    public void testAprobada_MismasCorrelativas() {
        Alumno alumno = new Alumno("María");
        Materia correlativa1 = new Materia("Correlativa 1", true);
        Materia correlativa2 = new Materia("Correlativa 2", true);
        Materia materia = new Materia("Materia", false);

        alumno.inscribir(correlativa1);
        alumno.inscribir(correlativa2);
        alumno.inscribir(materia);

        assertFalse(alumno.aprobada());
    }

    @Test
    public void testAprobada_TodasCorrelativasAprobadas() {
        Alumno alumno = new Alumno("Laura");
        Materia correlativa1 = new Materia("Correlativa 1", true);
        Materia correlativa2 = new Materia("Correlativa 2", true);
        Materia materia = new Materia("Materia", false);

        alumno.inscribir(correlativa1);
        alumno.inscribir(correlativa2);
        alumno.inscribir(materia);
        alumno.inscribir(correlativa1);
        alumno.inscribir(correlativa2);

        assertTrue(alumno.aprobada());
    }
}
