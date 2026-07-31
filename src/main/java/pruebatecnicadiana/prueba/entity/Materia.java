package pruebatecnicadiana.prueba.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "materias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private Integer creditos;

    @OneToMany(
            mappedBy = "materia",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Nota> notas;
}

