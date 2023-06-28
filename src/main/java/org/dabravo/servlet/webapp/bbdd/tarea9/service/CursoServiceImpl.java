package org.dabravo.servlet.webapp.bbdd.tarea9.service;

import org.dabravo.servlet.webapp.bbdd.tarea9.exceptions.ServiceJdbcException;
import org.dabravo.servlet.webapp.bbdd.tarea9.models.Curso;
import org.dabravo.servlet.webapp.bbdd.tarea9.repositories.CursoRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService{
    private CursoRepositoryImpl cursoRepository;

    public CursoServiceImpl(Connection connection) {
        this.cursoRepository = new CursoRepositoryImpl(connection);
    }


    @Override
    public List<Curso> listar() {
        try{
            return cursoRepository.listar();
        }catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try{
            return cursoRepository.porNombre(nombre);
        }catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {

        try {
            return Optional.ofNullable(cursoRepository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            cursoRepository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            cursoRepository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
