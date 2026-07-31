package pruebatecnicadiana.prueba.service;

import java.util.List;
import java.util.Optional;

import pruebatecnicadiana.prueba.entity.Materia;

public interface MateriaService {

    Materia crearMateria(Materia materia);
    List<Materia> listarMaterias();
    Optional<Materia> obtenerMateriaPorId(Long id);
    Materia actualizarMateria(Long id, Materia materiaActualizada);
    void eliminarMateria(Long id);
    List<Materia> buscarMateriasPorNombre(String nombre);
}
