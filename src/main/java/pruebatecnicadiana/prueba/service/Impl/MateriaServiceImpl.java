package pruebatecnicadiana.prueba.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pruebatecnicadiana.prueba.entity.Materia;
import pruebatecnicadiana.prueba.repository.MateriaRepository;
import pruebatecnicadiana.prueba.service.MateriaService;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    @Override
    public List<Materia> listarMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public Optional<Materia> obtenerMateriaPorId(Long id) {
        return materiaRepository.findById(id);
    }

    @Override
    public List<Materia> buscarMateriasPorNombre(String nombre) {
        return materiaRepository.buscarMateriasPorNombre(nombre);
    }

    @Override
    public Materia crearMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia actualizarMateria(Long id, Materia materiaActualizada) {
        return materiaRepository.findById(id)
                .map(materia -> {
                    materia.setNombre(materiaActualizada.getNombre());
                    materia.setCodigo(materiaActualizada.getCodigo());
                    materia.setCreditos(materiaActualizada.getCreditos());
                    return materiaRepository.save(materia);
                })
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con id: " + id));
    }

    @Override
    public void eliminarMateria(Long id) {
        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("Materia no encontrada con id: " + id);
        }
        materiaRepository.deleteById(id);
    }
}

