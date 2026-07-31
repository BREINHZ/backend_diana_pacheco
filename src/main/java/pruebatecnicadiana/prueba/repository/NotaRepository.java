package pruebatecnicadiana.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pruebatecnicadiana.prueba.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT n FROM Nota n WHERE n.alumno.id = :alumnoId")
    List<Nota> findNotasByAlumnoId(@Param("alumnoId") Long alumnoId);
}

