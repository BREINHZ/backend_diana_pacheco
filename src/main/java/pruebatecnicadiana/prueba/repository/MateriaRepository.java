package pruebatecnicadiana.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pruebatecnicadiana.prueba.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    @Query("SELECT m FROM Materia m WHERE LOWER(m.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Materia> buscarMateriasPorNombre(@Param("nombre") String nombre);
}

