package pruebatecnicadiana.prueba.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.entity.Alumno;
import pruebatecnicadiana.prueba.entity.Materia;
import pruebatecnicadiana.prueba.entity.Nota;
import pruebatecnicadiana.prueba.repository.AlumnoRepository;
import pruebatecnicadiana.prueba.repository.MateriaRepository;
import pruebatecnicadiana.prueba.repository.NotaRepository;
import pruebatecnicadiana.prueba.service.NotaService;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final AlumnoRepository alumnoRepository;   // inyectar repositorio
    private final MateriaRepository materiaRepository; // inyectar repositorio

    @Override
    public Nota registrarNota(Nota nota) {

        // 1️⃣ Validar valor
        if (nota.getValor() < 1.0 || nota.getValor() > 5.0) {
            throw new IllegalArgumentException("El valor de la nota debe estar entre 1 y 5");
        }

        // 2️⃣ Asignar fecha si no existe
        if (nota.getFechaRegistro() == null) {
            nota.setFechaRegistro(LocalDate.now());
        }

        // 3️⃣ Asignar Alumno
        Long alumnoId = nota.getAlumno() != null ? nota.getAlumno().getId() : null;
        if (alumnoId == null) {
            throw new IllegalArgumentException("Alumno no especificado");
        }
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
        nota.setAlumno(alumno);

        // 4️⃣ Asignar Materia
        Long materiaId = nota.getMateria() != null ? nota.getMateria().getId() : null;
        if (materiaId == null) {
            throw new IllegalArgumentException("Materia no especificada");
        }
        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));
        nota.setMateria(materia);

        // 5️⃣ Guardar y retornar
        return notaRepository.save(nota);
    }

    @Override
    public List<Nota> listarNotasPorAlumno(Long alumnoId) {
        return notaRepository.findNotasByAlumnoId(alumnoId);
    }
}



