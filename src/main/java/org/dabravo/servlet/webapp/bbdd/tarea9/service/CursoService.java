package org.dabravo.servlet.webapp.bbdd.tarea9.service;

import org.dabravo.servlet.webapp.bbdd.tarea9.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
    Optional<Curso> porId(Long id);
    void guardar (Curso curso);
    void eliminar(Long id);
}
