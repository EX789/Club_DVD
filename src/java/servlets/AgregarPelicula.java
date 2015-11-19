/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.PeliculaDto;
import dao.*;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author raide
 */
public class AgregarPelicula extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            PeliculaDto dto = new PeliculaDto();
            dto.setNombre(request.getParameter("txtNombre"));
            dto.setFechaRegistro(Date.from(Instant.now()));
            dto.setAño(Integer.parseInt(request.getParameter("cbAno")));
            dto.setId_genero(Integer.parseInt(request.getParameter("cbSeleccionarGenero")));

            String mensaje = null;
            if (new PeliculaDaoImplementado().agregar(dto)) {
                mensaje = "Se agrego correctamente";
            } else {
                mensaje = "No se pudo agregar la pelicula, revise";
            }

            request.setAttribute("msn", mensaje);
            request.getRequestDispatcher("paginas/agregarPelicula.jsp").forward(request, response);
        }
//        } catch (Exception ex) {
//            mensaje = ex.getMessage();
//            request.setAttribute("msn", mensaje);
//            request.getRequestDispatcher("paginas/agregarPelicula.jsp").forward(request, response);
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
