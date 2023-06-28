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
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class CursoEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        long id;
        try{
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        if(id > 0){
            Optional<Curso> o = service.porId(id);
            if(o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/cursos");
            }else{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El curso no existe en la base de datos");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parámetro en la URL");
        }
    }
}
