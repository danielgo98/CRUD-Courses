package org.dabravo.servlet.webapp.bbdd.tarea9.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dabravo.servlet.webapp.bbdd.tarea9.models.Curso;
import org.dabravo.servlet.webapp.bbdd.tarea9.service.CursoService;
import org.dabravo.servlet.webapp.bbdd.tarea9.service.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        Curso curso = new Curso();

        if(id > 0){
            Optional<Curso> o = service.porId(id);
            if(o.isPresent()){
                curso = o.get();
            }
        }

        req.setAttribute("curso", curso);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);

        String nombre = req.getParameter("nombre");
        String instructor = req.getParameter("instructor");
        double duracion;

        try{
            duracion = Double.parseDouble(req.getParameter("duracion"));
        }catch (NumberFormatException e){
            duracion = 0;
        }

        String descripcion = req.getParameter("descripcion");
        Map<String, String> errores = new HashMap<>();

        if(nombre == null || nombre.isBlank()){
            errores.put("nombre", "El campo nombre es requerido");
        }

        if(instructor == null || instructor.isBlank()){
            errores.put("instructor", "El campo instructor es requerido");
        }

        if(duracion == 0){
            errores.put("duracion", "El campo duracion es requerido");
        }

        if(descripcion == null || descripcion.isBlank()){
            errores.put("descripcion", "El campo descripcion es requerido");
        }

        Long id;
        try{
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);
        curso.setDescripcion(descripcion);

        if(errores.isEmpty()){
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        }else{
            req.setAttribute("errores", errores);
            req.setAttribute("titulo", id > 0 ? "Editar curso" : "Crear Curso");
            req.setAttribute("curso", curso);

            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
