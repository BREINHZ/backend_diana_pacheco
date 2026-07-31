package pruebatecnicadiana.prueba.mapper;

import org.springframework.stereotype.Component;

import pruebatecnicadiana.prueba.dto.NotaDTO;
import pruebatecnicadiana.prueba.entity.Alumno;
import pruebatecnicadiana.prueba.entity.Materia;
import pruebatecnicadiana.prueba.entity.Nota;

@Component
public class NotaMapper {

    // Convierte de entidad a DTO
    public NotaDTO toDTO(Nota nota) {
        if (nota == null) return null;

        return NotaDTO.builder()
                .id(nota.getId())
                .valor(nota.getValor())
                .fechaRegistro(nota.getFechaRegistro())
                .alumnoId(nota.getAlumno() != null ? nota.getAlumno().getId() : null)
                .alumnoNombre(nota.getAlumno() != null ? nota.getAlumno().getNombre() : null)
                .materiaId(nota.getMateria() != null ? nota.getMateria().getId() : null)
                .materiaNombre(nota.getMateria() != null ? nota.getMateria().getNombre() : null)
                .build();
    }

    // Convierte de DTO a entidad (solo ids se asignan fuera del mapper)
    public Nota toEntity(NotaDTO dto) {
        if (dto == null) return null;

        return Nota.builder()
                .id(dto.getId())
                .valor(dto.getValor())
                .fechaRegistro(dto.getFechaRegistro())
                .alumno(dto.getAlumnoId() != null ? Alumno.builder().id(dto.getAlumnoId()).build() : null)
                .materia(dto.getMateriaId() != null ? Materia.builder().id(dto.getMateriaId()).build() : null)
                .build();
    }

}
