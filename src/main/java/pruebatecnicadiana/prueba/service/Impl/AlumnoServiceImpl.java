package pruebatecnicadiana.prueba.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.entity.Alumno;
import pruebatecnicadiana.prueba.repository.AlumnoRepository;
import pruebatecnicadiana.prueba.service.AlumnoService;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public List<Alumno> buscarAlumnosPorNombre(String nombre) {
        return alumnoRepository.buscarAlumnosPorNombre(nombre);
    }

    @Override
    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizarAlumno(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombre(alumnoActualizado.getNombre());
                    alumno.setApellido(alumnoActualizado.getApellido());
                    alumno.setEmail(alumnoActualizado.getEmail());
                    alumno.setFechaNacimiento(alumnoActualizado.getFechaNacimiento());
                    return alumnoRepository.save(alumno);
                })
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
    }

    @Override
    public void eliminarAlumno(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Alumno no encontrado con id: " + id);
        }
        alumnoRepository.deleteById(id);
    }
}

