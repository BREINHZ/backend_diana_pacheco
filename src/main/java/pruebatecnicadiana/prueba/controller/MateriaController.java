package pruebatecnicadiana.prueba.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.dto.MateriaDTO;
import pruebatecnicadiana.prueba.entity.Materia;
import pruebatecnicadiana.prueba.mapper.MateriaMapper;
import pruebatecnicadiana.prueba.service.MateriaService;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor // genera el constructor para los final
@CrossOrigin(origins = "*")
public class MateriaController {

    private final MateriaService materiaService;
    private final MateriaMapper materiaMapper;

    @PostMapping
    public ResponseEntity<?> crearMateria(@RequestBody MateriaDTO dto) {
        try {
            Materia materia = materiaMapper.toEntity(dto);
            Materia creada = materiaService.crearMateria(materia);
            return ResponseEntity.ok(materiaMapper.toDTO(creada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear materia: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarMaterias() {
        try {
            List<MateriaDTO> dtos = materiaService.listarMaterias()
                    .stream()
                    .map(materiaMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al listar materias: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMateriaPorId(@PathVariable Long id) {
        try {
            Optional<Materia> opt = materiaService.obtenerMateriaPorId(id);
            if (opt.isPresent()) {
                return ResponseEntity.ok(materiaMapper.toDTO(opt.get()));
            } else {
                return ResponseEntity.status(404).body("Materia no encontrada con id " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al obtener materia: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMateria(@PathVariable Long id, @RequestBody MateriaDTO dto) {
        try {
            Materia materiaActualizada = materiaMapper.toEntity(dto);
            Materia actualizado = materiaService.actualizarMateria(id, materiaActualizada);
            return ResponseEntity.ok(materiaMapper.toDTO(actualizado));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al actualizar materia: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMateria(@PathVariable Long id) {
        try {
            materiaService.eliminarMateria(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al eliminar materia: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarMateriasPorNombre(@RequestParam String nombre) {
        try {
            List<MateriaDTO> dtos = materiaService.buscarMateriasPorNombre(nombre)
                    .stream()
                    .map(materiaMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al buscar materias: " + e.getMessage());
        }
    }
}
