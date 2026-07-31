package pruebatecnicadiana.prueba.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaDTO {

    private Long id;
    private Double valor;
    private LocalDate fechaRegistro;

    private Long alumnoId;       // para relacionar al alumno
    private String alumnoNombre; // opcional, para mostrar en el DTO

    private Long materiaId;      // para relacionar a la materia
    private String materiaNombre;// opcional
}



