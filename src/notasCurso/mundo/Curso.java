/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: notas de un curso
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package notasCurso.mundo;

/**
 * Clase que representa un curso.
 */
public class Curso {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Total de estudiantes en el curso.
     */
    public final static int TOTAL_EST = 12;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Notas de los estudiantes.
     */
    private double[] notas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo curso, inicializando todas las notas en cero.
     */
    public Curso() {
        notas = new double[TOTAL_EST];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = 0.0;
        }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Calcula el promedio del curso.
     *
     * @return Promedio de todas las notas del curso. promedio >= 0.
     */
    public double promedio() {
        double promedio = 0;

        for (int i = 0; i < notas.length; i++) {
            promedio += notas[i];
        }
        promedio /= TOTAL_EST;

        return promedio;
    }

    /**
     * Devuelve el n�mero de estudiantes que tienen la nota mayor al promedio.
     *
     * @return N�mero de estudiantes que tienen la nota mayor al promedio. n�mero >= 0.
     */
    public int darCantidadSobrePromedio() {
        int cantidad = 0;
        double promedio = promedio();

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > promedio) {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
     * Devuelve la nota de un estudiante del curso.
     *
     * @param pNumEstudiante N�mero del estudiante : 1 <= estudiante <= 12.
     * @return Nota del estudiante.
     */
    public double darNota(int pNumEstudiante) {
        return notas[pNumEstudiante - 1];
    }

    /**
     * Cambia la nota de un estudiante en el curso.
     *
     * @param pNumEstudiante N�mero del estudiante. 1 <= estudiante <= 12.
     * @param pNota          Nota del estudiante.
     *
     * OJO: La nota debe estar entre 0 y 100
     */
    public void cambiarNota(int pNumEstudiante, double pNota) {
        if (pNota >= 0 && pNota <= 100) {
            notas[pNumEstudiante - 1] = pNota;
        }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------
    /**
     * Obtener la cantidad de estudiantes que no pasaron el curso
     * Recuerde que la nota m�nima para pasar el curso es 60.0
     */
    public int cantidadReprobados() {
        int cantidadReprobados = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 60.0) {
                cantidadReprobados++;
            }
        }

        return cantidadReprobados;
    }

    /**
     * Obtener la mejor nota del curso.
     */
    public double mejorNota() {
        double mejorNota = 0.0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > mejorNota) {
                mejorNota = notas[i];
            }
        }

        return mejorNota;
    }

    /**
     * Obtener el porcentaje de estudiantes que pasaron el curso
     * Debe ser un n�mero entre 0 y 100.
     */
    public double darPorcentajePasaron() {
        int cantidadAprobados = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 60.0) {
                cantidadAprobados++;
            }
        }

        return (double) cantidadAprobados * 100 / TOTAL_EST;
    }

    /**
     * Determinar si todos los estudiantes del curso pasaron la materia
     * Retorna true si todos tuvieron notas aprobatorias, o false cuando al menos
     * un estudiante reprob� la materia.
     * Recuerde que para pasar la nota, esta nota debe ser m�nimo 60.0
     */
    public boolean todosPasaron() {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 60.0) {
                return false;
            }
        }
        return true;
    }
    
}