package pruebatecnicadiana.prueba.service;

import java.util.List;

import pruebatecnicadiana.prueba.entity.Nota;

public interface NotaService {

    Nota registrarNota(Nota nota);
    List<Nota> listarNotasPorAlumno(Long alumnoId);
    
}

