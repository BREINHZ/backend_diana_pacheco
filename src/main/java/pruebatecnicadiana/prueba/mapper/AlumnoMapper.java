package pruebatecnicadiana.prueba.mapper;

import org.springframework.stereotype.Component;

import pruebatecnicadiana.prueba.dto.AlumnoDTO;
import pruebatecnicadiana.prueba.entity.Alumno;

@Component
public class AlumnoMapper {

    // Convierte Alumno → AlumnoDTO usando builder
    public AlumnoDTO toDTO(Alumno alumno) {
        if (alumno == null) return null;

        return AlumnoDTO.builder()
                .id(alumno.getId())
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .email(alumno.getEmail())
                .fechaNacimiento(alumno.getFechaNacimiento())
                .build();
    }

    // Convierte AlumnoDTO → Alumno usando builder
    public Alumno toEntity(AlumnoDTO dto) {
        if (dto == null) return null;

        return Alumno.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .fechaNacimiento(dto.getFechaNacimiento())
                .build();
    }
}




