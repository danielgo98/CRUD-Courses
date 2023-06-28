package org.dabravo.servlet.webapp.bbdd.tarea9.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.dabravo.servlet.webapp.bbdd.tarea9.exceptions.ServiceJdbcException;
import org.dabravo.servlet.webapp.bbdd.tarea9.utils.ConexionBaseDatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try(Connection conn = ConexionBaseDatos.getConnection()) {

            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try{
                request.setAttribute("conn", conn);
                chain.doFilter(request, response);
                conn.commit();

            }catch (SQLException | ServiceJdbcException e){
                conn.rollback();
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
