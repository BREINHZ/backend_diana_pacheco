package pruebatecnicadiana.prueba.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MateriaDTO {
    private Long id;
    private String nombre;
    private String codigo;
    private Integer creditos;
}




