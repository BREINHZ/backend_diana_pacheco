package pruebatecnicadiana.prueba.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.dto.AlumnoDTO;
import pruebatecnicadiana.prueba.entity.Alumno;
import pruebatecnicadiana.prueba.mapper.AlumnoMapper;
import pruebatecnicadiana.prueba.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final AlumnoMapper alumnoMapper;

    // Crear alumno
    @PostMapping
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO creado = alumnoMapper.toDTO(
                alumnoService.crearAlumno(alumnoMapper.toEntity(alumnoDTO))
        );
        return ResponseEntity.ok(creado);
    }

    // Listar todos los alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> listarAlumnos() {
        List<AlumnoDTO> dtos = alumnoService.listarAlumnos()
                .stream()
                .map(alumnoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // Obtener alumno por id
 @GetMapping("/{id}")
public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Long id) {
    Optional<Alumno> alumnoOpt = alumnoService.obtenerAlumnoPorId(id);
    if (alumnoOpt.isPresent()) {
        return ResponseEntity.ok(alumnoMapper.toDTO(alumnoOpt.get()));
    } else {
        return ResponseEntity.status(404).body("Alumno no encontrado con id " + id);
    }
}


    // Actualizar alumno
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO actualizado = alumnoMapper.toDTO(
                alumnoService.actualizarAlumno(id, alumnoMapper.toEntity(alumnoDTO))
        );
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar alumnos por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<AlumnoDTO>> buscarAlumnosPorNombre(@RequestParam String nombre) {
        List<AlumnoDTO> dtos = alumnoService.buscarAlumnosPorNombre(nombre)
                .stream()
                .map(alumnoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
