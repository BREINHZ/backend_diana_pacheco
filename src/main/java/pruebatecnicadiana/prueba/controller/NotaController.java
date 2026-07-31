package pruebatecnicadiana.prueba.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.dto.NotaDTO;
import pruebatecnicadiana.prueba.mapper.NotaMapper;
import pruebatecnicadiana.prueba.service.NotaService;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotaController {

    private final NotaService notaService;
    private final NotaMapper notaMapper;

    @PostMapping
    public ResponseEntity<NotaDTO> registrarNota(@RequestBody NotaDTO dto) {
        var nota = notaMapper.toEntity(dto);
        var registrada = notaService.registrarNota(nota);
        return ResponseEntity.ok(notaMapper.toDTO(registrada));
    }

    @PostMapping("/listar-por-alumno")
    public ResponseEntity<List<NotaDTO>> listarNotasPorAlumno(@RequestBody Map<String, Long> request) {
        Long alumnoId = request.get("alumnoId"); // obtenemos el alumnoId del map
        if (alumnoId == null) {
            return ResponseEntity.badRequest().build(); // devuelve 400 si no viene
        }

        var notas = notaService.listarNotasPorAlumno(alumnoId);
        var dtos = notas.stream()
                .map(notaMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}
