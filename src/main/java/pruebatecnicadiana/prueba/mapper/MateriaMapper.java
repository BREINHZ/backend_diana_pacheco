package pruebatecnicadiana.prueba.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import pruebatecnicadiana.prueba.dto.MateriaDTO;
import pruebatecnicadiana.prueba.entity.Materia;

@Component
public class MateriaMapper {

    // Convierte de entidad a DTO usando builder
    public MateriaDTO toDTO(Materia materia) {
        if (materia == null) return null;

        return MateriaDTO.builder()
                .id(materia.getId())
                .nombre(materia.getNombre())
                .codigo(materia.getCodigo())
                .creditos(materia.getCreditos())
                .build();
    }

    // Convierte de DTO a entidad usando builder
    public Materia toEntity(MateriaDTO dto) {
        if (dto == null) return null;

        return Materia.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .codigo(dto.getCodigo())
                .creditos(dto.getCreditos())
                .notas(new ArrayList<>()) // inicializamos la lista vacía
                .build();
    }
}




