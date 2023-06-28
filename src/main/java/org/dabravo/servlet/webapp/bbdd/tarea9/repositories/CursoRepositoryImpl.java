package org.dabravo.servlet.webapp.bbdd.tarea9.repositories;

import org.dabravo.servlet.webapp.bbdd.tarea9.models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements Repository<Curso> {
    private Connection conn;

    public CursoRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List listar() throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM cursos")) {
                while (rs.next()) {
                    Curso c = getCurso(rs);
                    cursos.add(c);
                }
            }
        }
        return cursos;
    }

    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> nombres = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos WHERE nombre like ?")) {

            stmt.setString(1, "%" + nombre + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Curso c = getCurso(rs);
                    nombres.add(c);
                }
            }
        }
        return nombres;
    }

    @Override
    public Curso porId(Long id) throws SQLException {
        Curso curso = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos WHERE id = ?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    curso = getCurso(rs);
                }
            }
        }
        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {

        String sql;

        if (curso.getId() != null && curso.getId() > 0) {
            sql = "UPDATE cursos SET nombre = ?, descripcion = ?, instructor = ?, duracion = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO cursos (nombre, descripcion, instructor, duracion) VALUES (?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getInstructor());
            stmt.setDouble(4, curso.getDuracion());

            if (curso.getId() != null && curso.getId() > 0) {
                stmt.setLong(5, curso.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM cursos WHERE id = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

    }

    private static Curso getCurso(ResultSet rs) throws SQLException {
        Curso c = new Curso();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setInstructor(rs.getString("instructor"));
        c.setDuracion(rs.getDouble("duracion"));
        return c;
    }
}
