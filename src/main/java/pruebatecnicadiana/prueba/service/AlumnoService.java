package pruebatecnicadiana.prueba.service;

import java.util.List;
import java.util.Optional;

import pruebatecnicadiana.prueba.entity.Alumno;

public interface AlumnoService {


    Alumno crearAlumno(Alumno alumno);
    List<Alumno> listarAlumnos();
    Optional<Alumno> obtenerAlumnoPorId(Long id);
    Alumno actualizarAlumno(Long id, Alumno alumnoActualizado);
    void eliminarAlumno(Long id);
    List<Alumno> buscarAlumnosPorNombre(String nombre);
}

